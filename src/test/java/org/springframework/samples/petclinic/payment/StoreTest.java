package org.springframework.samples.petclinic.payment;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

class StoreTest {

	@Test
	void buySomething() {
		// given
		Payment payment = new CreditCard();

		// when & then
		Store store = new Store(payment);
		store.buySomething(60_000);
	}

	@RepeatedTest(10)
	void generateRandomDatetime() {
		// given
		LocalDateTime startTime = LocalDateTime.of(
			2019, Month.JANUARY, 1, 9, 0, 0);
		LocalDateTime endTime = LocalDateTime.of(
			LocalDate.of(2020, 12, 17), LocalTime.now());

		// when
		long randomSeconds = ThreadLocalRandom.current()
			.nextLong(startTime.toEpochSecond(ZoneOffset.UTC), endTime.toEpochSecond(ZoneOffset.UTC));
		LocalDateTime randomTime = LocalDateTime.ofInstant(
			Instant.ofEpochSecond(randomSeconds), ZoneId.systemDefault());

		// then
		assertThat(randomTime)
			.satisfies(isTrue(it -> it.isBefore(endTime)))
			.satisfies(isTrue(it -> it.isAfter(startTime)));
		System.out.println(randomTime);
	}

	private static <T> Condition<T> isTrue(Predicate<T> predicate) {
		return new Condition<>(predicate, "");
	}

}
