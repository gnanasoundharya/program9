package frames02;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import frame01.capabilties04;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
public class testcls extends capabilties04
{
	AndroidDriver<AndroidElement> driver;
	@BeforeTest
	public void bts() throws IOException, InterruptedException
	{
		System.out.println("soundharya");
		Thread.sleep(2000);
	}
	@Test
	public  void test01() throws InterruptedException, IOException
	{
		Thread.sleep(7000);
		service=startserver();
		driver = capabilities(deviceName,appActivity,appPackage,platformName,chromeDriver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("generalstore open");
		Thread.sleep(5000);
		service.stop();
	}
	@Test(enabled=false)
	public void countryname() throws InterruptedException
	{
		driver.findElement(MobileBy.id("android:id/text1")).click();
		Thread.sleep(2000);
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Aruba\"))").click();
		//driver.findElements(MobileBy.className("android.widget.Spinner")).get(1).click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("soundharya");
		Thread.sleep(2000);
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/radioFemale")).click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(2000);		
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"ADD TO CART\"))").click();
		String i=driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Converse All Star\"))").getText();
		System.out.println(i);
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(1).click();
		Thread.sleep(2000);	
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(2000);
		String j=driver.findElement(MobileBy.id("com.androidsample.generalstore:id/productName")).getText();
		System.out.println(j);
		Thread.sleep(2000);
		Assert.assertEquals(i, j);
		Thread.sleep(2000);
		service.stop();
	}


}
