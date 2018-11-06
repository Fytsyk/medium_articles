package fytsyk.com.androidconcurrency

import kotlinx.coroutines.*
import org.junit.Test

class ConcurrencyProblemTest {

    private var someValue = 0

    @Test
    fun runCodeWithConcurrencyProblem() = runBlocking {
        for (i in 0..999) {
            GlobalScope.launch() {
                someValue = someValue + 1
            }
        }
        delay(2000)
        print(someValue)//result varies from time to time in range 800..1000 on MBP 2015
    }
}