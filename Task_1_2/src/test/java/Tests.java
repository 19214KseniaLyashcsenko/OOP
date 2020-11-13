import org.junit.Test;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class Tests {

    @Test
    public void Tests1() throws IOException {
        String str = new String("я хочу пирог!!!".getBytes(), "UTF-8");
        String substr = new String("пирог".getBytes(), "UTF-8");
        File file = File.createTempFile("test", ".txt");

        ArrayList<Long> res = new ArrayList<>();
        ArrayList<Long> truRes = new ArrayList<>();

        truRes.add(7L);

        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));) {
            out.write(str);
        }

        try (InputStream inStream = new FileInputStream(file)) {
            res = SubstringSearch.substringSearch(inStream, substr);
        }
        assertArrayEquals(res.toArray(), truRes.toArray());
    }

    @Test
    public void Tests2() throws IOException {
        String str = new String("Яблоко и сыр!!!".getBytes(), "UTF-8");
        String substr = new String("Яблоко".getBytes(), "UTF-8");
        File file = File.createTempFile("test", ".txt");

        ArrayList<Long> res = new ArrayList<>();
        ArrayList<Long> truRes = new ArrayList<>();

        truRes.add(0L);

        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));) {
            out.write(str);
        }

        try (InputStream inStream = new FileInputStream(file)) {
            res = SubstringSearch.substringSearch(inStream, substr);
        }
        assertArrayEquals(res.toArray(), truRes.toArray());
    }

    @Test
    public void Tests3() throws IOException {
        String str = new String("Apple Apple Apple!!!".getBytes(), "UTF-8");
        String substr = new String("Apple".getBytes(), "UTF-8");
        File file = File.createTempFile("test", ".txt");

        ArrayList<Long> res = new ArrayList<>();
        ArrayList<Long> truRes = new ArrayList<>();

        truRes.add(0L);
        truRes.add(6L);
        truRes.add(12L);

        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));) {
            out.write(str);
        }

        try (InputStream inStream = new FileInputStream(file)) {
            res = SubstringSearch.substringSearch(inStream, substr);
        }

        assertArrayEquals(res.toArray(), truRes.toArray());
    }

    @Test
    public void Tests4() throws IOException {
        String str = new String("я хочу пирог!!!".getBytes(), "UTF-8");
        String substr = new String("сок".getBytes(), "UTF-8");
        File file = File.createTempFile("test", ".txt");

        ArrayList<Long> res = new ArrayList<>();
        ArrayList<Long> truRes = new ArrayList<>();

        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));) {
            out.write(str);
        }

        try (InputStream inStream = new FileInputStream(file)) {
            res = SubstringSearch.substringSearch(inStream, substr);
        }

        assertArrayEquals(res.toArray(), truRes.toArray());
    }

    @Test
    public void Tests5() throws IOException {
        String str = new String("я хочу пирог!!!".getBytes(), "UTF-8");
        String substr = new String("я хочу пирог!!!".getBytes(), "UTF-8");
        File file = File.createTempFile("test", ".txt");

        ArrayList<Long> res = new ArrayList<>();
        ArrayList<Long> truRes = new ArrayList<>();

        truRes.add(0L);

        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));) {
            out.write(str);
        }

        try (InputStream inStream = new FileInputStream(file)) {
            res = SubstringSearch.substringSearch(inStream, substr);
        }

        assertArrayEquals(res.toArray(), truRes.toArray());
    }
    
}










