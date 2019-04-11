/**
 * author: lihui1
 * date: 2019/1/24
 * email: 1316994947@qq.com
 * desc: 二维数组中的查找
 *       题目: 在一个二维数组中, 每一行都按照从左到右递增的顺序排序, 每一列都按照从上到下递增的顺序排序。
 *            请完成一个函数, 输入这样的一个二维数组和一个整数, 判断数组中是否含有该整数。
 */

public class FindArray {

    /**
     * 从右上角
     * @param array
     * @param target
     * @return
     */
    public static boolean find(int array[][], int target){

        if (array == null || array.length < 1 || array[1].length < 1){
            return false;
        }

        int rows = array.length;//数组的行数
        int columns = array[1].length;//数组的列数

        int row = 0;//行
        int column = columns-1;//列

        while (row >= 0 && column >= 0 && row < rows && column < columns){
            if (array[row][column] == target){
                return true;
            } else if (array[row][column] > target){
                column--;
            } else if (array[row][column] < target){
                row++;
            }
        }
        return false;
    }

    /**
     * 从左下角
     * @param array
     * @param target
     * @return
     */
    public static boolean get(int array[][], int target){

        if (array == null || array.length < 1 || array[1].length < 1){
            return false;
        }

        int rows = array.length;//数组的行数
        int columns = array[1].length;//数组的列数

        int row = rows - 1;//行
        int column = 0;//列
        while (row < rows && column < columns){
            if (target == array[row][column]){
                return true;
            } else if (target > array[row][column]){
                column++;
            } else if (target < array[row][column]){
                row--;
            }
        }
        return false;
    }

    public static String replace(String input){
        if (input == null){
            return null;
        }
        String output = input.replace(" ", "%20");
        return output;
    }

    public static void main(String[] args) {
        int array[][] = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
        int target = 5;
        System.out.println(get(array, target));

        String input = "We are happy.";
        System.out.println(replace(input));
    }
}
