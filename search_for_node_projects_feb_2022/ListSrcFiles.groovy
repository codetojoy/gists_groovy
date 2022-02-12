
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

new File(".").eachFile { fileLevel1 -> 
    if (!fileLevel1.isDirectory()) { return } 
    fileLevel1.eachFile { fileLevel2 ->
        if (!fileLevel2.isDirectory()) { return } 
        fileLevel2.eachFile { fileLevel3 ->
            if (!fileLevel3.isDirectory() || fileLevel3.name != 'src') { return }
            fileLevel3.eachFileRecurse { file ->
                println "TRACER f: ${file.absolutePath}"
            }
        }
    }
}

println "Ready."
