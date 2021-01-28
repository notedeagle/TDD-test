import java.util.Arrays;

public class Kalkulator {

    public int suma() {
        return 0;
    }

    public int suma(String a) {
        int suma = 0;

        if (a.contains("//")) {
            char separator = a.charAt(2);
            a = a.substring(4);
            String sep = "[" + separator + ",\n]";

            int[] arr = Arrays.stream(a.split(sep)).mapToInt(Integer::parseInt).toArray();

            for (int i : arr) {
                if (i < 0) {
                    throw new IllegalArgumentException("Liczby ujemne nie dozwolone " + Arrays.toString(Arrays.stream(arr).filter(s -> s < 0).toArray()));
                }
                suma += i;
            }
        } else {
            int[] arr = Arrays.stream(a.split("[,\n]")).mapToInt(Integer::parseInt).toArray();

            for (int i : arr) {
                if (i < 0) {
                    throw new IllegalArgumentException("Liczby ujemne nie dozwolone " + Arrays.toString(Arrays.stream(arr).filter(s -> s < 0).toArray()));
                }
                suma += i;
            }

        }
        return suma;
    }
}
