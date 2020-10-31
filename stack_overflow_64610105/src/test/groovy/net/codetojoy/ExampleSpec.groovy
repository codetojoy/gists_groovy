
package net.codetojoy

import spock.lang.*

class ExampleSpec extends Specification {
    def f(x) { x }

    def 'behaviour test for simpleAdd'(int a, int b, int c) {
     expect:
      new Example().simpleAdd(a,b) == c

     where:
       a | b | c
       5100 | 50 | f(5150) 
       6160 | 0  | 6160
    }

    @Shared
    def example = new Example()

    def 'behaviour test for experiment'(def name, def route) {
     expect:
      'Hi' == route

     where:
       name | route
       'A' | example.doA() 
       'B' | example.doB() 
    }

    def 'behaviour tests for route A'() {
     when:
       def data = new Example().doA();

     then:
      data == 'Hi'
    }

    def 'behaviour tests for route B'() {
     when:
       def data = new Example().doB();

     then:
      data == 'Hi'
    }
}
