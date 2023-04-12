
import java.time.*
import java.time.format.*

// ------ main

def formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss")
def timeStr = "20230412191234"
def dateTime = formatter.parse(timeStr)
println dateTime.toString()


