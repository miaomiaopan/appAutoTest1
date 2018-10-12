package appAutoTest;

import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class UIAPPiumTest6 {
	public static String str1 = null;
	String str2;

	@Before
	public void init() throws Exception {
		str1 = "hello";
		str2 = "hello1";
	}

	@Test
	public void test1() {
		System.out.println(str1);
		System.out.println(str2);
	}

	@After
	public void after() {
	}

}
