package fr.acs.kmm

import kotlin.test.Test
import kotlin.test.assertTrue

class CommonGreetingTest {

    @Test
    fun testExample() {
        assertTrue(Greeting().greeting().contains("Hello"), "Check 'Hello' is mentioned")
    }
}

/*
@RunWith(Cucumber::class)
@CucumberOptions(features = ["src/test/assets"], publish = false)
class SumSteps : En {
    init {
        Given("I have two numbers {int} and {int}") { n1: Int, n2: Int ->
            num1 = n1
            num2 = n2
        }
        When("I add those up") {
            println("Adding")
        }
        Then("I get a sum result") {
            println(num1+ num2)
        }
    }
    companion object {
        var num1: Int = 0
        var num2: Int = 0
    }
}*/
