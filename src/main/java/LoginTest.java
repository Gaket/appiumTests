import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import io.appium.java_client.android.AndroidDriver;

import static org.openqa.selenium.lift.Matchers.text;

/**
 * @author Artur Badretdinov (Gaket)
 *         20.12.2016.
 */

public class LoginTest {

    AndroidDriver mDriver;

    @Before
    public void initDriver() throws MalformedURLException {
        returnAndroidDriver();
    }

    public void returnAndroidDriver() throws MalformedURLException {
        // set up appium
        final File classpathRoot = new File(System.getProperty("user.dir"));
        final File appDir = new File(classpathRoot, "");
        final File app = new File(appDir, "app-debug.apk");
        System.out.println("Application path: " + app.getAbsolutePath());

        final DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "CB5A1Z4LJ0");
        capabilities.setCapability("platformVersion", "5.1.1");
        capabilities.setCapability("appPackage", "info.superego.masterkit.debug");
        capabilities.setCapability("appActivity", "info.superego.masterkit.legacy.login.LoginActivity");
//        capabilities.setCapability("app", app.getAbsolutePath());

        mDriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        System.out.println("android started");
    }

    @Test
    public void shouldShowText() {
        System.out.println("ok");
        mDriver.findElement(By.name("Войти")).click();
    }

    @Test
    public void shouldLogin() throws InterruptedException {
        System.out.println(mDriver.currentActivity());
        mDriver.findElement(By.id("info.superego.masterkit.debug:id/email")).sendKeys("maylon@list.ru");
        mDriver.findElement(By.id("info.superego.masterkit.debug:id/password")).sendKeys("123456");
        mDriver.findElement(By.id("info.superego.masterkit.debug:id/email_sign_in_button")).click();
        WebDriverWait wait = new WebDriverWait(mDriver, 3000);
        wait.wait(4000);
        System.out.println(mDriver.currentActivity());
    }
}
