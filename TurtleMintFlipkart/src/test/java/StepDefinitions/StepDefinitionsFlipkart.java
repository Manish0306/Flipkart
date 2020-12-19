package StepDefinitions;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import TestRunner.RunnerClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;




public class StepDefinitionsFlipkart extends RunnerClass {
	
	WebDriverWait Wait=new WebDriverWait(driver,100);
  
	@Given("^User land on the Flipkart homepage$")
	public void URLLaunch() {
		
		Wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[text()='✕']")));
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		Wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@placeholder='Search for products, brands and more']")));
		System.out.println("User Successfully Navigated to Flipkart home page");
		
	
	}

	@And("^Search for the (.*)$")
	public void SearchBooks(String Search) {
		
		driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys(Search);
		Wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='col-12-12 _1MRYA1 _38UFBk']")));
		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
		
			
		

	}
	@And("^Validate all the Books present on the first page of Flipkart$")
	public void ValiadteBooks() throws InterruptedException {
		Wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[contains(.,'Showing 1 – 40')]")));
		//Wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='CXW8mj']/img")));
		Thread.sleep(5000);
		List<WebElement> NumberofBooks = driver.findElements(By.xpath("//a[@class='s1Q9rs']"));
		System.out.println(NumberofBooks);
	      int TotalBooks = NumberofBooks.size();
	      System.out.println(TotalBooks);
	      String winHandleBefore = driver.getWindowHandle();
	      for( int j = 0; j< NumberofBooks.size();j++){
	        //Store the Parent Window in string to switch back
	    	  
	    	  NumberofBooks.get(j).click();
	      
	    	  //Switch to new window 
	    	String winHandle=driver.getWindowHandle();
	    	    driver.switchTo().window(winHandle);
	    	    //driver.close();
	    	   System.out.println(driver.getCurrentUrl()); 
	    	   
	    	 driver.switchTo().window(winHandleBefore);
	    	 
	    	  
	    	
	      }
		
	
	}
}

	