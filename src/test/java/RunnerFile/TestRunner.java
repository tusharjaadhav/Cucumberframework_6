package RunnerFile;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "C:\\Users\\TUSHAR\\Desktop\\Cucumber_Framework6\\src\\test\\resources",
        glue = "Stepdefination",
        dryRun = false,
        plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
                "junit:target/cucumber-reports/Cucumber.xml",
                "html:target/cucumber-reports.html"},
        tags = "@tushar"





)
public class TestRunner {
}
