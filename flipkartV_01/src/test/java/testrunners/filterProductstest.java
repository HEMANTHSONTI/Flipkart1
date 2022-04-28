package testrunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="featurefiles",
glue="stepdefinitions",
dryRun=false,
tags=("@tag1,@tag2,@tag3"),
plugin={"com.cucumber.listener.ExtentCucumberFormatter:reports/results.html"})
public class filterProductstest 
{

}
