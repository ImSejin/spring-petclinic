package org.springframework.samples.petclinic.payment;

import org.springframework.util.StopWatch;

public class CreditCard implements Payment {

	private final Payment cash = new Cash();

	@Override
	public void pay(double amount) {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		if (amount > 50_000) {
			System.out.printf("신용카드: %,f\n", amount);
		} else {
			this.cash.pay(amount);
		}

		stopWatch.stop();
		System.out.println(stopWatch.prettyPrint());
	}

}
