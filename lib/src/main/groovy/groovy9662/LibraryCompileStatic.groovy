package groovy9662

import groovy.transform.CompileStatic

@CompileStatic
class LibraryCompileStatic {

    String invokeClosure(@DelegatesTo(value = MyCustomDelegate) Closure c) {
        // this resolve strategy does not have an affect
        // because the closure has been statically
        // compiled to delegate to the owner, possibly
        // because that is the default value of the strategy
        // attribute in @DelegatesTo.
        c.resolveStrategy = Closure.DELEGATE_FIRST
        c.delegate = new MyCustomDelegate()
        c()
    }

    String doSomeWork() {
        invokeClosure {
            // this will be dispatched to the owner even
            // thou the invokeClosure method is setting
            // strategy to DELEGATE_FIRST.
            getMessage()
        }
    }

    String getMessage() {
        'Message From Closure Owner (Library)'
    }
}
