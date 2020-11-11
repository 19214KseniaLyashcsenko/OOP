import org.junit.Test;
import java.io.*;
import java.nio.charset.StandardCharsets;
import static org.junit.Assert.assertArrayEquals;

public class Test4{

    @Test
    public void withoutSubStrTests3() throws IOException {
        String str= new String("Я хочу сок!".getBytes(), "UTF-8");
        String substr = new String("пирог".getBytes(), "UTF-8");
        File file = File.createTempFile("test", ".txt");
        long[] res = new long[1];
        long[] truRes = new long[]{};
        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));) {
            out.write(str);
        }
        try (InputStream inStream = new FileInputStream(file)) {
            res = SubstringSearch.substringSearch(inStream, substr);
        }

        assertArrayEquals(res, truRes);
    }
}
