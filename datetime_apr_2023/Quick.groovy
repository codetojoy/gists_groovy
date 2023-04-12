
import java.time.*
import java.time.format.*
import java.time.temporal.*

// ------ main

def f1 = DateTimeFormatter.ofPattern("yyyyMMddHHmmss")
def timeStr = "20230412191234"
def dateTime = f1.parse(timeStr)
println dateTime.toString()

def f2 = DateTimeFormatter.ISO_LOCAL_DATE_TIME.withZone(ZoneId.from(ZoneOffset.UTC))
def now = Instant.now()
ZonedDateTime zonedDateTime = now.atZone(ZoneId.from(ZoneOffset.UTC))
def timeStr2 = f1.format(zonedDateTime)
println "TRACER timeStr2: " + timeStr2
/*
println "TRACER yyyy: " + zonedDateTime.get(ChronoField.YEAR)
println "TRACER mm: " + zonedDateTime.get(ChronoField.MONTH_OF_YEAR)
def nowStr = f2.format(now)
def dateTime2 = f2.format(nowStr)
println "TRACER datetime2: " + dateTime2.toString()
*/

