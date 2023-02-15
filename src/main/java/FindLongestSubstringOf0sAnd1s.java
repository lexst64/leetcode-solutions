import java.util.List;
import java.util.ArrayList;

public class FindLongestSubstringOf0sAnd1s {
    
    public static void main(String args[]) {
      System.out.println(new FindLongestSubstringOf0sAnd1s().find("1011101101001110101110110100111010111011010011111110111011010011101011101101001110101110110100111") == 11);
    }

    // n - a number of characters in the string
    // T = O(n)
    // S = O(n)  
    public int find(String s) {
        if (s.length() == 0) return 0;
        
        List<Integer> lengths = new ArrayList<>();
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == 0 && c == '1') lengths.add(0);
            if (i > 0 && s.charAt(i - 1) != c) {
                lengths.add(count);
                count = 0;
            }
            count++;
            if (i == s.length() - 1) {
                lengths.add(count);
                if (c != '0') {
                    lengths.add(0);
                }
            }
        }
        
        if (lengths.size() == 1) return 1;
        
        int max = 0;
        for (int i = 1; i < lengths.size(); i += 2) {
            int newLength = 0; 
            if (i == 1 && lengths.get(i - 1) > 0) {
                newLength = 1;
            } else if (i > 1 && lengths.get(i - 1) == 1) {
                newLength = 1 + lengths.get(i - 2);
            } else if (i + 2 >= lengths.size() && (lengths.get(i + 1) > 0 || lengths.get(i - 1) > 0)) {
                newLength = 1;
            }
            max = Math.max(max, lengths.get(i) + newLength);
        }
        
        return max;
    }
}