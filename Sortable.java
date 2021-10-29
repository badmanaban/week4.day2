package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement findElement = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(findElement);
		Thread.sleep(2000);
		WebElement e1 = driver.findElement(By.xpath("(//ul[@id='sortable']/li)[1]"));
		WebElement e2 = driver.findElement(By.xpath("(//ul[@id='sortable']/li)[3]"));
		WebElement e3 = driver.findElement(By.xpath("(//ul[@id='sortable']/li)[1]"));
		WebElement e4 = driver.findElement(By.xpath("(//ul[@id='sortable']/li)[1]"));
		
		Actions builder = new Actions(driver);
		int x = e2.getLocation().getX();
		int y = e2.getLocation().getY();
		builder.clickAndHold(e1).moveByOffset(x, y).release().perform();
		
		int xx = e4.getLocation().getX();
		int yy = e4.getLocation().getY();
		builder.clickAndHold(e3).moveByOffset(xx, yy).release().perform();
	}

}
