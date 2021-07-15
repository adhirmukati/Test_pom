package com.westwing.runner;


	import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
	 
	@RunWith(Cucumber.class)
	@CucumberOptions(
	 features ="src/test/resources/WW_Search.feature",glue= {"com.westwing.utility" ,"com.westwing.StepDefination"}
		,monochrome = true
		,publish = true) 
	
	public class TestRunner {
		
		
	}

//$ docker run -d -p 4444:4444 --shm-size="2g" selenium/standalone-chrome:4.0.0-rc-1-prerelease-20210713
