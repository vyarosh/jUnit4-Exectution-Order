package qa;

import org.junit.*;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;


import java.io.IOException;



/**
 * Base test behaviour @before, @after, @rules method tor Test cases and log test results. Web driver initialization.
 *
 * @author Speroteck QA Team (qa@speroteck.com)
 */
public abstract class TestFactory {

    @BeforeClass
    public static void setUpClass() {
        staticLog("@BeforeClass");
    }

    @AfterClass
    public static void tearDownClass() throws IOException {
        staticLog("@AfterClass");
    }

    // @ClassRule goes here

    @Rule
    public TestName testName = new TestName();

    @Rule
    public TestWatcher watcher = new MyTestWatcher();

    @Rule
    public  FailedTestRule onFailure = new FailedTestRule();

    @Before
    public void setUp() {
        log("@Before");
    }

    @After
    public void tearDown() throws IOException {
        log("@After");
    }


    public void log(String msg) {
//        String currentClass = Thread.currentThread().getStackTrace()[2].getClassName().replace("test.", "");
        String currentClass = this.toString().replace("test.", "");

        System.out.println(currentClass+ ":: \t\t" + msg);
    }

    public static void staticLog(String msg) {
        String currentClass = Thread.currentThread().getStackTrace()[2].getClassName().replace("test.", "");
        System.out.println(msg + " \t\t<< " + currentClass);
    }

    private void println(String string) {
        log(string);
    }

    public void logTestName() {
        log("@Test " + testName.getMethodName() + "()");
    }

    public void logSkipTest() {
        log("ERROR: If you read this: @Test " + testName.getMethodName() + "() was not skipped!");
    }

    public String getFailMessage() {
        return "@Test " + testName.getMethodName() + "() - Fail";
    }

}
