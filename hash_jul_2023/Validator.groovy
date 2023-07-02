
@Grapes(
    @Grab(group='com.google.guava', module='guava', version='32.1.1-jre')
)

import com.google.common.hash.Hashing

import java.nio.charset.StandardCharsets

// ----------- main

assert args.size() >= 2
def file = new File(args[0])
def hash = new File(args[1])

def fileText = file.getText()
def hashText = hash.getText()

def sha256hex = Hashing.sha256().hashString(fileText, StandardCharsets.UTF_8).toString()

println "TRACER: equal ? " + (hashText.equals(sha256hex)) 

println "Ready."
