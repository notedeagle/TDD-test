import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Testy {

    Kalkulator k;
    int wynik;
    int exp;

    @Before
    public void setClass() {
        k = new Kalkulator();
    }

    @Test
    public void test0() {
        wynik = k.suma();
        exp = 0;
    }

    @Test
    public void test1() {
        wynik = k.suma("4");
        exp = 4;
    }

    @Test
    public void test2() {
        wynik = k.suma("4,7");
        exp = 11;
    }

    @Test
    public void test3() {
        wynik = k.suma("4,6,2");
        exp = 12;
    }

    @Test
    public void test4() {
        wynik = k.suma("7,9,8,7,8,9,7,5,9,10");
        exp = 79;
    }

    @Test
    public void test5() {
        wynik = k.suma("4,7,8,9,7,8,9,7,8,9,7,9,8,7,8,9,7,5,9,10");
        exp = 155;
    }

    @After
    public void sprawdz() {
        assertEquals(wynik, exp);
    }
}
