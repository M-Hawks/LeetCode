import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class solution {
    public static void main(String[] args) {
        System.out.println("cool");

        int longest = lengthOfLongestSubstring("abcabcabcd");

        System.out.println("length = " + longest);
    }

    //uses sliding window to calculate substring in O(n) time
    public static int lengthOfLongestSubstring(String s) {

        int high = 0;
        int low = 0;
        int longestSubstring = 0;

        Map<Character ,Integer> charFreq = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            Integer freq = charFreq.get(c);

            if (freq == null || freq == 0) {
                freq = 1;
                charFreq.put(c, freq);

            }
            else {
                int size = high - low;
                if (size > longestSubstring) {
                    longestSubstring = size;
                }

                charFreq.put(c, freq + 1);

                while(low < high && charFreq.get(c) > 1) {
                    Character lowChar = s.charAt(low);
                    Integer lowFreq = charFreq.get(lowChar);

                    charFreq.put(lowChar, lowFreq - 1);

                    low++;
                }
            }

            high++;
        }

        int size = high - low;
        if (size > longestSubstring) {
            longestSubstring = size;
        }


        return longestSubstring;
    }
}
