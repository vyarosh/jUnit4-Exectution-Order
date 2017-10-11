package qa;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.fail;

public class AnotherClassDemo extends TestFactory {

 
    @Test
    public void anotherTest1() {
        logTestName();
    }
 
    @Test
    public void anotherTest2() {
        logTestName();
    }


    @Test
    public void anotherTest3() {
        fail(getFailMessage());
    }

    @Ignore
    @Test
    public void anotherTest4() {
        logSkipTest();
    }

}
