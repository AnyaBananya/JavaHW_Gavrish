import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AfterLast4Test {
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testSingle4() {
        int[] a = {1, 2, 3, 4, 5, 6};
        int[] b = {5, 6};
        Assert.assertArrayEquals(MainApp.getNumbersAfterLast4(a), b);
    }

    @Test
    public void testFew4() {
        int[] a = {1, 4, 3, 4, 5, 6};
        int[] b = {5, 6};
        Assert.assertArrayEquals(MainApp.getNumbersAfterLast4(a), b);
    }

    @Test
    public void testWithout4() {
        int[] a = {1, 2, 3, 3, 5, 6};
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage(MainApp.ERROR_MES);
        MainApp.getNumbersAfterLast4(a);
    }
}
