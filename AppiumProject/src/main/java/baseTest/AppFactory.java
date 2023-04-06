package baseTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import utilities.configReader;

import java.net.MalformedURLException;
import java.net.URL;

public class AppFactory {

    public static AppiumDriver driver;
    public static configReader confReader;


    public void initializer() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        confReader =  new configReader();
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME ,  confReader.getAutomationName());
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME ,  confReader.getPlatformName());
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION ,  confReader.getPlatformVersion());
        cap.setCapability(MobileCapabilityType.DEVICE_NAME ,  confReader.getDeviceName());
        cap.setCapability("newCommandTimeout", 100000);
        cap.setCapability(MobileCapabilityType.APP ,  confReader.getApkPath());

        URL url =  new URL(confReader.getServerURL());

        driver = new AndroidDriver(url , cap);

        AppDriver.setDriver(driver);
    }

    public void quitDriver(){

        if(null != driver)
            driver.quit();
    }
}
