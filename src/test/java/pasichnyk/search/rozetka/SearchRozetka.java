package pasichnyk.search.rozetka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchRozetka {
	private WebDriver webDriver; 
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/Liudmyla/Documents/programs/chromedriver 2");
		webDriver = new ChromeDriver();
	}
	
	@After
	public void cleanUp() {
		webDriver.close();
	}
	
	@Test
	public void openRozetka() {
		webDriver.get("http://rozetka.com.ua/");
		WebElement element = webDriver.findElement(By.name("text"));
		element.clear();
		element.sendKeys("macbook pro");
		webDriver.findElement(By.name("rz-search-button")).click();
		String searchResult = webDriver.findElement(By.className("rz-search-result-qnty")).getText();
		String[] qnty = searchResult.split(" ");
		Integer qntyInt = Integer.valueOf(qnty[1]);
		System.out.println(qntyInt);
	}
}
