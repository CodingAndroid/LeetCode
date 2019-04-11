package JianZhiOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * author: lihui1
 * date: 2019/4/1
 * email: 1316994947@qq.com
 * desc:
 */

public class DuplicateArray {

    static int duplicate(int numbers[]){
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < numbers.length; i++){
            if (map.containsValue(numbers[i])){
                return numbers[i];
            } else {
                map.put(i, numbers[i]);
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int numbers[] = {2,3,1,0,2,5,3};
        System.out.println(duplicate(numbers));
    }
}
