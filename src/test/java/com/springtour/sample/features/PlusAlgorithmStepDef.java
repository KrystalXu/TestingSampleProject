package com.springtour.sample.features;


import org.springframework.beans.factory.annotation.Autowired;

import com.springtour.sample.PlusAlgorithm;

import static org.junit.Assert.*;
import cucumber.api.java.en.*;
import cucumber.runtime.java.StepDefAnnotation;

@StepDefAnnotation
public class PlusAlgorithmStepDef {
	
	private int result = 0;
	
	@Autowired
	private PlusAlgorithm plusAlgorithm;
	
	@Given("^I have a plus calculator with existed number (\\d+)$")
	public void I_have_a_plus_calculator_with_existed_number(int arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	}

	@When("^plus \"([^\"]*)\"$")
	public void plus(String arg) throws Throwable {
		result = plusAlgorithm.plus(Integer.parseInt(arg));
	}

	@Then("^I will get \"([^\"]*)\"$")
	public void I_will_get(String arg) throws Throwable {
		assertEquals(String.valueOf(result), arg);
	}

}
