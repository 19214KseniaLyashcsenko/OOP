import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import java.util.NoSuchElementException;

public class Tests {

    @Test
    public void simpleTests() {
        Stack mStack = new Stack();
        mStack.push(79);
        mStack.push(35);
        Assertions.assertEquals(mStack.count(), 2);
        Assertions.assertEquals(mStack.pop(), 35);
    }

    @Test
    public void differentTypeTests() {
        Stack<Integer> intStack = new Stack<Integer>();
        intStack.push(79);
        intStack.push(1234);
        intStack.push(54);
        intStack.push(0);
        intStack.push(12);
        Assertions.assertEquals(intStack.count(), 5);
        Assertions.assertEquals(intStack.pop(), 12);

        Stack<String> stringStack = new Stack<String>();
        stringStack.push("Hello");
        stringStack.push("World");
        stringStack.push("!!");
        stringStack.push("AAAAA");
        stringStack.push("Fish");
        Assertions.assertEquals(stringStack.count(), 5);
        Assertions.assertEquals(stringStack.pop(), "Fish");

        Stack<Boolean> boolStack = new Stack<Boolean>();
        boolStack.push(true);
        boolStack.push(false);
        Assertions.assertEquals(boolStack.count(), 2);
        Assertions.assertEquals(boolStack.pop(), false);
    }

    @Test(expected = NoSuchElementException.class)
    public void emptyStack() {
        Stack mStack = new Stack();
        mStack.pop();
    }

    @Test
    public void bigTests() {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < 100000; i++){
            stack.push(i);
        }
        Assertions.assertEquals(stack.count(),100000);
        for(int i = 100000 - 1 ; i >= 0; i--){
            Assertions.assertEquals(stack.pop(), i);
        }
        Assertions.assertEquals(stack.count(),0);
    }

}
