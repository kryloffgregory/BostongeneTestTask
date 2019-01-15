import java.util.HashMap;

public class IntRecognizer {


    private static final HashMap<String, Integer> WORD_TO_INT = new HashMap<>();
    static {
        WORD_TO_INT.put("one", 1);
        WORD_TO_INT.put("two", 2);
        WORD_TO_INT.put("three", 3);
        WORD_TO_INT.put("four", 4);
        WORD_TO_INT.put("five", 5);
        WORD_TO_INT.put("six", 6);
        WORD_TO_INT.put("seven", 7);
        WORD_TO_INT.put("eight", 8);
        WORD_TO_INT.put("nine", 9);
        WORD_TO_INT.put("ten", 10);
        WORD_TO_INT.put("eleven", 11);
        WORD_TO_INT.put("twelve", 12);
        WORD_TO_INT.put("thirteen", 13);
        WORD_TO_INT.put("fourteen", 14);
        WORD_TO_INT.put("fifteen", 15);
        WORD_TO_INT.put("sixteen", 16);
        WORD_TO_INT.put("seventeen", 17);
        WORD_TO_INT.put("eighteen", 18);
        WORD_TO_INT.put("nineteen", 19);
        WORD_TO_INT.put("twenty", 20);
        WORD_TO_INT.put("thirty", 30);
        WORD_TO_INT.put("forty", 40);
        WORD_TO_INT.put("fifty", 50);
        WORD_TO_INT.put("sixty", 60);
        WORD_TO_INT.put("seventy", 70);
        WORD_TO_INT.put("eighty", 80);
        WORD_TO_INT.put("ninety", 90);
        WORD_TO_INT.put("hundred", 100);
        WORD_TO_INT.put("thousand", 1000);
    }




    public static int recognize(String input) throws Exception {
        if(input != null && input.length()> 0) {
            String[] splittedParts = input.trim().split("\\s+");
            int finalResult = 0;
            int result = 0;
            for (String str: splittedParts) {
                if(!WORD_TO_INT.containsKey(str))
                    throw new Exception("No such token: " + str);
                int curResult = WORD_TO_INT.get(str);
                if(curResult == 100 || curResult == 1000) {
                    finalResult += result * curResult;
                    result = 0;
                } else {
                    result += curResult;
                }
            }
            finalResult += result;
            return finalResult;
        } else {
            throw new Exception("The number is empty");
        }
    }
}
