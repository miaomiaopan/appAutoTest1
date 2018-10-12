package appAutoTest;

import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class UIAPPiumTest5 {
	public static AndroidDriver driver = null;

	@BeforeTest
	public void init() throws Exception {
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

		driver = new AndroidDriver(new URL("http://0.0.0.0:4724/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(3000);
	}

	@Test
	public void test1() {
		driver.findElementByXPath("//*[@text='发现']").click();
		Dimension size = driver.manage().window().getSize();
		// 滑动
		new TouchAction(driver).press((int) (size.getWidth() * 0.5), (int) (size.getHeight() * 0.9))
				.waitAction(Duration.ofSeconds(2)).moveTo((int) (size.getWidth() * 0.5), (int) (size.getHeight() * 0.3))
				.release().perform();
		driver.findElementByXPath("//*[@text='小程序']").click();
		driver.findElementByXPath("//*[@text='筷马鲜厨点单服务']").click();
		driver.findElementByXPath("//android.view.View[@content-desc='点餐']").click();
		driver.findElementByXPath("//android.view.View[@content-desc='小鲜粥']").click();
		driver.findElementByXPath("//android.view.View[@content-desc='芋圆紫米']/../following-sibling::*[3]").click();
		driver.findElementByXPath("//android.view.View[@content-desc='去购物车']").click();
		driver.findElementByXPath("//android.view.View[@content-desc='去结算']").click();
		System.out.println(driver.getContextHandles());
	}

	@AfterTest
	public void after() {
		driver.quit();
	}

}
