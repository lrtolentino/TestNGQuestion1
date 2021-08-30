package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.BasePage;

public class RunningTestNG extends BasePage {

	WebDriver driver;

	@BeforeMethod
	public void init() {

		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://techfios.com/test/101/");
		// return driver;

	}

	@Test
	public void TestNGAutomation() {

		driver.findElement(By.cssSelector("body > div.advance-controls > input[type=text]:nth-child(1)"))
				.sendKeys("Shaquille Oniell For Real" + randomGenerator(999));
		
		driver.findElement(By.xpath("/html/body/div[4]/input[2]")).click();

		WebElement DUE_DAY_DROPDOWN_ELEMENT = driver.findElement(By.xpath("//select[@name = 'due_day']"));

		Select sel1 = new Select(DUE_DAY_DROPDOWN_ELEMENT);
		sel1.selectByVisibleText("17");

		WebElement DUE_MONTH_DROPDOWN_ELEMENT = driver.findElement(By.xpath("//select[@name = 'due_month']"));

		Select sel2 = new Select(DUE_MONTH_DROPDOWN_ELEMENT);
		sel2.selectByVisibleText("Dec");

		WebElement DUE_YEAR_DROPDOWN_ELEMENT = driver.findElement(By.xpath("//select[@name = 'due_year']"));

		Select sel3 = new Select(DUE_YEAR_DROPDOWN_ELEMENT);
		sel3.selectByVisibleText("2021");

		driver.findElement(By.cssSelector("#extra > input[type=text]:nth-child(7)"))
		.sendKeys("Pickle Rick" + randomGenerator(999));
		
		WebElement ADD_CATEGORY_DROPDOWN_ELEMENT = driver.findElement(By.xpath("//select[@name = 'colour']"));

		Select sel4 = new Select(ADD_CATEGORY_DROPDOWN_ELEMENT);
		sel4.selectByVisibleText("Gray");
		
		driver.findElement(By.xpath("//*[@id=\"extra\"]/input[2]")).click();
		
		driver.findElement(By.linkText("Add the category with this colour")).click();
		
	}

	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
