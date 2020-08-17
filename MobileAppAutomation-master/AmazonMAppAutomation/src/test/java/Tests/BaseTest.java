package Tests;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseTest {

	public static AndroidDriver driver;
	public AppiumDriverLocalService service;
	public static Logger log;

	@BeforeClass
	public void setup() throws Exception {
		PropertyConfigurator.configure(System.getProperty("user.dir") + "\\AmazonMAppAutomation\\Resouces\\log4j.properties");
		// For logging
		log = Logger.getLogger(this.getClass().getName());

		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		log.info("*Appium server started*");
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "HonorPlay");
		caps.setCapability("udid", "58H3Y18904006164"); 
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "9");
		caps.setCapability("skipUnlock", "true");
		caps.setCapability("app", System.getProperty("user.dir")+"/AmazonMAppAutomation/Resouces/Amazon Shopping Search Find Ship and Save_v20.13.0.100_apkpure.com.apk");
		caps.setCapability("appPackage", "com.nobroker.app");
		caps.setCapability("appActivity", "com.nobroker.app.activities.NBLauncherActivity");
		caps.setCapability("noReset", "false");
		// Create a Android Driver driver. All test classes use this.
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
