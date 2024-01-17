import java.util.ArrayList;
import java.util.Arrays;

public class Windows95 {
    String key;
    public Windows95(String windowsKey){
        key = windowsKey;
    }
    public String is_valid() {
        ArrayList<String> invalid_combo = new ArrayList<>(Arrays.asList("333","444","555","666","777","888","999"));
        ArrayList<String> valid_numbers = new ArrayList<>(Arrays.asList("0","1","2","3","4","5","6","7","8"));
        String key_substring = key.substring(0,3);
        String key_substring2 = key.substring(4,11);
        //First check, checks if the first 3 characters don't have the same number from 333 and beyond.
        if (invalid_combo.contains(key_substring)){
            return "Invalid combo";
        }
        //Second check, checks if the last 7 characters contain the numbers in valid_numbers array.
      for (int i = 0; i < key_substring2.length(); i++) {
          char c = key_substring2.charAt(i);
          if(valid_numbers.contains(String.valueOf(c))) {
              continue;
          }
          else{
              return "Invalid numbers";
          }

      }
      //Final check, checks if last 7 numbers can be divided with no remainder.
        int sum = 0;
        for (int i = 0; i < key_substring2.length(); i++) {
            char c = key_substring2.charAt(i);
            sum += Character.getNumericValue(c);
        }
        if (sum % 7 == 0) {
            return "Valid Key";
        }
        return "Invalid key";
    }

    public static void main(String[] args) {
        Windows95 new_key = new Windows95("757-2573155");
        System.out.println(new_key.is_valid());
    }
}
