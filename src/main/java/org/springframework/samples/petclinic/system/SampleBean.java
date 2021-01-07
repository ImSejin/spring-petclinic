package org.springframework.samples.petclinic.system;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SampleBean {

	@Bean
	public SampleObject sampleObject() {
		return new SampleObject();
	}

}
