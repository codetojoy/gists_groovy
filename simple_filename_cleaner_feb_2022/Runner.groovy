
import java.nio.file.*

class Info {
    def originalFileName
    def newFileName
}

def getPath = { dir, filename ->
    return "${dir}${File.separator}${filename}"
}

def backupFiles = { params ->
    def dir = new File(params.targetDir)
    dir.eachFile { file ->
        def filename = file.name
        def newFilename = getPath(params.backupDir, filename)
        def newFile = new File(newFilename)
        Files.copy(file.toPath(), newFile.toPath())
    }
}

def moveFiles = { params, infos ->
    infos.each { info -> 
        def file = new File(getPath(params.targetDir, info.originalFileName))
        def newFile = new File(getPath(params.targetDir, info.newFileName))
        Files.move(file.toPath(), newFile.toPath())
    }
}

def getFileNames = { targetDir ->
    def results = []
    def dir = new File(targetDir)
    dir.eachFile(groovy.io.FileType.FILES) { file ->
        results << file.name
    }
    return results
}

def getNewFileName = { fileName ->
    def newFileName = fileName.replaceAll(" ", "_")
                              .replaceAll(/\(/, "_")
                              .replaceAll(/\)/, "_")
    return new Info(originalFileName: fileName, newFileName: newFileName)
}

def getNewFileNames = { fileNames ->
    return fileNames.collect { getNewFileName(it) } 
}

def checkForDupes = { list1, list2 -> 
    def set1 = new HashSet(list1)
    def set2 = new HashSet(list2)
    return set1.size() == set2.size()
}

assert checkForDupes(['a ', 'b ', 'c '], ['a_', 'b_', 'c_'])
assert !checkForDupes(['a ', 'a(', 'c '], ['a_', 'a_', 'c_'])

def clean = { params ->
    def fileNames = getFileNames(params.targetDir)
    def infos = getNewFileNames(fileNames)
    def ok = checkForDupes(infos.collect{ it.originalFileName}, infos.collect{ it.newFileName})

    if (ok) {
        backupFiles(params)
        moveFiles(params, infos)
    } else {
        println "ERROR: some files map to the same value! terminating..."
    }
}

class Params {
    def targetDir
    def backupDir
}

def usage = { message ->
    println "ERROR: " + message
    println "groovy Runner.groovy targetDir backupDir"
    System.exit(-1)
}

def getParams = { args ->
    // check args
    if (args.length < 2) {
        usage("illegal # of args")
    }
    def targetDir = args[0]
    def backupDir = args[1]

    def dir
    dir = new File(targetDir)
    if ((!dir.exists()) || (!dir.isDirectory())) {
        usage("cannot use dir: ${targetDir} ")
    }

    dir = new File(backupDir)
    if ((!dir.exists()) || (!dir.isDirectory())) {
        usage("cannot use dir: ${backupDir} ")
    }

    return new Params(targetDir: targetDir, backupDir: backupDir)
}

// ----------- main

def params = getParams(args)
clean(params)

println "Ready."
