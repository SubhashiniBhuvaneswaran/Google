package sample;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearch {
 public static void main(String args[]) throws InterruptedException {
	   WebDriverManager.chromedriver().setup();
	   WebDriver driver = new ChromeDriver();
	   driver.get("https://www.google.com/");
	   driver.manage().window().maximize();
	   driver.manage().deleteAllCookies();
   
	   driver.findElement(By.name("q")).sendKeys("Java");;
	   Thread.sleep(2000);
	   List <WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='aypzV']"));
	   Thread.sleep(2000);
	   
	   for(int i=0;i<list.size();i++) 
	   {
		    String input = list.get(i).getText();
			if(input.contains("javascript"))
			{
				list.get(i).click();
				break;
			}	
	   }
	   driver.navigate().back();
	   driver.close();
}
}
