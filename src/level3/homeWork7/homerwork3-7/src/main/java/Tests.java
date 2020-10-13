public class Tests {

    @BeforeSuite
    public static void testBeforeSuite(){
        System.out.println("Before Suite");
    }

    @Test(priority = 1)
    public static void testWithPriority1(){
        System.out.println("Test with priority = 1");
    }

    @Test(priority = 7)
    public static void testWithPriority7(){
        System.out.println("Test with priority = 7");
    }

    @Test(priority = 10)
    public static void testWithPriority10(){
        System.out.println("Test with priority = 10");
    }

    @AfterSuite
    public static void testAfterSuite(){
        System.out.println("After Suite");
    }
}
