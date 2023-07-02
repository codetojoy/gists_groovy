
@Grapes(
    @Grab(group='com.google.guava', module='guava', version='32.1.1-jre')
)

import com.google.common.hash.Hashing

import java.nio.charset.StandardCharsets

// ----------- main

assert args.size() >= 1
def file = new File(args[0])
def text = file.getText()

def sha256hex = Hashing.sha256().hashString(text, StandardCharsets.UTF_8).toString()

def outFile = "hash.txt"

new File(outFile).withWriter { writer ->
    writer.write(sha256hex)
}

println "Ready."
