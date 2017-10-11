package qa;


import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import static qa.TestFactory.staticLog;

public class MyTestWatcher extends TestWatcher {


    @Override
    protected void starting(Description description) {
        staticLog("Before Method Actions");
    }

    @Override
    protected void failed(Throwable e, Description description) {
        staticLog("Failed Actions");
    }

    @Override
    protected void succeeded(Description description) {
        staticLog("Passed Actions");
    }

    @Override
    protected void finished(Description description) {
        staticLog("After Method Actions");
    }
}
