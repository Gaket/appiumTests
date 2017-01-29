import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;

/**
 * @author Artur Badretdinov (Gaket)
 *         20.12.2016.
 */

public class LoginTest {

    WebDriver mDriver;


    @Before
    public void initDriver() throws MalformedURLException {
        returnAndroidDriver();
    }

    public void returnAndroidDriver() throws MalformedURLException {
        // set up appium
        final File classpathRoot = new File(System.getProperty("user.dir"));
        final File appDir = new File(classpathRoot, "../resources/");
        final File app = new File(appDir, "AppiumTest.apk");

        final DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("app", app.getAbsolutePath());

        mDriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),
                capabilities);

        System.out.println("android started");
    }

    @Test
    public void shouldShowText() {
        System.out.println(mDriver.findElements(By.className("textView")).isEmpty());
    }
}
