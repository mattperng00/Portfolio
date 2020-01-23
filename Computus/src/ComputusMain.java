public class ComputusMain {
    /**
     * driver class
     * @param args
     */
    public static void main(String[] args)
    {
        int x = 2008;
        String year = ", 2008";
        ComputusAlgorithm easter = new ComputusAlgorithm(2008);
        System.out.println(easter.computus() + year);
        System.out.println(easter.easterRepeat(5700000));
    }
}
