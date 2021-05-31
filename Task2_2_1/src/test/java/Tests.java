import java.util.ArrayList;
import java.util.function.Predicate;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Tests{

    @Test
    public void simpleTest1(){
        ArrayList array = new ArrayList<>(6);
        array.add(6);
        array.add(8);
        array.add(7);
        array.add(13);
        array.add(9);
        array.add(4);

        Predicate<Integer> predicate = Main::isPrime;
        WithoutThreads withoutTreads = new WithoutThreads();
        assertEquals(true, withoutTreads.isPrime(array,predicate));
    }

    @Test
    public void testWithTreads2() {
        ArrayList array = new ArrayList<>(6);
        array.add(6);
        array.add(8);
        array.add(7);
        array.add(13);
        array.add(9);
        array.add(4);
        int numbersThreads = 3;
        Predicate<Integer> predicate = Main::isPrime;
        Threads threadsHandler = new Threads();
        Threads.Result answer = threadsHandler.createThreads(array,numbersThreads,predicate);
        assertEquals(true, answer.isPrime());
    }

    @Test
    public void testWithTreads3() {
        ArrayList array = new ArrayList<>(8);
        array.add(6997901);
        array.add(6997927);
        array.add(6997967);
        array.add(6998009);
        array.add(6998029);
        array.add(6998039);
        array.add(6998051);
        array.add(6998053);
        int numbersThreads = 8;
        Predicate<Integer> predicate = Main::isPrime;
        Threads threadsHandler = new Threads();
        Threads.Result answer = threadsHandler.createThreads(array,numbersThreads,predicate);
        assertEquals(false, answer.isPrime());
    }
}