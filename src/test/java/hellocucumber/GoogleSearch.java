package hellocucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSearch {
	WebDriver driver;

	@Given("^I am on google search page$")
	public void i_am_on_google_search_page() throws Exception {
		driver = new ChromeDriver();
		driver.get("https://www.google.co.in");
	}

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String searchText) throws Exception {
		driver.findElement(By.name("q")).sendKeys(searchText);
		driver.findElement(By.name("q")).submit();
	}

	@Then("^the page title should start with \"([^\"]*)\"$")
	public void the_page_title_should_start_with(String searchString) throws Exception {
		new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {
				return driver.getTitle().startsWith(searchString);
			}
		});
	}

	@After
	public void closeDrivers() {
		if (driver != null)
			driver.quit();
	}
}
