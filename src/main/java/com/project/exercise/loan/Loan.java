package com.project.exercise.loan;

public class Loan {

	private LoanType type;
	private Long amount;
	private double interest;
	private long loanPeriodInMonths;
	
	public Loan(LoanType type, Long amount, double interest, long loanPeriodInMonths) {
		this.type = type;
		this.amount = amount;
		this.interest = interest;
		this.loanPeriodInMonths = loanPeriodInMonths;
	}
	public LoanType getType() {
		return type;
	}
	public void setType(LoanType type) {
		this.type = type;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
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
	public void setLoanPeriodInMonths(long loanPeriodInMonths) {
		this.loanPeriodInMonths = loanPeriodInMonths;
	}
	
	public Double getMonthlyPayment() {
		
	}
	
	
}
