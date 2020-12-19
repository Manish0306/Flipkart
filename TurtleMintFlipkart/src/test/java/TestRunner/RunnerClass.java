package TestRunner;
 
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class) 
@CucumberOptions(features= "src/test/java/Features",glue= "StepDefinitions",tags= {"@Turtlemint_Flipkart"}) 

public class RunnerClass {
	
	public static WebDriver driver; 
	 
	@BeforeClass
	public static void setEnvironment() throws IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Manish Kumar\\chromedriver.exe");
		
		 driver = new ChromeDriver(); 
		 driver.navigate().to("http://Flipkart.com/");
		 System.out.println("Flipart URL has been launched");
       driver.manage().window().maximize();
		
	}
	@AfterClass
	public static void reportgenerate()
	{
		//HtmlReport.generate();
		//driver.close();
		//driver.quit();
	}
}