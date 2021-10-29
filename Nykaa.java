package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.nykaa.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement findElement = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(findElement).perform();

		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
		driver.findElement(By.linkText("L'Oreal Paris")).click();
		String title = driver.getTitle();
		if (title.contains("L'Oreal Paris")) {
			System.out.println("Title contains L'Oreal Paris");
		} else {
			System.out.println("Title does not contain L'Oreal Paris");
		}
		driver.findElement(By.xpath("//span[@class='sort-name']")).click();
		driver.findElement(By.xpath("(//div[@class='control-value'])[4]/following-sibling::div")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='Category']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("(//span[text()='Shampoo'])")).click();
		driver.findElement(By.xpath("(//span[text()='Concern'])")).click();
		driver.findElement(By.xpath("(//span[text()='Color Protection'])")).click();

		List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='css-zzfhy0']/div//a/div/div[1]"));
		for (WebElement x : findElements) {
			String text = x.getText();
			if (text.contains("Shampoo")) {
				System.out.println("the Filter is applied with Shampoo");
			} else {
				System.out.println("the Filter is not applied with Shampoo");
			}
			break;
		}
		driver.findElement(By.xpath("(//div[text()=\"L'Oreal Paris Colour Protect Shampoo\"])[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> l = new ArrayList<String>(windowHandles);
		driver.switchTo().window(l.get(1));
		Thread.sleep(2000);
		WebElement findElement2 = driver.findElement(By.xpath("//select[@title=\"SIZE\"]"));
		Select s = new Select(findElement2);
		s.selectByIndex(0);
		
		String text = driver.findElement(By.xpath("(//span[text()=\"₹150\"])[1]")).getText();
		System.out.println("MRP : "+ text);
		
		driver.findElement(By.xpath("(//span[text()=\"ADD TO BAG\"])[1]")).click();
		driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
		//Thread.sleep(4000);
		
		WebElement frame1 = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame1);
		
		String text2 = driver.findElement(By.xpath("//div[@class='table-row ']//div[2]")).getText();
		System.out.println("Grand total : " + text2);
		
		driver.findElement(By.xpath("//div[@class='second-col']//button")).click();
		driver.findElement(By.xpath("//div[text()=\"I do not want any more benefits from Nykaa\"]//following-sibling::button")).click();
		
		String text3 = driver.findElement(By.xpath("(//div[@class='value'])[2]")).getText();
		if (text2.equals(text3)) {
			System.out.println("Grand total is same");
		} else {
			System.out.println("Grand total is diff");
		}
		
		driver.quit();
		
	}

}
