package com.selfPractice.designPatterns;
public class DecoratorDesignPattern {
	// Component on Decorator design pattern
	public abstract class Currency {
		String description = "Unknown currency";

		public String getDescription() {
			return description;
		}

		public abstract double cost(double value);
	}

	// Concrete Component
	public class Rupee extends Currency {
		double value;

		public Rupee() {
			description = "indian rupees";
		}

		public double cost(double v) {
			value = v;
			return value;
		}
	}

	// Another Concrete Component
	public class Dollar extends Currency {
		double value;

		public Dollar() {
			description = "Dollar";
		}

		public double cost(double v) {
			value = v;
			return value;
		}
	}

	// Decorator
	public abstract class Decorator extends Currency {
		public abstract String getDescription();
	}

	// Concrete Decorator
	public class USDDecorator extends Decorator {

		Currency currency;

		public USDDecorator(Currency currency) {
			this.currency = currency;
		}

		public String getDescription() {
			return currency.getDescription() + " ,its US Dollar";
		}

		@Override
		public double cost(double value) {
			// TODO Auto-generated method stub
			return 0;
		}
	}

	// Another Concrete Decorator
	public class SGDDecorator extends Decorator {
		Currency currency;

		public SGDDecorator(Currency currency) {
			this.currency = currency;
		}

		public String getDescription() {
			return currency.getDescription() + " ,its singapore Dollar";
		}

		@Override
		public double cost(double value) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
}