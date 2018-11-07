import UIKit
import PlaygroundSupport
PlaygroundPage.current.needsIndefiniteExecution = true

var someValue = 0

for _ in 0...999 {
    DispatchQueue.global().async {
        someValue = someValue + 1
    }
}
sleep(2)
print(someValue) // prints 800..999, but not expected 1000

