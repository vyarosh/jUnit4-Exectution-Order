package qa;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.fail;
public class SubSubClassDemo extends SubClassDemo {


    @Test
    public void subSubTest1() {
        logTestName();
    }

    @Test
    public void subSubTest2() {
        logTestName();
    }

    @Test
    public void subSubTest3() {
        fail(getFailMessage());
    }

    @Ignore
    @Test
    public void subSubTest4() {
        logSkipTest();
    }
}
