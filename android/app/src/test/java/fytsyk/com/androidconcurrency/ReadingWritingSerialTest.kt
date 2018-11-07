package fytsyk.com.androidconcurrency

import kotlinx.coroutines.*
import org.junit.Test

class ReadingWritingSerialTest {

    private var someValue = 0
    val singleThreadContext = newSingleThreadContext("mySerialContext")

    private fun incrementValue() {
        GlobalScope.launch(singleThreadContext) {
            someValue = someValue + 1
        }
    }

    @Test
    fun runCodeWithConcurrencyProblem() = runBlocking {
        for (i in 0..999) {
            GlobalScope.launch() {
                incrementValue()
            }
        }
        delay(2000)
        print(someValue)//result is always 1000
    }
}