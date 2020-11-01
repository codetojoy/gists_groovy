import groovy.json.*;

def data = new File('data.json').getText()

def json = new JsonSlurper().parseText( data )
def test2Array = json["test2"]

def output2 = [:]
def result = []
def statusMap = ["STATUS": result]
output2["OUTPUT"] = statusMap

test2Array.each { obj ->
    obj["status"].each { status ->
        def id = status.id
        status.pole.each { obj2 ->
            def color = obj2["Color"]
            result << [id: id, color: color]
        }  
    }
}

println new JsonBuilder(output2).toPrettyString()

println "Ready."

