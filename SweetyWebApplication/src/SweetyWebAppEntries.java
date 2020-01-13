import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SweetyWebAppEntries {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Inderjeet Singh Sans\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://damp-sands-8561.herokuapp.com/");
		driver.findElement(By.id("user_email")).sendKeys("cinderjeet@gmail.com");
		driver.findElement(By.id("user_password")).sendKeys("codetheoryio");
		driver.findElement(By.name("commit")).click();
		WebDriverWait w = new WebDriverWait(driver,5);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sidebar-wrapper\"]//a[text()=\"Levels\"]"))).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"btn btn-primary\"]"))).click();
		
		for(int i=0;i<5;i++)
		{
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"btn btn-primary\"]"))).click();
			Select year= new Select(w.until(ExpectedConditions.visibilityOfElementLocated(By.id("entry_recorded_at_1i"))));
			year.selectByValue("2019");
			Select month=new Select(driver.findElement(By.id("entry_recorded_at_2i")));
			month.selectByValue("11");
			Select date=new Select(driver.findElement(By.id("entry_recorded_at_3i")));
			date.selectByValue("27");
			w.until(ExpectedConditions.visibilityOfElementLocated(By.id("entry_level"))).sendKeys("101");
			driver.findElement(By.cssSelector("#new_entry > input.btn.btn-default")).click();
			
		}
		Assert.assertEquals(w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div[1]"))).getText(), "Maximum entries reached for this date.");
		System.out.println("Test passed");
		driver.close();
	}

       													

}
