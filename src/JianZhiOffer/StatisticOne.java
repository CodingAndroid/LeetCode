package JianZhiOffer;

/**
 * author: lihui1
 * date: 2019/4/4
 * email: 1316994947@qq.com
 * desc: 剑指offer面试题: 统计二进制1的个数
 */

public class StatisticOne {

    private static int getNumsOfOne(int x){
        int count = 0;
        while (x != 0){
            if (x %2 == 1)
                count++;
            x = x >> 1;//右移一位, 相当于除以2;
        }
        return count;
    }

    public static void main(String[] args) {
        int x = 10;
        System.out.printf(""+getNumsOfOne(x));
    }
}
