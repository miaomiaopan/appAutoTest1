package appAutoTest;

import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class UIAPPiumTest4 {

	public static void main(String args[]) throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "a128cb90");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0.0");
		capabilities.setCapability("appPackage", "com.tencent.mm");
		capabilities.setCapability("appActivity", ".ui.LauncherUI");
		capabilities.setCapability(MobileCapabilityType.NO_RESET, "true");
		// TODO 每种值的含义列出来
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("androidProcess", "com.tencent.mm:appbrand0");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4724/wd/hub"), capabilities);
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='发现']").click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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

		driver.quit();
	}

}
