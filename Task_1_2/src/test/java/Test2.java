import org.junit.Test;
import java.io.*;
import java.nio.charset.StandardCharsets;
import static org.junit.Assert.assertArrayEquals;

public class Test2 {

    @Test
    public void simpleTests2() throws IOException {
        String str= new String("Если яблоко, то яблоко".getBytes(), "UTF-8");
        String substr = new String("яблоко".getBytes(), "UTF-8");
        File file = File.createTempFile("test", ".txt");
        long[] res = new long[1];
        long[] truRes = new long[]{5, 16};
        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));) {
            out.write(str);
        }
        try (InputStream inStream = new FileInputStream(file)) {
            res = SubstringSearch.substringSearch(inStream, substr);
        }

        assertArrayEquals(res, truRes);
    }
}
