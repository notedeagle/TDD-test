import java.util.Arrays;

public class Kalkulator {

    public int suma() {
        return 0;
    }

    public int suma(String a) {
        int suma = 0;
        int[] arr = Arrays.stream(a.split(",")).mapToInt(Integer::parseInt).toArray();

        for (int i : arr) {
            suma += i;
        }

        return suma;
    }
}
