package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Draggable {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/draggable/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement findElement = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(findElement);
		Thread.sleep(2000);
		WebElement findElement2 = driver.findElement(By.xpath("//div[@id='draggable']/p"));
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(findElement2, 50, 100).perform();
		
	}

}
