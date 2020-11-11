import java.io.*;
import java.util.Arrays;


public class SubstringSearch {

    static long[] resArr = new long[0];
    static int top = 0;
    static int k = 0;

    /**
     *Увеличиваем массив
     */
    public static void increaseArr(){
        resArr = Arrays.copyOf(resArr, resArr.length + 1);
        top++;
    }

    /**
     *
     * @param inStream - stream of input
     * @param substrIn - substring to find in string
     * @return - array with the indices of all occurrences of the substring in the string
     * @throws IOException - exception handler
     */
    public static long[] substringSearch(InputStream inStream, String substrIn) throws IOException {

        char substr[] = new char[substrIn.length()];
        substr = substrIn.toCharArray();
        char str[] = new char[substr.length * 3];

        BufferedReader readIn = new BufferedReader(new InputStreamReader(inStream, "UTF-8"));

        int k1 = readIn.read(str, substr.length, substr.length);
        if (k1 < substr.length) {
            return resArr;
        }
        System.arraycopy(substr, 0, str, 0, substr.length);
        int k2 = readIn.read(str, substr.length * 2, substr.length);

        if ((k2 == -1) && (Arrays.equals(str, substr.length, substr.length * 2, substr, 0, substr.length))) { // when substring equals to string for search
            if(k == top) increaseArr();
            resArr[k++] = 0;
            return resArr;
        }

        long pos = 0;

        while (k2 != -1) {

            int z[] = new int[str.length];
            z[0] = 0;
            int l = 0, r = 0;
            for (int i = 1; i < str.length; i++) {
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
                if (z[i] >= substr.length && !(Arrays.asList(resArr).contains(pos))) {
                    if(k == top) increaseArr();
                    resArr[k++] = pos;
                }
                pos++;
            }

            k1 = k2;
            pos -= k2;
            System.arraycopy(str, substr.length * 2, str, substr.length, substr.length);
            k2 = readIn.read(str, substr.length * 2, substr.length);
            if (k2 < substr.length) {
                str[substr.length * 2 + k2] = 0;
            }
        }
        return resArr;
    }
}
