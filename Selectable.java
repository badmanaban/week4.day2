package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement findElement = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(findElement);
		Thread.sleep(2000);

		WebElement e1 = driver.findElement(By.xpath("//li[text()=\"Item 2\"]"));
		WebElement e2 = driver.findElement(By.xpath("//li[text()=\"Item 4\"]"));
		WebElement e3 = driver.findElement(By.xpath("//li[text()=\"Item 5\"]"));
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).click(e1).click(e2).click(e3).keyUp(Keys.CONTROL).perform();

	}

}
