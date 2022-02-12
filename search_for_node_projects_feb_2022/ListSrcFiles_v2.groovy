
// e.g.
// given:
// ./section_1_basics/01-sandbox-project/src
// ./section_1_basics/01-sandbox-project/node_modules
// ./section_1_basics/01-sandbox-project/public
// ./section_2_advanced/01-foo-project/src
// ./section_2_advanced/01-foo-project/node_modules
// ./section_2_advanced/01-foo-project/public
// 
// just list files in the various `src` folders

def listFiles
listFiles = { File dir, int currentDepth, int targetDepth -> 
    if (currentDepth != targetDepth) {
        println "TRACER debug cp 1 ${dir} ${currentDepth} ${targetDepth}"
       dir.eachFile { file -> 
        if (!file.isDirectory()) { return }
        listFiles(file, currentDepth + 1, targetDepth) 
       } 
    } else {
        println "TRACER debug cp 2 ${dir} ${currentDepth} ${targetDepth}"
        if (!dir.isDirectory() || dir.name != 'src') { return }
        dir.eachFileRecurse { targetFile ->
            println "TRACER f: ${targetFile.absolutePath}"
        }
    }
}

// 0, .
// 1, ./section_1_basics
// 2, ./section_1_basics/01-sandbox-project 
// 3, ./section_1_basics/01-sandbox-project/src

def startDir = new File(".")
def startDepth = 0
def targetDepth = 3
listFiles(startDir, startDepth, targetDepth)

println "Ready."
