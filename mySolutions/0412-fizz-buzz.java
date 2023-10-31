import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<String> fizzBuzz(int n) {
        ArrayList<String> list = new ArrayList<>();

        HashMap<Integer, String> map = new HashMap<>() {
            {
                put(3, "Fizz");
                put(5, "Buzz");
            }
        };

        List<Integer> divisors = new ArrayList<>(Arrays.asList(3, 5));

        for(int num = 1; num <= n; num += 1){
            String str = "";
            for(int divisor : divisors){
                if(num % divisor == 0){
                    str += map.get(divisor);
                }
            }
            if (str.equals("")){
                str += Integer.toString(num);
            }

            list.add(str);
        }

        return list;
    }
}
