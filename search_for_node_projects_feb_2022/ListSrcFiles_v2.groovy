
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

def listFiles = { dir, currentDepth, targetDepth -> 
    if (currentDepth != targetDepth) {
       dir.eachFile { file -> 
        if (!file.isDirectory()) { return }
        listFiles(file, currentDepth + 1, targetDepth) 
       } 
    } else {
        dir.eachFileRecurse { file ->
            if (!file.isDirectory() || file.name != 'src') { return }
            file.eachFileRecurse { file ->
                println "TRACER f: ${file.absolutePath}"
            }
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
