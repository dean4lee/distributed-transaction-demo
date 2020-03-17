package demo.transaction.cloud.eureka.seata.util;

/**
 * 雪花算法生成id
 * key为long类型，长度64位
 * 第一位为符号位，0
 * 41位时间戳
 * 5位groupid,0-31
 * 5位workid，0-31
 * 12位序列号，最大位4095
 *
 * 符号位    时间戳                                     groupid  workid  序列号
 * 0        00000000000000000000000000000000000000000 0000     0000    000000000000
 */
public final class SnowFlake {

    //开始时间
    private static final long START_TIME = 1583574474481L;

    //初始化的数据
    private long groupId;       //groupid
    private long workId;        //workid
    private long sequence = 0L; //序列号
    private long lastTime = -1L;//最后一次生成key的时间

    //占用的位数
    private static final long TIME_BIT = 41L;       //时间戳占用位数
    private static final long GROUP_BIT = 5L;       //groupid占用位数
    private static final long WORK_BIT = 5L;        //workid占用位数
    private static final long SEQUENCE_BIT = 12L;   //序列号占用位数

    //左移的位数
    private static final long WORK_LEFT = SEQUENCE_BIT;             //workid左移12位
    private static final long GROUP_LEFT = WORK_LEFT + WORK_BIT;    //groupid左移17位
    private static final long TIME_LEFT = GROUP_LEFT + GROUP_BIT;   //时间戳左移22位

    //最大值，即二进制多少位1计算出的十进制
    private static final long SEQUENCE_MAX = -1L ^ (-1L << SEQUENCE_BIT);
    private static final long WORK_MAX = -1L ^ (-1L << WORK_BIT);
    private static final long GROUP_MAX = -1L ^ (-1L << GROUP_BIT);

    //初始化需要传入groupId和workId
    public SnowFlake(long groupId, long workId) {
        if (groupId < 0 || groupId > GROUP_MAX) {
            throw new IllegalArgumentException("groupId Cannot be greater than " + GROUP_MAX + " and less than 0");
        }
        if (workId < 0 || workId > WORK_MAX) {
            throw new IllegalArgumentException("workId Cannot be greater than " + WORK_MAX + " and less than 0");
        }
        this.groupId = groupId;
        this.workId = workId;
    }

    public synchronized long nextKey(){
        long currentTime = System.currentTimeMillis();
        //避免程序运行中，回退系统时间。造成key重复
        if(currentTime < lastTime){
            throw new RuntimeException("System time cannot be rollback!");
        }

        //如果当前时间和最后生成key的时间相同，则sequence+1，
        //如果sequence+1后大于SEQUENCE_MAX，则sequence=0，当前时间等待下一毫秒
        if(currentTime == lastTime) {
            sequence = (sequence + 1) & SEQUENCE_MAX;
            if(sequence == 0L){
                while (currentTime <= lastTime){
                    currentTime = System.currentTimeMillis();
                }
            }
        }else{
            sequence = 0L;
        }
        //更新最后生成key的时间为当前时间
        lastTime = currentTime;

        return (currentTime - START_TIME) << TIME_LEFT  //时间戳部分
                | groupId << GROUP_LEFT                 //groupid部分
                | workId << WORK_LEFT                   //workid部分
                | sequence;                             //序列号部分;
    }

    public static void main(String[] args) throws Exception {
       SnowFlake snowFlake = new SnowFlake(1, 1);
       for (int i = 0; i< 100; i ++) {
           System.out.println(snowFlake.nextKey());
       }
    }
}