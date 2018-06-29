package com.venk.daily.groovy

/**
 * Groovy's Hello World
 */
class HelloGroovy {

    private id

    def getId() {
        return id
    }

    void setId(id) {
        this.id = id
    }

    static void main(String[] args) {
        println('halo')
        test()
    }

    static def test() {
        given:
        def id = 99999
        when:
        HelloGroovy helloGroovy = new HelloGroovy()
        helloGroovy.setId(id)
        id++
        then:
        println("groovy id is ${helloGroovy.getId()}")
        println("now id is ${id}")
    }

}
