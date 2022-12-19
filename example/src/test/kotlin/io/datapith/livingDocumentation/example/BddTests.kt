package io.datapith.livingDocumentation.example

import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(
    features = ["src/test/features"],
    glue = ["io.datapith.livingDocumentation.example.steps"],
    plugin = ["json:build/test-results/BddTests.json"]
)
class BddTests
