package qa;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.fail;
public class SubClassDemo extends SingleClassDemo {

 
    @Test
    public void subTest1() {
        logTestName();
    }
 
    @Test
    public void subTest2() {
        logTestName();
    }

    @Test
    public void subTest3() {
        fail(getFailMessage());
    }

    @Ignore
    @Test
    public void subTest4() {
        logSkipTest();
    }
}
