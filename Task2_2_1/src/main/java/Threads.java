import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

public class Threads<T> {

    private Result<T> result;

    /**
     * @param arrayNumbers array with numbers
     * @param numbersThreads number of threads
     * @param predicate  the rule by which a prime number will be recognized or not
     */
    Result<T> createThreads(Iterable<T> arrayNumbers, int numbersThreads, Predicate<T> predicate) {
        if(arrayNumbers == null) throw new IllegalArgumentException("empty array of numbers");
        else if(numbersThreads < 1) throw new IllegalArgumentException("incorrect number of threads");
        else if(predicate == null) throw new IllegalArgumentException("predicate is null");

        ArrayList<ThreadHandler<T>> handlers = new ArrayList<>();
        Thread[] threads = new Thread[numbersThreads];

        for(int i = 0; i<numbersThreads; i++){
            Iterator<T> iterator = arrayNumbers.iterator();

            for (int j = 0; j<i;j++)
                if (iterator.hasNext())
                    iterator.next();

            Iterator<T> iter = divide(iterator,numbersThreads);
            handlers.add(new ThreadHandler<T>(iter, predicate, result));
        }

        for (ThreadHandler<T> handler : handlers){
            try{
                handler.thread.join();
            }
            catch (InterruptedException e){
                System.out.println("Thread interrupted");
            }
        }
        return result;
    }

    public static class Result<T> {

        private boolean isFound;

        synchronized void IsFound(){
            this.isFound = true;
        }

        boolean isPrime(){
            return isFound;
        }
    }

    public static class ThreadHandler<T> extends Thread{

        private Iterator<T> iterator;
        private Predicate<T> predicate;
        private Result<T> result;
        private Thread thread;

        ThreadHandler(Iterator<T> iter, Predicate<T> pred, Result<T> res){
            this.iterator  = iter;
            this.predicate = pred;
            this.result    = res;
            this.thread = new Thread(this);
            thread.start();
        }

        public void run(){

            while (iterator.hasNext()){
                if (result.isPrime()) return;
                T number = iterator.next();
                if(predicate.test(number))
                    result.IsFound();
            }
        }
    }

    Threads(){
        result = new Result<T>();
    }

    private Iterator<T> divide(Iterator<T> iterator, int numbersThreads){

        ArrayList<T> arrayNumbersThread = new ArrayList<T>();

        for (int i = 0;iterator.hasNext(); i++) {
            T number = iterator.next();
            if (i % numbersThreads == 0)
                arrayNumbersThread.add(number);
        }
        return arrayNumbersThread.iterator();
    }
}
