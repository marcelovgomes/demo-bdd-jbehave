package demo.bdd.jbehave.services;

import org.jbehave.scenario.annotations.Given;
import org.jbehave.scenario.annotations.Then;
import org.jbehave.scenario.annotations.When;
import org.jbehave.scenario.steps.Steps;
import org.junit.Assert;

import demo.bdd.jbehave.domain.Customer;

public class BankStatementWithTransactionsDetails extends Steps {

	private Customer customer;
	private boolean bankStatement = false;

	private Exception exception;

	@Given("a customer with financial transactions realized")
	public void populateCustomer() {
		customer = new Customer();
		customer.setBankStatement("$$$$$$$");
	}

	@When("needs of a bank statement with details")
	public void bankStatement() {
		try {
			bankStatement = customer.bankStatement();
		} catch (Exception e) {
			this.exception = e;
		}
	}

	@Then("bank statement is available")
	public void checkStatement() {
		Assert.assertTrue(bankStatement);
	}
}