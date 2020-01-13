import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ViewReports {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Inderjeet Singh Sans\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://damp-sands-8561.herokuapp.com/");
		driver.findElement(By.id("user_email")).sendKeys("cinderjeet@gmail.com");
		driver.findElement(By.id("user_password")).sendKeys("codetheoryio");
		driver.findElement(By.name("commit")).click();
		WebDriverWait w = new WebDriverWait(driver,5);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sidebar-wrapper\"]//a[text()=\"Reports\"]"))).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"page-content-wrapper\"]//a[text()=\"Monthly\"]"))).click();

		Thread.sleep(1000);
	 	WebElement mytable = driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]//table"));
	 	mytable.click();
    	List < WebElement > Columns_row = mytable.findElements(By.tagName("td"));
    	int columns_count = Columns_row.size();
    	for (int column = 0; column < columns_count; column++) {
     	        String celtext = Columns_row.get(column).getText();
    	        System.out.println(celtext); 	       
    	    }
		Assert.assertNotNull(Columns_row);
		System.out.println("Test passed");
		driver.quit();
		
	}

}
