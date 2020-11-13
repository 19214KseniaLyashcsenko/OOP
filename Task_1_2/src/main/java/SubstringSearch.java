import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class SubstringSearch {

    /**
     * @param inStream - stream of input
     * @param substrIn - substring to find in string
     * @return - array with the indices of all occurrences of the substring in the string
     * @throws IOException - exception handler
     */

    public static ArrayList<Long> substringSearch(InputStream inStream, String substrIn) throws IOException {
        if (inStream == null) {
            throw new IllegalArgumentException("no file");
        }
        if (substrIn == null) {
            throw new IllegalArgumentException("No substring");
        }

        ArrayList<Long> resArr = new ArrayList<>();

        char substr[];
        substr = substrIn.toCharArray();
        int k = 10;
        char str[] = new char[substr.length * 3];

        try (BufferedReader readIn = new BufferedReader(new InputStreamReader(inStream, "UTF-8"))) {
            System.arraycopy(substr, 0, str, 0, substr.length);
            int charRead = readIn.read(str, substr.length, substr.length * 2);

            if ((charRead == -1) && (Arrays.equals(str, substr.length, substr.length * 2, substr, 0, substr.length))) {
                resArr.add(0L);
                return resArr;
            }

            long posStr = 0;  
            charRead = substr.length;
            while (charRead != -1) {

                int z[] = new int[str.length];
                z[0] = 0;
                int l = 0, r = 0;
                for (int i = 1; i < str.length; ++i) {
                    if (i <= r) {
                        z[i] = Math.min(r - i + 1, z[i - l]);
                    }

                    while (i + z[i] < str.length && (str[z[i]] == str[i + z[i]])) {
                        ++z[i];
                    }

                    if (i + z[i] - 1 > r) {
                        l = i;
                        r = i + z[i] - 1;
                    }
                }

                for (int i = substr.length; i < str.length; i++) {
                    if (z[i] >= substr.length && !(Arrays.asList(resArr).contains(posStr))) {
                        resArr.add(posStr);
                        System.out.println(posStr);
                    }
                    posStr++;
                }

                posStr -= charRead;
                System.arraycopy(str, substr.length * 2, str, substr.length, substr.length);
                charRead = readIn.read(str, substr.length * 2, substr.length);
            }
        }
        return resArr;
    }
}
