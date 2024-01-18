import java.util.*;

public class win95KeyGen {
    //Random instance
    Random rand = new Random();

    //Makes sure that the first three numbers aren't on the invalid combo list.
    private String genValidCombo() {
        ArrayList<String> invalid_combo = new ArrayList<>(Arrays.asList("333","444","555","666","777","888","999"));
        int min = 100;
        int max = 999;
        int combo = rand.nextInt((max - min) + 1) + min;
        if (invalid_combo.contains(Integer.toString(combo))){
            genValidCombo();
        }
        return Integer.toString(combo);
    }

    //Concatenates hyphen to key
    private String addHyphen(String key) {
        return key + "-";
    }

    //Very hacky.
    //Uses bruteforce to get numbers and check if they divide by 7 with no remainder.
    private String seven_numbers(String key) {
        String nums = "";
        int sum = 0;
        List<Integer> seven_numbers = new ArrayList<>();
        int i = 0;
        while (i < 7) {
            int number = rand.nextInt(9);
            seven_numbers.add(number);
            i += 1;
        }

        for(int j = 0; j < seven_numbers.size(); j++){
            sum += seven_numbers.get(j);
        }
        if(sum % 7 == 0){
           for (Integer item : seven_numbers){
               nums += item.toString();
           };
           return key + nums;
        }
        else {
            seven_numbers(key);
        }
        return "Try Again!";
    }

    //Runs all methods and returns key.
    public String generate_key() {
        String key;
        key = genValidCombo();
        key = addHyphen(key);
        key = seven_numbers(key);
        return key;

    }
    //Generates new method and output
    public static void main(String[] args) {
        win95KeyGen generatedKey = new win95KeyGen();
        System.out.println(generatedKey.generate_key());

    }
}
