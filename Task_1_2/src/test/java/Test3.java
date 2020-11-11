import org.junit.Test;
import java.io.*;
import java.nio.charset.StandardCharsets;
import static org.junit.Assert.assertArrayEquals;

public class Test3{

    @Test
    public void simpleTests3() throws IOException {
        String str= new String("abacabacbaba".getBytes(), "UTF-8");
        String substr = new String("aba".getBytes(), "UTF-8");
        File file = File.createTempFile("test", ".txt");
        long[] res = new long[1];
        long[] truRes = new long[]{0, 4, 9};
        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));) {
            out.write(str);
        }
        try (InputStream inStream = new FileInputStream(file)) {
            res = SubstringSearch.substringSearch(inStream, substr);
        }

       assertArrayEquals(res, truRes);
    }
}
