
import java.time.*
import java.time.format.*
import java.time.temporal.*

class ArrayInfo {
    LocalDateTime dateTime
    int value

    String toString() {
        return "dateTime: ${dateTime}, value: ${value}"
    }
}

def buildDateTime = { s -> 
    return LocalDateTime.parse(s)
}

def buildLocalArray = {
    def results = []

    24.times { h -> 
        def hh = h
        if (h < 10) {
            hh = "0" + h
        }
        def dateTime = buildDateTime("2024-09-01T${hh}:00:00")
        results << new ArrayInfo(dateTime: dateTime, value: h)
    } 

    return results
}

def convertToUtc = { def info ->
    def utcDateTime = info.dateTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneOffset.UTC).toLocalDateTime();
    return new ArrayInfo(dateTime: utcDateTime, value: info.value);
}

// ------ main

def localArray = buildLocalArray()

println "TRACER local"
localArray.each { println it }

println ""
println "TRACER UTC"
def utcArray = localArray.collect(info -> convertToUtc(info)) 

utcArray.each { println it }

println ""

println "Ready."
