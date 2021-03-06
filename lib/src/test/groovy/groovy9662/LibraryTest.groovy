package groovy9662

import spock.lang.Specification

class LibraryTest extends Specification {

    // this test passes
    def "test dynamically dispatched library"() {
        expect:
        new Library().doSomeWork() == 'Message From Closure Delegate'
    }

    // this test fails
    def "test statically  dispatched library"() {
        expect:
        new LibraryCompileStatic().doSomeWork() == 'Message From Closure Delegate'
    }
}
