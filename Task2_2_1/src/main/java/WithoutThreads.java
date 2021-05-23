import java.util.ArrayList;
import java.util.function.Predicate;

public class WithoutThreads{

    public Boolean isPrime(ArrayList<Integer> arrayNumbers, Predicate<Integer> predicate){

        for(int i = 0; i < arrayNumbers.size(); i++){
            Integer number = arrayNumbers.get(i);
            for(int j = 0; j < Math.sqrt(number); j++)
                if(predicate.test(number))
                    return true;
        }
        return false;
    }
}
