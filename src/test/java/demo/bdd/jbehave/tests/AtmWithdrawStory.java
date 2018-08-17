package demo.bdd.jbehave.tests;

import org.jbehave.scenario.Scenario;

import demo.bdd.jbehave.services.WithdrawWithInsufficientFunds;
import demo.bdd.jbehave.services.WithdrawWithSufficientFunds;

public class AtmWithdrawStory extends Scenario {

	public AtmWithdrawStory() {
		addSteps(new WithdrawWithInsufficientFunds());
		addSteps(new WithdrawWithSufficientFunds());
	}
}
