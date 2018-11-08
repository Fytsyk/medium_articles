import UIKit
import PlaygroundSupport
PlaygroundPage.current.needsIndefiniteExecution = true

let serialQueue = DispatchQueue(label: "mySerialQueue")
let serialQueue2 = DispatchQueue(label: "mySerialQueue")

serialQueue.async {
    print("Blocking block starts")
    serialQueue2.sync {
        print("Unreachable statement") //already reachable
    }
    print("Unreachable statement")
}


