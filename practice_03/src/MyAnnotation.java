public class MyAnnotation {
    @Test(a = 5, b = 10)
    public int test(int a, int b) {
        System.out.println("Method invoked with parameters: a=" + a + ", b=" + b);
        return a + b;
    }
}
