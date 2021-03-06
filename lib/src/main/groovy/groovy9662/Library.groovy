package groovy9662

class Library {

    String invokeClosure(@DelegatesTo(value = MyCustomDelegate) Closure c) {
        c.resolveStrategy = Closure.DELEGATE_FIRST
        c.delegate = new MyCustomDelegate()
        c()
    }

    String doSomeWork() {
        invokeClosure {
            // this will be dispatched to the delegate
            // as expected because of the code above
            // inside of the invokeClosure method
            // which is setting the strategy to DELEGATE_FIRST
            getMessage()
        }
    }

    String getMessage() {
        'Message From Closure Owner (Library)'
    }

}
