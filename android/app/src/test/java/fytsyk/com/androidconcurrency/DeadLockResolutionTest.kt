package fytsyk.com.androidconcurrency

import kotlinx.coroutines.*
import org.junit.Test

class DeadLockResolutionTest {

    val singleThreadContext = newSingleThreadContext("mySerialContext")

    val singleThreadContext2 = newSingleThreadContext("mySerialContext2")

    @Test
    fun runCodeWithConcurrencyProblem() = runBlocking {
        runDeadLock()
        delay(2000)
    }

    fun runDeadLock() {
        GlobalScope.launch(singleThreadContext) {
            println("Blocking coroutine start")
            runBlocking(singleThreadContext2) {
                //Outer block executes in another thread, so following statements are reachable
                println("Unreachable statement")
            }
            println("Unreachable statement")
        }
    }
}