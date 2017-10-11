package qa;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.fail;

public class SingleClassDemo extends TestFactory {

    @Test
    public void test1() {
        logTestName();
    }
 
    @Test
    public void test2() {
        logTestName();
    }

    @Test
    public void test3() {
        fail(getFailMessage());
    }

    @Ignore
    @Test
    public void test4() {
        logSkipTest();
    }
}