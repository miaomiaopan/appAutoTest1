package appAutoTest;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class UIAPPiumTest {
	public void test() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "android6");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", ".Calculator");

        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        
        driver.findElement(By.name("1")).click();
        driver.findElement(By.name("5")).click();
        driver.findElement(By.name("9")).click();
        driver.findElement(By.name("delete")).click();
        driver.findElement(By.name("+")).click();
        driver.findElement(By.name("6")).click();
        driver.findElement(By.name("=")).click();
        Thread.sleep(2000);

        String result = driver.findElement(By.id("com.android.calculator2:id/formula")).getText();
        System.out.println(result);

        driver.quit();
	}
	
	public static void main(String args[]) throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "android6");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", ".Calculator");
        File classpathRoot = new File(System.getProperty("user.dir"));//获得项目路径
        File appDir = new File(classpathRoot, "apps");//获得APK所在文件夹名称
        File app = new File(appDir, "weixin_1320.apk");//获得APK文件
        capabilities.setCapability("app", app.getAbsolutePath());

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//        driver.findElement(By.id("com.android.calculator2:id/digit_1")).click();
//        driver.findElement(By.id("com.android.calculator2:id/digit_5")).click();
//        driver.findElement(By.id("com.android.calculator2:id/digit_9")).click();
//        driver.findElement(By.id("com.android.calculator2:id/del")).click();	
//        driver.findElement(By.id("com.android.calculator2:id/op_div")).click();
//        driver.findElement(By.id("com.android.calculator2:id/digit_6")).click();
//        driver.findElement(By.id("com.android.calculator2:id/eq")).click();
        Thread.sleep(20000);

//        String result = driver.findElement(By.id("com.android.calculator2:id/formula")).getText();
//        System.out.println(result);

        driver.quit();
	}
	
}
