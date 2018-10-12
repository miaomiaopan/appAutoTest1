package appAutoTest;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class UIAPPiumTest2 {

	public static void main(String args[]) throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "a128cb90");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0.0");
		capabilities.setCapability("appPackage", "com.tencent.mm");
		capabilities.setCapability("appActivity", ".ui.LauncherUI");
		capabilities.setCapability(MobileCapabilityType.NO_RESET, "true");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("androidProcess", "com.tencent.mm:appbrand0");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
//        driver.findElement(By.id("com.android.calculator2:id/digit_1")).click();
//        driver.findElement(By.id("com.android.calculator2:id/digit_5")).click();
//        driver.findElement(By.id("com.android.calculator2:id/digit_9")).click();
//        driver.findElement(By.id("com.android.calculator2:id/del")).click();	
//        driver.findElement(By.id("com.android.calculator2:id/op_div")).click();
//        driver.findElement(By.id("com.android.calculator2:id/digit_6")).click();
//        driver.findElement(By.id("com.android.calculator2:id/eq")).click();
		Thread.sleep(5000);
		driver.findElementByXPath("//*[@text='发现']").click();
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		driver.swipe(0, 0, 0, 30, 1000);
		Thread.sleep(10000);
		driver.findElementByXPath("//*[@text='小程序']").click();
		Thread.sleep(5000);
		System.out.println(driver.getContextHandles());
//		driver.context("WEBVIEW_com.tencent.mm:appbrand0");
		System.out.println(driver.getContextHandles());
		driver.findElementByXPath("//*[@text='筷马鲜厨点单服务']").click();
		Thread.sleep(10000);
		driver.findElementByXPath("//android.view.View[@content-desc='点餐']").click();
		Thread.sleep(10000);
//		driver.context("WEBVIEW_com.tencent.mm:tools");
//		driver.findElementByXPath("//*[@text='美团外卖']").click();
//		driver.context("WEBVIEW_com.tencent.mm:tools");
//		  Thread.sleep(5000);
		System.out.println(driver.getContextHandles());

//        String result = driver.findElement(By.id("com.android.calculator2:id/formula")).getText();
//        System.out.println(result);

		driver.quit();
	}

}
