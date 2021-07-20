package Source;

import java.util.ArrayList;
import java.util.function.Supplier;

public abstract class NetlabUT extends UnitTest
{
    private String mTestName = null;
    private ArrayList<Profile> mTestProfile = new ArrayList<>();
    
    protected NetlabUT() {}
    protected NetlabUT(String testName) { mTestName = testName; }

    public String getTestName() { return mTestName; }
    public ArrayList<Profile> getTestProfile() { return mTestProfile; }
     
    protected void assumeNull(Supplier<Object> actual)                       { assumeNull(actual, null); }
    protected void assumeNotNull(Supplier<Object> actual)                    { assumeNotNull(actual, null); }
    protected void assumeSame(Object expected, Supplier<Object> actual)      { assumeSame(expected, actual, null); }
    protected void assumeTrue(Supplier<Boolean> actual)                      { assumeTrue(actual, null); }
    protected void assumeFalse(Supplier<Boolean> actual)                     { assumeFalse(actual, null); }
    protected void assumeEquals(Object expected, Supplier<Object> actual)    { assumeEquals(expected, actual, null); }
    protected void assumeNotEquals(Object expected, Supplier<Object> actual) { assumeNotEquals(expected, actual, null); }

    protected void assumeNull(Supplier<Object> actual, String message) {
        Profile<Object> p = new Profile<Object>(
            Benchmark.run(actual),
            "null",
            message
        );
        mTestProfile.add(p);
        recordAssumption(p.metric.returnValue == null);
    }
    protected void assumeNotNull(Supplier<Object> actual, String message) {
        Profile<Object> p = new Profile<Object>(
            Benchmark.run(actual),
            "not null",
            message
        );
        mTestProfile.add(p);
        recordAssumption(p.metric.returnValue != null);
    }
    protected void assumeSame(Object expected, Supplier<Object> actual, String message) {
        Profile<Object> p = new Profile<Object>(
            Benchmark.run(actual),
            expected,
            message
        );
        mTestProfile.add(p);
        recordAssumption(p.metric.returnValue == actual);
    }
    protected void assumeTrue(Supplier<Boolean> actual, String message) {
        Profile<Boolean> p = new Profile<Boolean>(
            Benchmark.run(actual),
            true,
            message
        );
        mTestProfile.add(p);
        recordAssumption(p.metric.returnValue == true);
    }
    protected void assumeFalse(Supplier<Boolean> actual, String message) {
        Profile<Boolean> p = new Profile<Boolean>(
            Benchmark.run(actual),
            false,
            message
        );
        mTestProfile.add(p);
        recordAssumption(p.metric.returnValue == false);
    }
    protected void assumeEquals(Object expected, Supplier<Object> actual, String message) {
        Profile<Object> p = new Profile<Object>(
            Benchmark.run(actual),
            expected,
            message
        );
        mTestProfile.add(p);
        recordAssumption(p.metric.returnValue.equals(expected) == true);
    }
    protected void assumeNotEquals(Object expected, Supplier<Object> actual, String message) {
        Profile<Object> p = new Profile<Object>(
            Benchmark.run(actual),
            "not " + expected,
            message
        );
        mTestProfile.add(p);
        recordAssumption(p.metric.returnValue.equals(expected) == false);
    }

}