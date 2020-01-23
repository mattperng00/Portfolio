import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This is a class that implents Junit
 * This tests machine learning easy
 */
class Machine_LearningTest {

    /**
     * Cosine Similarity Test
     * creates inputs and uses assertEquals
     */
    @Test
    void cosineSimilarity() {
        Machine_Learning x = new Machine_Learning();
        double input1[] = {1,2,3};
        double input2[] = {2,6,3};
        assertEquals(0.8781440805693944,x.CosineSimilarity(input1,input2));
        double input3[] = {3,2,1};
        double input4[] = {3,6,2};
        assertEquals(0.8781440805693944,x.CosineSimilarity(input3,input4));
        double input5[] = {5,6,2};
        double input6[] = {10,20,30};
        assertEquals(0.7624425757515652,x.CosineSimilarity(input5,input6));
        double input7[] = {43,23,48};
        double input8[] = {3,6,7};
        assertEquals(0.9089451583860283,x.CosineSimilarity(input7,input8));
        double input9[] = {11,14,15,16};
        double input10[] = {10,17,17};
        boolean check = false;
        try
        {
            x.CosineSimilarity(input9,input10);
        }
        catch (IllegalArgumentException exception)
        {
            check = true;
        }
        assertTrue(check);

    }

    /**
     *  distance Formula Test
     * creates inputs and uses assertEquals
     */
    @Test
    void distanceFormula() {
        Machine_Learning x = new Machine_Learning();
        double input1[] = {1,2,3};
        double input2[] = {2,6,3};
        assertEquals(4.123105625617661,x.DistanceFormula(input1,input2));
        double input3[] = {3,2,1};
        double input4[] = {3,6,2};
        assertEquals(4.123105625617661,x.DistanceFormula(input3,input4));
        double input5[] = {5,6,2};
        double input6[] = {10,20,30};
        assertEquals(31.701734968294716,x.DistanceFormula(input5,input6));
        double input7[] = {43,23,48};
        double input8[] = {3,6,7};
        assertEquals(59.74947698515862,x.DistanceFormula(input7,input8));
        double input9[] = {11,14,15,16};
        double input10[] = {10,17,17};
        boolean check = false;
        try
        {
            x.DistanceFormula(input9,input10);
        }
        catch (IllegalArgumentException exception)
        {
            check = true;
        }
        assertTrue(check);
    }

    /**
     * hamming distance test
     * creates inputs and uses assertEquals
     */
    @Test
    void hammingDistance() {
        Machine_Learning x = new Machine_Learning();
        String input1 = "1010101";
        String input2 = "1010101";
        assertEquals(0.0,x.HammingDistance(input1,input2));
        String input3 = "1010101111";
        String input4 = "1010101000";
        assertEquals(3.0,x.HammingDistance(input3,input4));
        String input5 = "1010101111111111111";
        String input6 = "1010101101101010101";
        assertEquals(5.0,x.HammingDistance(input5,input6));
        String input7 = "10101011111110000";
        String input8 = "10101011110000010";
        assertEquals(4.0,x.HammingDistance(input7,input8));
        String input9 = "111000";
        String input10 = "1110011111";
        boolean check = false;
        try
        {
            x.HammingDistance(input9,input10);
        }
        catch (IllegalArgumentException exception)
        {
            check = true;
        }
        assertTrue(check);

    }
}