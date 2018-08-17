package demo.bdd.jbehave.services;

import org.jbehave.scenario.annotations.Given;
import org.jbehave.scenario.annotations.Then;
import org.jbehave.scenario.annotations.When;
import org.jbehave.scenario.steps.Steps;
import org.junit.Assert;

import demo.bdd.jbehave.domain.Customer;

public class BankStatementWithoutTransactions extends Steps {

	private Customer customer;
	private boolean bankStatement = false;

	private Exception exception;

	@Given("a customer without financial transactions realized")
	public void populateCustomer() {
		customer = new Customer();
	}

	@When("needs of a bank statement")
	public void bankStatement() {
		try {
			bankStatement = customer.bankStatement();
		} catch (Exception e) {
			this.exception = e;
		}
	}

	@Then("bank statement is not available and the message $msg")
	public void checkStatement(String msg) {
		Assert.assertFalse(bankStatement);
		Assert.assertEquals(msg, exception.getMessage());
	}
}