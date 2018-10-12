package appAutoTest;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class test {
public static void main(String args[]) throws Exception {
//	DesiredCapabilities capabilities = new DesiredCapabilities();
//	capabilities.setCapability("app","");
//	capabilities.setCapability("appPackage","com.tencent.mm");
//	capabilities.setCapability("appActivity", ".ui.LauncherUI");
//	capabilities.setCapability("deviceName","a128cb90");
////	capabilities.setCapability("fastReset","false");
////	capabilities.setCapability("fullRest","false");
//	capabilities.setCapability("noRest","true");
//	capabilities.setCapability("automationName","Appium");
//	capabilities.setCapability("platformName","Android");
//	capabilities.setCapability("platformVersion","8.0.0");
////	capabilities.setCapability("recreateChromeDriverSessions", "true");
	

	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "a128cb90");
	capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ios");
	capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.2.1");
	capabilities.setCapability("appPackage", "com.tencent.mm");
	capabilities.setCapability("appActivity", ".ui.LauncherUI");
	capabilities.setCapability(MobileCapabilityType.NO_RESET, "true");
	capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");

	ChromeOptions options = new ChromeOptions();
	options.setExperimentalOption("androidProcess","com.tencent.mm:tools");
	capabilities.setCapability(ChromeOptions.CAPABILITY,options);

	AndroidDriver driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

	//等待元素加载出来
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@text='发现']")).click();
	int width = driver.manage().window().getSize().width;
	int height = driver.manage().window().getSize().height;
	Thread.sleep(2000);
	driver.swipe(width /2, height / 4 + 200,width / 2,height / 4,200);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@text='小程序']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@text='美团外卖']")).click();
	System.out.println("所有上下文" + driver.getContext());
	System.out.println("所有句柄" + driver.getContextHandles());
	driver.context("WEBVIEW_com.tencent.mm:tools");
	Thread.sleep(6000);
	System.out.println("已经进入webview");
	System.out.println(driver.getPageSource());
	System.out.println(driver.getContext());
	driver.quit();
}
}
