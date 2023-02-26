package com.project.exercise.model;

public class Loan {

	private final LoanType type;
	private int amount;
	private double interest;
	private int loanPeriodInMonths;

	public Loan(LoanType type, int amount, double interest, int loanPeriodInMonths) {
		this.type = type;
		this.amount = amount;
		this.interest = interest;
		this.loanPeriodInMonths = loanPeriodInMonths;
	}

	public LoanType getType() {
		return type;
	}
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public long getLoanPeriodInMonths() {
		return loanPeriodInMonths;
	}

	public void setLoanPeriodInMonths(int loanPeriodInMonths) {
		this.loanPeriodInMonths = loanPeriodInMonths;
	}

	/**
	 * Calculates roughly the monthly payment using loan amount, loan interest and
	 * amount of (monthly) payments.
	 * 
	 * @return
	 */
	public int getMonthlyPayment() {
		if (interest == 0) {
			return amount / loanPeriodInMonths;
		}
		double interestFactorPerMonth = (interest / 12) / 100 + 1;
		double monthlyPayment = amount * (Math.pow(interestFactorPerMonth, loanPeriodInMonths))
				* ((1 - interestFactorPerMonth) / (1 - Math.pow(interestFactorPerMonth, loanPeriodInMonths)));

		return (int) monthlyPayment;
	}

}
