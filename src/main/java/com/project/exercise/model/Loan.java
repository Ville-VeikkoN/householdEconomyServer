package com.project.exercise.model;

import lombok.Data;

@Data
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
