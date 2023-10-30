package ru.ibs;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features",
        glue = {"ru.ibs.framework.steps", "ru.ibs.framework.hooks"},
        tags = "@all"
)


public class CucumberRunner {
}
