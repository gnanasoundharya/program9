package frame01;

import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class capabilties04 {
	public static String deviceName;
	public static String appActivity;
	public static String appPackage;
	public static String platformName;
	public static String chromeDriver;
	public AppiumDriverLocalService service;
	public AppiumDriverLocalService startserver()
	{
		
            boolean flag = checkifserverisRunning(4723);
            if(!flag)
            {
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
                }
            return service;
        }
        
        public static boolean checkifserverisRunning(int port)
        {
            boolean isServerRunning=false;
            ServerSocket serversocket;
            try{
                serversocket = new ServerSocket(port);
                serversocket.close();
            }
            catch(IOException e)
            {
                isServerRunning = true;
            }
            finally {
                serversocket=null;
            }
            return isServerRunning;
        }
	
	public static void  startemulator() throws InterruptedException, IOException
	{

		Thread.sleep(7000);
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"//src//main//resources//extension.bat");		
		Thread.sleep(15000);
	}
	
	public static AndroidDriver<AndroidElement> capabilities(String deviceName, String appActivity, String appPackage, String platformName, String chromeDriver) throws IOException, InterruptedException
	{
		//FileIO FileReader
		FileReader fr=new FileReader(System.getProperty("user.dir")+"//src//main//java//global.properties");
		Properties pro=new Properties();
		pro.load(fr);
		deviceName=pro.getProperty("deviceName");
		appActivity=pro.getProperty("appActivity");
		appPackage=pro.getProperty("appPackage");
		platformName=pro.getProperty("platformName");
		chromeDriver=pro.getProperty("chromeDriver");
		if(deviceName.contains("soundharya"))
		{
			startemulator();
		}
		
		
		
		
		
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		dc.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, chromeDriver);
		AndroidDriver<AndroidElement> driver =new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		return driver;
	}

}
