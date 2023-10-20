package frames02;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import frame01.capabilties04;

public class testcase02 extends capabilties04 {
	@Test
	public void tc4()
	{
		System.out.println("Hello");
	}
	@AfterTest
	public void tc5()
	{
		service.stop();
	}

}
