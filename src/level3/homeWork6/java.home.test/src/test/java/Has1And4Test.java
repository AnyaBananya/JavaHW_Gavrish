import org.junit.Assert;
import org.junit.Test;

public class Has1And4Test {
    @Test
    public void testHasOnly1and4() {
        int[] a = {1, 1, 4, 4, 4, 1};
        Assert.assertTrue(MainApp.has1and4(a));
    }

    @Test
    public void testHasOnly1() {
        int[] a = {1, 1, 1};
        Assert.assertFalse(MainApp.has1and4(a));
    }

    @Test
    public void testHasOnly4() {
        int[] a = {4, 4, 4};
        Assert.assertFalse(MainApp.has1and4(a));
    }

    @Test
    public void testHasAnotherNumbersAnd1And4() {
        int[] a = {1, 1, 3, 4, 4, 2};
        Assert.assertFalse(MainApp.has1and4(a));
    }

    @Test
    public void testHasAnotherNumbers() {
        int[] a = {5, 2, 3, 3, 3, 2};
        Assert.assertFalse(MainApp.has1and4(a));
    }
}
