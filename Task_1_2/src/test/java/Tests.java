import org.junit.Test;
import java.io.*;
import java.nio.charset.StandardCharsets;
import static org.junit.Assert.*;

public class Tests {


    @Test
    public void simpleTests1() throws IOException {
        String str= new String("я хочу пирог!!!".getBytes(), "UTF-8");
        String substr = new String("пирог".getBytes(), "UTF-8");
        File file = File.createTempFile("test", ".txt");
        long[] res = new long[1];
        long[] truRes = new long[]{7};
        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));) {
            out.write(str);
        }
        try (InputStream inStream = new FileInputStream(file)) {
            res = SubstringSearch.substringSearch(inStream, substr);
        }
        System.out.println(res.length);
        for (int i = 0; i<res.length;i++) System.out.println(res[i]);
        assertArrayEquals(res, truRes);
    }

}










