package com.accuweather.panda;

import android.app.Activity;
import android.os.Build;

import org.robolectric.AndroidManifest;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.res.Fs;

import java.io.File;
import java.io.IOException;

/**
 * @class RoboletricGradleTestRunner
 * @brief http://pastebin.com/qfcXa6pQ
 */
public class RobolectricGradleTestRunner extends RobolectricTestRunner {
    private static final String PROJECT_DIR =
        getProjectDirectory();

    private static final String MANIFEST_PROPERTY =
        PROJECT_DIR + "src/main/AndroidManifest.xml";

    private static final String RES_PROPERTY =
        PROJECT_DIR + "build/intermediates/res/app/debug/";

    private static final int MAX_SDK_SUPPORTED_BY_ROBOLECTRIC =
        Build.VERSION_CODES.JELLY_BEAN_MR2;

    public RobolectricGradleTestRunner(final Class<?> testClass) throws Exception {
        super(testClass);
    }

    private static AndroidManifest getAndroidManifest() {
        return new AndroidManifest(
            Fs.fileFromPath(MANIFEST_PROPERTY),
            Fs.fileFromPath(RES_PROPERTY)
        ) {
            @Override
            public int getTargetSdkVersion() {
                return MAX_SDK_SUPPORTED_BY_ROBOLECTRIC;
            }

            @Override
            public String getThemeRef(Class<? extends Activity> activityClass) {
                return "@style/AppTheme";
            }


        };
    }

    private static String getProjectDirectory() {
        String path = "";
        try {
            File file = new File("..");
            path = file.getCanonicalPath();
            path = path + "/app/";
        } catch (IOException ex) {
        }
        return path;
    }

    @Override
    public AndroidManifest getAppManifest(Config config) {
        return getAndroidManifest();
    }
}
