package seleniumpractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//import org.openqa.selenium.chrome.ChromeDriver;

public class launchbrowser {
	public static WebDriver driver;
@Test

public  WebDriver launchbrowser(){// TODO Auto-generated method stub
       // System.setProperty("webdriver.chrome.driver","/Users/expleo/node_modules/chromedriver/lib/chromedriver/chromedriver.exe");
		//System.setProperty("", value)
		
		//System.setProperty("webdriver.chrome.driver", "/Users/expleo/Downloads⁩/chromedriver.exe");
        driver=new ChromeDriver();
		//driver.manage().wait(1000);
       // driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
		//driver.get("https://www.expleogroup.com");
		//driver.close();
        return driver;

	}

public static void getScreenshot(String s) throws InvalidFormatException, FileNotFoundException, IOException {
	// TODO Auto-generated method stub
	File scrfile=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+"\\Screenshots\\"+s+".png"));
	XWPFDocument doc = new XWPFDocument();
	XWPFParagraph p = doc.createParagraph();
	XWPFRun r = p.createRun();
	r.setText(s);
	r.addPicture(new FileInputStream(scrfile), Document.PICTURE_TYPE_PNG, s, Units.toEMU(400), Units.toEMU(400));
	FileOutputStream out = new FileOutputStream(System.getProperty("user.dir")+"\\Screenshots\\"+s+".docx");
	doc.write(out);
	out.close();
	doc.close();
}

}
