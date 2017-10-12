package qa;

import org.junit.*;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;


public abstract class TestFactory {

    @BeforeClass
    public static void setUpClass() {
        staticLog("@BeforeClass");
    }

    @AfterClass
    public static void tearDownClass() {
        staticLog("@AfterClass");
    }

    // @ClassRule goes here

    @Rule
    public TestName testName = new TestName();

    @Rule
    public TestWatcher watcher = new MyTestWatcher();

    @Rule
    public FailedTestHook onFailure = new FailedTestHook();

    @Before
    public void setUp() {
        log("@Before");
    }

    @After
    public void tearDown() {
        log("@After");
    }


    public void log(String msg) {
        String currentClass = this.toString().replace("test.", "");
        System.out.println(currentClass+ ":: \t\t" + msg);
    }

    public static void staticLog(String msg) {
        String currentClass = Thread.currentThread().getStackTrace()[2].getClassName().replace("test.", "");
        System.out.println(msg + " \t\t<< " + currentClass);
    }

    void logTestName() {
        log("@Test " + testName.getMethodName() + "()");
    }

    void logSkipTest() {
        log("ERROR: If you read this: @Test " + testName.getMethodName() + "() was not skipped!");
    }

    String getFailMessage() {
        return "@Test " + testName.getMethodName() + "() - Fail";
    }

}
