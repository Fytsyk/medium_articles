package fytsyk.com.androidconcurrency

import kotlinx.coroutines.*
import org.junit.Test

class DeadLockTest {

    val singleThreadContext = newSingleThreadContext("mySerialContext")

    @Test
    fun runCodeWithConcurrencyProblem() = runBlocking {
        runDeadLock()
        delay(2000)
    }

    fun runDeadLock() {
        GlobalScope.launch(singleThreadContext) {
            println("Blocking coroutine start")
            runBlocking(singleThreadContext) {
                //Outer block waits till inner block completes but inner block cannot start till outer completes
                println("Unreachable statement")
            }
            println("Unreachable statement")
        }
    }
}