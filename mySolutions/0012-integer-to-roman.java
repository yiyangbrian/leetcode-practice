class Solution {
    static Map<Integer, String> values = new HashMap<>();

    static{

        values.put(1, "I");
        values.put(5, "V");
        values.put(10, "X");
        values.put(50, "L");
        values.put(100, "C");
        values.put(500, "D");
        values.put(1000, "M");

    }

    public String intToRoman(int num) {
        String roman = "";

        int i = 10;

        while(i <= 10000 && num > 0) {

            int currentValue = num % i;
            int currentDigit = currentValue / (i / 10);
            num -= currentValue;

            String currentSymbol = "";

            if(currentDigit == 4) {
                currentSymbol = values.get(i / 10) + values.get(i / 2);
            } else if(currentDigit == 9) {
                currentSymbol = values.get(i / 10) + values.get(i);
            } else {
                if(currentDigit >= 5) {
                    currentSymbol = values.get(i / 2);
                }
                for(int k = 0; k < currentDigit % 5; k ++) {
                    currentSymbol += values.get(i / 10);
                }
            }

            roman = currentSymbol + roman;
            i *= 10;

        }

        return roman;
    }
}