// Import statement:
import java.util.ArrayList;

class PrimeDirective {
  
  // Add your methods here:
  public boolean isPrime(int number) {
    if (number == 2){
      return true;
    }
    else if (number < 2){
      return false;
    }
    else{
      for (int i = 2; i < number; i++) {
      if (number % i == 0) {
        return false;
        }
      return true;
      }
    }
    return false;
  }

  public ArrayList<Integer> onlyPrimes(int[] numbers) {
    ArrayList<Integer> primes = new ArrayList<Integer>();
    for (int number : numbers){
      if(isPrime(number)){
        primes.add(number);
      }
    }
    return primes;
  }

  public ArrayList<Integer> onlyOddOrEven(int[] numbers){
    String arg = "odd";
    ArrayList<Integer> oddOrEven = new ArrayList<Integer>();
    if(arg == "even"){
      for (int number : numbers){
        //Prime argument removed as no even number can be prime (except 2)
          if (number % 2 == 0){
            oddOrEven.add(number);
          }
        }
      }
    else if(arg == "odd"){
      for (int number : numbers){
        //Filters odd prime numbers
        if(isPrime(number)){
          if (number % 2 == 1){
            oddOrEven.add(number);
          }
        }
      }
    }
    return oddOrEven;
  }
  
  
  public static void main(String[] args) {

    PrimeDirective pd = new PrimeDirective();
    int[] numbers = {6, 29, 28, 33, 11, 100, 101, 43, 89};
    System.out.println(pd.onlyOddOrEven(numbers));

  }  

}
