package com.patterns.builder;

public class BankAccount {
	private String accountName;
	private String accountNumber;
	private String accountType;
	private String email;
	private boolean newsLetter;
	private boolean isActive;
	private double balance;

	public String getAccountName() {
		return accountName;
	}

	public String getAccountType() {
		return accountType;
	}

	public String getEmail() {
		return email;
	}

	public boolean isNewsLetter() {
		return newsLetter;
	}

	public double getBalance() {
		return balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}


	public boolean isActive() {
		return isActive;
	}


	public BankAccount(BankAccountBuilder builder) {
		this.accountName = builder.name;
		this.accountNumber = builder.number;
		this.accountType = builder.type;
		this.email = builder.email;
		this.balance = builder.balance;
		this.newsLetter = builder.newsLetter;
		this.isActive = builder.isActive;
	}

	public static class BankAccountBuilder {
		private String name;
		private String number;
		private String type;
		private String email;
		private boolean newsLetter;
		private double balance;
		private boolean isActive;

		public BankAccountBuilder(String name, String number) {
			this.name = name;
			this.number = number;
		}

		public BankAccountBuilder withAccountType(String number) {
			this.number = number;
			return this;
		}

		public BankAccountBuilder withEmail(String email) {
			this.email = email;
			return this;
		}

		public BankAccountBuilder withBalance(double balance) {
			this.balance = balance;
			return this;
		}

		public BankAccountBuilder wantsNewsLetter(boolean newsletter) {
			this.newsLetter = newsletter;
			return this;
		}

		public BankAccountBuilder isActive(boolean isActive) {
			this.isActive = isActive;
			return this;
		}

		public BankAccount build() {
			return new BankAccount(this);
		}

	}

}
