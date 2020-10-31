
package net.codetojoy

import spock.lang.*

class ExampleSpec extends Specification {
    @Shared
    def example = new Example()

    @Unroll
    def 'behaviour test for #name #route'() {
     expect:
      'Hi' == route

     where:
       name | route
       'A' | example.doA() 
       'B' | example.doB() 
    }
}
