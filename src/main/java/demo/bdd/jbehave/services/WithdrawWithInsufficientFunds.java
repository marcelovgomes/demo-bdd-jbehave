package demo.bdd.jbehave.services;

import org.jbehave.scenario.annotations.Given;
import org.jbehave.scenario.annotations.Then;
import org.jbehave.scenario.annotations.When;
import org.jbehave.scenario.steps.Steps;
import org.junit.Assert;

import demo.bdd.jbehave.domain.Customer;

public class WithdrawWithInsufficientFunds extends Steps {

	private Customer customer;

	private boolean withdrawRealized = false;

	private Exception exception;

	@Given("a customer with negative funds of EUR $currentFunds")
	public void populateCustomer(double currentFunds) {
		customer = new Customer();
		customer.setCurrentFunds(currentFunds);
	}

	@When("request a withdraw of EUR $withdrawValue")
	public void withdraw(double withdrawValue) {

		try {
			withdrawRealized = customer.withdraw(withdrawValue);
		} catch (Exception e) {
			this.exception = e;
		}
	}

	@Then("withdraw is not allowed and return the message $msg")
	public void checkFunds(String msg) {
		Assert.assertFalse(withdrawRealized);
		Assert.assertEquals(msg, exception.getMessage());

	}
}