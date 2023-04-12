
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
def nowStr = f2.format(now)
println nowStr
