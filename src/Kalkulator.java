import java.util.Arrays;
import java.util.regex.Pattern;

public class Kalkulator {

    public int suma() {
        return 0;
    }

    public int suma(String a) {
        int suma = 0;

        if (a.contains("][")) {
            String s = a.substring(a.indexOf("//[") + 3, a.indexOf('\n') - 1);
            s = s.replace("[", "");
            String[] arrS = s.split("]");
            StringBuilder separator = new StringBuilder();

            for (String i : arrS) {
                separator.append(Pattern.quote(i)).append("|");
            }

            separator.deleteCharAt(separator.length() - 1);
            a = a.substring(a.indexOf("\n") + 1);
            int[] arr = Arrays.stream(a.split(separator.toString())).mapToInt(Integer::parseInt).toArray();

            suma = getSuma(suma, arr);

        } else if (a.contains("//[")) {
            String separator = a.substring(a.indexOf("//[") + 3, a.indexOf("]"));
            a = a.substring(a.indexOf("\n") + 1);
            int[] arr = Arrays.stream(a.split(Pattern.quote(separator))).mapToInt(Integer::parseInt).toArray();

            suma = getSuma(suma, arr);
        } else if (a.contains("//")) {
            char separator = a.charAt(2);
            a = a.substring(4);
            String sep = "[" + separator + ",\n]";

            int[] arr = Arrays.stream(a.split(sep)).mapToInt(Integer::parseInt).toArray();

            suma = getSuma(suma, arr);
        } else {
            int[] arr = Arrays.stream(a.split("[,\n]")).mapToInt(Integer::parseInt).toArray();

            suma = getSuma(suma, arr);
        }
        return suma;
    }

    private int getSuma(int suma, int[] arr) {
        for (int i : arr) {
            if (i < 0) {
                throw new IllegalArgumentException("Liczby ujemne niedozwolone " + Arrays.toString(Arrays.stream(arr).filter(s -> s < 0).toArray()));
            }

            if (i < 1000) {
                suma += i;
            }
        }
        return suma;
    }
}
