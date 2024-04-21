package ru.stqa.maven.Ex20Cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"}, glue = {"ru.stqa.maven.Ex20Cucumber"}, features = {"src/test/resources"})
public class RunSpecs {
   };

