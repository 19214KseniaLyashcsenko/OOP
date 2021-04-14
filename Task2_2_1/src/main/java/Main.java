public class Main {

    public static boolean isPrime(int number){
        for(int i = 2; i<Math.sqrt(number); i++){
            if (number % i == 0)
                return true;
        }
        return false;
    }
}

