package Runner;

import Tests.TestBase;
import cucumber.api.CucumberOptions;


//Run all written in feature file && Step Definition Class through Cucumber options.........
@CucumberOptions(features="src\\test\\java\\Features"
,glue= {"StepDefinition"}
,plugin= {"pretty", "html:target/cucumber-reports" },
monochrome=true)
public class TestRunner  extends TestBase
{

}
