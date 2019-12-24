package seleniumpractice;

import org.testng.annotations.Test;

public class visitingwebsite extends launchbrowser  {
	@Test
	public void visitingweb() {
		driver =launchbrowser();
		driver.get("https://www.expleogroup.com");
		System.out.println("User Navigated to mentioned url");
		driver.close();
	}

}
