package org.springframework.samples.petclinic.payment;

public class Cash implements Payment {

	@Override
	public void pay(double amount) {
		System.out.printf("현금 결제: %,f\n", amount);
	}

}
