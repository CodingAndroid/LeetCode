import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * author: lihui1
 * date: 2019/1/20
 * email: 1316994947@qq.com
 * desc: 两数之和
 * 给定一个整数数组 nums 和一个目标值 target, 请你在该数组中找出和为目标值的那两个整数,
 * 并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是, 你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * 参考: https://blog.csdn.net/qyys20/article/details/53349558
 */

public class TwoSum {

    /**
     * 方法一: 暴力求解 时间复杂度O(N*N), 空间复杂度O(1)
     * @param nums
     * @param target
     * @return
     */
    public int[] baoli(int nums[], int target){
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                   return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 二次哈希求解 时间复杂度O(N), 空间复杂度O(N)
     * key: 数值  value: 下标
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int nums[], int target){
        int m, n;
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if (map.containsKey(diff) && map.get(diff) != i){
                return new int[]{i, map.get(diff)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 一次哈希 时间复杂度O(N), 空间复杂度O(N)
     * @param num
     * @param target
     * @return
     */
    public int[] onceTwoSum(int num[], int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num.length; i++){
            int value = target - num[i];
            if (map.containsKey(value)){
                return new int[]{map.get(value), i};
            }
            map.put(num[i], i);
        }
        return null;
    }

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] TwoSumByArrayList(int nums[], int target){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            if (list.contains(target - nums[i])){
                return new int[]{i, list.indexOf(target- nums[i])};
            } else {
                list.add(nums[i]);
            }
        }
        return null;
    }

    /**
     * HashSet求解-用于返回具体数值而不是下标
     * @param num
     * @param target
     * @return
     */
    public int[] HashSetTwoNum(int num[], int target){
        if (num == null || num.length == 0){
            return null;
        }
        HashSet<Integer> set = new HashSet<>();
        int value;
        for (int i : num){
            value = target - i;
            if (!set.contains(value)){
                set.add(i);
            } else {
                return new int[]{target - value, value};
            }
        }
        return null;
    }

    /**
     * 二分查找法-用于返回具体数值而不是下标
     * @param num
     * @param target
     * @return
     */
    public int[] binaryTwoSum(int num[], int target){
        int result[] = new int[2];
        Arrays.sort(num);//保证数组有序
        for (int i = 0; i < num.length; i++){
            int value = target - num[i];
            int l = i + 1;
            int r = num.length - 1;
            while (l <= r){
                int mid = l + (r - l) / 2;
                if (value < num[mid])
                    r = mid - 1;
                else if (value > num[mid])
                    l = mid + 1;
                else {
                    result[0] = num[i];
                    result[1] = num[mid];
                    return result;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int nums[] = {2, 7, 11, 15};
        TwoSum t = new TwoSum();
        int array[] = t.TwoSumByArrayList(nums, 9);
        System.out.print("[");
        for (int i = 0; i < array.length; i++){
            if (i != array.length - 1){
                System.out.print(array[i]+",");
            } else {
                System.out.print(array[i]);
            }
        }
        System.out.print("]");
    }
}
