package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Droppable {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement findElement = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(findElement);
		Thread.sleep(2000);
		WebElement findElement2 = driver.findElement(By.xpath("//div[@id='draggable']/p"));
		WebElement findElement3 = driver.findElement(By.xpath("//div[@id='droppable']/p"));
		
		Actions builder = new Actions(driver);
		builder.dragAndDrop(findElement2, findElement3).perform();
	}

}
