package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizable {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/resizable/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement findElement = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(findElement);
		Thread.sleep(2000);
		WebElement findElement2 = driver.findElement(By.xpath("(//div[@id='resizable']/div)[3]"));
		//int x = findElement2.getLocation().getX();
		//int y = findElement2.getLocation().getY();
		//System.out.println(x);
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(findElement2, 30, 30).perform();
		
		
	}

}
