import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * tests the computus() method
 */
class ComputusAlgorithmTest {

    /**\
     * tests to find the date of easter in 2008
     */
    @Test
    public void test1()
    {
        int x = 2008;
        String year = ", " +x;
        ComputusAlgorithm e = new ComputusAlgorithm(x);
        String date = e.computus();
        assertEquals("Easter: March 23, 2008",date + year);
    }

}