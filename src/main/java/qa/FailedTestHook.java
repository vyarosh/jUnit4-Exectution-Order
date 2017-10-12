package qa;


import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

import static qa.TestFactory.staticLog;

public class FailedTestHook implements MethodRule {

    public Statement apply(final Statement statement, final FrameworkMethod frameworkMethod, final Object o) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    statement.evaluate();
                } catch (Throwable t) {
                    // exception will be thrown only when a test fails.
                    staticLog("onFail Hook");
                    // rethrow to allow the failure to be reported by JUnit
                    throw t;
                }
            }
        };
    }
}