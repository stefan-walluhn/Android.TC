package de.walluhn.tc.android;

import android.test.ActivityInstrumentationTestCase2;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class de.walluhn.tc.android.TCActivityTest \
 * de.walluhn.tc.android.tests/android.test.InstrumentationTestRunner
 */
public class TCActivityTest extends ActivityInstrumentationTestCase2<TCActivity> {

    public TCActivityTest() {
        super("de.walluhn.tc.android", TCActivity.class);
    }

}
