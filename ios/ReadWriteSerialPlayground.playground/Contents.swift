import UIKit
import PlaygroundSupport
PlaygroundPage.current.needsIndefiniteExecution = true

var someValue = 0

let serialQueue = DispatchQueue(label: "mySerialQueue")

func incrementValue() {
    serialQueue.async {
        someValue = someValue + 1
    }
}

for _ in 0...999 {
    DispatchQueue.global().async {
        incrementValue()
    }
}

sleep(2)
print(someValue) // always prints 1000

