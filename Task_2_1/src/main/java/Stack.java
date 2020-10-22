import org.junit.jupiter.api.Assertions;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<T> implements Iterable<T> {

    private int mSize = 2;
    private T[] stackArray = (T[]) new Object[mSize];
    private int top = -1;

    /**
     * Метод увеличивающая стек, если кончилось место на нем
     */
    public void increaseStack() {
        stackArray = Arrays.copyOf(stackArray, stackArray.length + 1);
    }

    /**
     * Метод добавляющая эл-т стека, а так же проверяет есть ли место на стеке
     *
     * @param element - эл-т который нужно добавить
     */
    public void push(T element) {
        if (mSize == top + 1 || mSize == 2) {
            increaseStack();
        }
        stackArray[++top] = element;
    }

    /**
     * Метод возвращает эл-т стека и затем удаляет его
     *
     * @return - возвращает эл-т
     */
    public T pop() {
        if (top == -1) {
            throw new NoSuchElementException("Stack is empty");
        }
        return stackArray[top--];
    }

    /**
     * Метод возвращающий кол-во эл-ов в стеке
     *
     * @return
     */
    public int count() {
        return top + 1;
    }

    /**
     * Пишем что может делать итератор
     *
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {

            private int currentIndex = top;

            /**
             * Метод узнающий, есть ли следующий элемент, и не достигнут ли конец
             * @return
             */
            @Override
            public boolean hasNext() {
                return currentIndex < mSize && stackArray[currentIndex] != null;
            }

            /**
             * Метод возвращающий следующий элемент
             * @return
             */
            @Override
            public T next() {
                if (!hasNext()) {
                    return null;
                }
                return pop();
            }

            /**
             * Метод удаляющий текущий элемент, который был получен последним вызовом next()
             */
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
    public void main(){
        Stack mStack = new Stack();
        System.out.println(mStack.pop());
    }
}




