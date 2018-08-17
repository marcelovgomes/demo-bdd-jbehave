package demo.bdd.jbehave.domain;

public class Customer {

	private double currentFunds;
	private boolean withdrawRealized;
	private String bankStatement;

	public boolean withdraw(double withdrawValue) {
		if (currentFunds < withdrawValue) {
			throw new RuntimeException("Insufficient funds!");
		}
		
		if (currentFunds < withdrawValue) {
			return false;
		} else {
			return true;
		}
	}

	public boolean bankStatement() {
		if (bankStatement == null) {
			throw new RuntimeException("Bank statement is not available for the month selected");
		}
		
		if (bankStatement == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public double getCurrentFunds() {
		return currentFunds;
	}

	public void setCurrentFunds(double currentFunds) {
		this.currentFunds = currentFunds;
	}

	public boolean isWithdrawRealized() {
		return withdrawRealized;
	}

	public void setWithdrawRealized(boolean withdrawRealized) {
		this.withdrawRealized = withdrawRealized;
	}
	
	public String getBankStatement() {
		return bankStatement;
	}
	
	public void setBankStatement(String bankStatement) {
		this.bankStatement = bankStatement;
	}
}