
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

// println "TRACER local"
// localArray.each { println it }

def sortedUtcArray = localArray.sort { infoA, infoB ->
    def utcDateTimeA = infoA.dateTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneOffset.UTC).toLocalDateTime();
    def utcDateTimeB = infoB.dateTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneOffset.UTC).toLocalDateTime();
    def hourA = utcDateTimeA.getHour()
    def hourB = utcDateTimeB.getHour()
    return hourA <=> hourB
}

println "TRACER sorted "
sortedUtcArray.each { println it }

println "Ready."
