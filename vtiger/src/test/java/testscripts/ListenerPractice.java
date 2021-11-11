package testscripts;

import org.junit.Assert;
import org.testng.annotations.Test;

public class ListenerPractice {
	@Test
	public void listnerpractice()
	{
		System.out.println("test script failed");
		Assert.fail();
	}

}
