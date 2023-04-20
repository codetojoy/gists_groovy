
import java.time.*
import java.time.format.*
import java.time.temporal.*

// ------ main


def isOlderThan = { LocalDate date, int numMonths ->
    LocalDate nowDate = LocalDate.now()  
    def date2 = nowDate.minus(numMonths, ChronoUnit.MONTHS) 
    return date.isBefore(date2)
}

def getClosest = { String s ->
    LocalDate date = LocalDate.parse(s) 
    if (isOlderThan(date, 12)) {
        LocalDate nowDate = LocalDate.now()  
        return nowDate.minus(12, ChronoUnit.MONTHS)
    } else {
        return date
    }
}

println "TRACER cp 0 : " + getClosest("2022-02-05")
println "TRACER cp 1 : " + getClosest("2023-02-05")
println "TRACER cp 2 : " + getClosest("2022-11-18")
println "TRACER cp 3 : " + getClosest("2022-04-01")

println "Ready."
