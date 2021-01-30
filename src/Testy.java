import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    public void test6() {
        wynik = k.suma("1\n2,3");
        exp = 6;
    }

    @Test
    public void test7() {
        wynik = k.suma("5\n4\n7,7,8\n10");
        exp = 41;
    }

    @Test
    public void test8() {
        wynik = k.suma("//;\n1;2");
        exp = 3;
    }

    @Test
    public void test9() {
        wynik = k.suma("//<\n1<10<7,8\n15<5");
        exp = 46;
    }

    @Test
    public void test10() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> k.suma("-8,1,-2"));
        System.out.println(exception.getMessage());
    }

    @Test
    public void test11() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> k.suma("-5,10,-2\n5\n-3"));
        System.out.println(exception.getMessage());
    }

    @Test
    public void test12() {
        wynik = k.suma("1500,999,1,1001");
        exp = 1000;
    }

    @Test
    public void test13() {
        wynik = k.suma("1001,15,5,1234");
        exp = 20;
    }

    @Test
    public void test14() {
        wynik = k.suma("2000,2");
        exp = 2;
    }

    @Test
    public void test15() {
        wynik = k.suma("//[***]\n1***2***3");
        exp = 6;
    }

    @Test
    public void test16() {
        wynik = k.suma("//[+-=*/]\n5+-=*/10+-=*/8");
        exp = 23;
    }

    @Test
    public void test17() {
        wynik = k.suma("//[*]\n1*2*3*6");
        exp = 12;
    }

    @Test
    public void test18() {
        wynik = k.suma("//[*][;]\n1*2;3");
        exp = 6;
    }

    @Test
    public void test19() {
        wynik = k.suma("//[+][*][;][%]\n1+2*3%4;5");
        exp = 15;
    }

    @Test
    public void test20() {
        wynik = k.suma("//[++][***][;][%%%%]\n1++2***3;4%%%%5");
        exp = 15;
    }

    @Test
    public void test21() {
        wynik = k.suma("//[##$][#][&&&][+-+][***]\n1#2&&&3+-+4***5##$5");
        exp = 20;
    }

    @Test
    public void test22() {
        wynik = k.suma("//[^][+-+-+][!@#$][***][&]\n1^2+-+-+3!@#$5***6&10+-+-+3");
        exp = 30;
    }


    @After
    public void sprawdz() {
        assertEquals(exp, wynik);
    }
}
