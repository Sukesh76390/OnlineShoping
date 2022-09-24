package com.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = { "pretty", "html:target/cucumber-reports/rpusage.html"},
		monochrome = true,
		features = {"src/test/resources/features/Shop.feature" },
		glue = "com.stepdefination")

public class ShoppingRunnerTest extends AbstractTestNGCucumberTests {

}
