package demo.bdd.jbehave.tests;

import org.jbehave.scenario.Scenario;

import demo.bdd.jbehave.services.BankStatementWithoutTransactions;
import demo.bdd.jbehave.services.BankStatementWithTransactionsDetails;

public class AtmBankStatementStory extends Scenario {

	public AtmBankStatementStory() {
		addSteps(new BankStatementWithoutTransactions());
		addSteps(new BankStatementWithTransactionsDetails());
	}
}
