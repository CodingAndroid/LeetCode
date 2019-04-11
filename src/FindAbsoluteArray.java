import java.util.HashMap;
import java.util.TreeMap;

/**
 * author: lihui1
 * date: 2019/1/25
 * email: 1316994947@qq.com
 * desc:
 */

public class FindAbsoluteArray {

    public static int[] findIndex(int array[]){
        if (array == null || array.length == 0){
            return null;
        }
        if (array[0] >= 0){
            return new int[]{0};
        } else if (array[array.length-1] <= 0){
            return new int[]{array.length-1};
        }

        int newArray[] = new int[array.length];
        for (int i = 0; i < array.length; i++){
            if (array[i] < 0){
                newArray[i] = -array[i];
            } else {
                newArray[i] = array[i];
            }
        }

        int i = 0;
        int j = 1;
        while (i < j){
            if (newArray[i] > newArray[j]){
                i++;
                j++;
            } else if (newArray[i] < newArray[j]){
                return new int[]{i};
            } else {
                return new int[]{i, j};
            }
        }
        return null;
    }

    public static int[] binaryFindIndex(int array[]){
        if (array == null || array.length == 0){
            return null;
        }
        if (array[0] >= 0){
            return new int[]{0};
        } else if (array[array.length-1] <= 0){
            return new int[]{array.length-1};
        }

        int newArray[] = new int[array.length];
        for (int i = 0; i < array.length; i++){
            if (array[i] < 0){
                newArray[i] = -array[i];
            } else {
                newArray[i] = array[i];
            }
        }

        int left = 0;
        int right = newArray.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (newArray[mid] < newArray[mid+1] && newArray[mid] < newArray[mid-1]){
                return new int[]{mid};
            } else if (newArray[mid] < newArray[mid+1] && newArray[mid] > newArray[mid-1]){
                right = mid - 1;
            } else if (newArray[mid] > newArray[mid+1] && newArray[mid] < newArray[mid-1]){
                left = mid + 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int array[] = {-20, -13, -4, 0, 4, 6, 77,200};
        for (int i = 0; i < findIndex(array).length; i++){
            System.out.printf("index="+findIndex(array)[i]+" ");
        }
    }
}
