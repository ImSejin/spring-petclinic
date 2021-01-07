package org.springframework.samples.petclinic.payment;

public class Store {

	private Payment payment;

	public Store(Payment payment) {
		this.payment = payment;
	}

	public void buySomething(double amount) {
		this.payment.pay(amount);
	}

}
