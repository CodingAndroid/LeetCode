package JianZhiOffer;

/**
 * author: lihui1
 * date: 2019/4/3
 * email: 1316994947@qq.com
 * desc: 剑指offer面试题14: 调整数组顺序使奇数位于偶数前面
 * 题目: 输入一组整数数组, 实现一个函数来调整该数组中数字的顺序, 使得所有奇数位于数组的前半部分, 所有偶数位于数组的后半部分。
 * 思路: 维护2个指针
 */

public class OddEvenSort {

    public int[] sort(int[] numbers){
        if (numbers == null || numbers.length == 0){
            return null;
        }
        int left = 0;
        int right = left + numbers.length - 1;
        while (left < right){
            while (numbers[left] %2 != 0){ //表示是奇数,指针继续向后走, 直到遇见偶数;
                left++;
            }
            while (numbers[right] %2 == 0){ //表示是偶数, 指针继续向前走, 直到遇见奇数;
                right--;
            }
            if (left < right){ //第一个指针是偶数, 第二个指针是奇数, 则交换;
                int temp = numbers[left];
                numbers[left] = numbers[right];
                numbers[right] = temp;
            }
        }
        return numbers;
    }

    public static void main(String[] args) {
        int numbers[] = {2, 3, 5, 8, 6, 12, 10, 9};
        for (int i = 0; i < numbers.length; i++){
            System.out.printf(numbers[i]+" ");
        }
        System.out.println("");
        OddEvenSort oddEvenSort = new OddEvenSort();
        for (int i = 0; i < oddEvenSort.sort(numbers).length; i++){
            System.out.printf(oddEvenSort.sort(numbers)[i]+" ");
        }

    }
}
