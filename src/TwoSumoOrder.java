import java.util.ArrayList;

/**
 * author: lihui1
 * date: 2019/2/24
 * email: 1316994947@qq.com
 * desc:
 */

public class TwoSumoOrder {

    public int[] twoSum(int nums[], int target){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            int diffValue = target - nums[i];
            if (list.contains(diffValue)){
                return new int[]{list.indexOf(diffValue)+1, i+1};
            }else {
                list.add(nums[i]);
            }
        }
        return null;
    }

    public int[] twoSumByHashMap(int nums[], int target){
        return null;
    }

    public static void main(String[] args) {
        int nums[] = {2, 7, 11, 15};
        TwoSumoOrder t = new TwoSumoOrder();
        int array[] = t.twoSum(nums, 9);
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
