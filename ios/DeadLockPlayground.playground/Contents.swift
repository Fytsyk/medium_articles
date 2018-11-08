import UIKit
import PlaygroundSupport
PlaygroundPage.current.needsIndefiniteExecution = true

let serialQueue = DispatchQueue(label: "mySerialQueue")

serialQueue.async {
    print("Blocking block starts")
    serialQueue.sync {
        print("Unreachable statement")
    }
    print("Unreachable statement")
}


