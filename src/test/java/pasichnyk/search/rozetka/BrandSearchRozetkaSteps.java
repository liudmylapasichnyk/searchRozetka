package pasichnyk.search.rozetka;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrandSearchRozetkaSteps {
	private WebDriver webDriver;
	
	@Given("Chrome with opened Rozetka site")
	public void openRozetkaBrand() {
		System.setProperty("webdriver.chrome.driver", ("src/test/resources/chromedriver"));
		webDriver = new ChromeDriver();
		webDriver.get("http://rozetka.com.ua/");
	}
	
	@When ("user types in search bar and confirms it") 
	public void performSearchBrand() {
		WebElement element = webDriver.findElement(By.name("text"));
		element.clear();
		element.sendKeys("Dyson");
		webDriver.findElement(By.name("rz-search-button")).click();
	}
	    
	@Then ("user can see search result page")
	public void checkResultBrand() {
		String searchResultBrand = webDriver.findElement(By.className("rz-search-result-qnty")).getText();
		webDriver.close();
		String[] qntyBrand = searchResultBrand.split(" ");
		Integer qntyIntBrand = Integer.valueOf(qntyBrand[1]);
		System.out.println("Result " + qntyIntBrand);
		Assert.assertTrue(qntyIntBrand > 0);
	}
}
