package hellocucumber;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs {

	private String today, actualAnswer;

	class IsItFriday {
		String isItFriday(String today) {
			if (today.equals("Friday")) {
				return "TGIF";
			}
			return "Nope";
		}
	}

	@Given("^today is \"([^\"]*)\"$")
	public void today_is(String today) throws Exception {
		this.today = today;
	}

	@When("^I ask whether it's Friday yet$")
	public void i_ask_whether_it_s_Friday_yet() {
		actualAnswer = new IsItFriday().isItFriday(today);
	}

	@Then("^I should be told \"([^\"]*)\"$")
	public void i_should_be_told(String arg1) {
		assertEquals("Today is not Friday", actualAnswer, arg1);
	}
}