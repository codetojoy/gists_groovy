
// jar stored in ./lib just in case it disappears

@Grab(group='net.lingala.zip4j', module='zip4j', version='2.9.1')

class DummyForGrab {} 

import net.lingala.zip4j.*
import net.lingala.zip4j.model.*
import net.lingala.zip4j.model.enums.*

// https://github.com/srikanth-lingala/zip4j
// https://stackoverflow.com/a/37036899/12704

def createZip = { params ->
    def zipParameters = new ZipParameters()
    zipParameters.setEncryptFiles(true)
    // AES 256 is used by default
    zipParameters.setEncryptionMethod(EncryptionMethod.AES)

    def filesToAdd = []
    def dir = new File(params.targetDir)
    dir.eachFile { file ->
        if (file.isFile()) {
            filesToAdd << file
        } else {
            println "TRACER skipping folder: " + fileName
        }
    }

    def zipFile = new ZipFile(params.zipFile, params.password.toCharArray())
    zipFile.addFiles(filesToAdd, zipParameters)
}

def openZip = { params ->
    def zipFile = new ZipFile(params.zipFile, params.password.toCharArray())
    zipFile.extractAll(params.targetDir)
}

class Params {
    def mode
    def targetDir
    def zipFile
    def password
}

def usage = { message ->
    println "ERROR: " + message
    println "groovy Runner.groovy [create|open] targetDir zipFile"
    System.exit(-1)
}

final def MODE_CREATE = 'create'
final def MODE_OPEN = 'open'
final def ZIP_PASSWORD = 'ZIP_PASSWORD'

def getParams = { args ->
    // check args
    if (args.length < 3) {
        usage("illegal # of args")
    }
    def mode = args[0]
    def targetDir = args[1]
    def zipFile = args[2]

    // check mode
    if (mode != MODE_CREATE && mode != MODE_OPEN) {
        usage("illegal mode")
    }

    // check files/dirs
    if (mode == MODE_CREATE) {
        def dir = new File(targetDir)
        if ((!dir.exists()) || (!dir.isDirectory())) {
            usage("cannot use ${targetDir} in this mode")
        }
    } else {
        def file = new File(zipFile)
        if ((!file.exists()) || (!file.isFile())) {
            usage("cannot use ${zipFile} in this mode")
        }
    }

    // check password
    def password = System.getenv(ZIP_PASSWORD)
    
    if (password == null || password.trim().isEmpty() || password.length() < 5) { 
        usage("could not find/use $ZIP_PASSWORD env var")
    }

    def params = new Params()
    params.mode = mode
    params.targetDir = args[1]
    params.zipFile = args[2]
    params.password = password

    return params
}

// ----------- main

def params = getParams(args)
if (params.mode == MODE_CREATE) {
    createZip(params)
} else if (params.mode == MODE_OPEN) {
    openZip(params)
}

println "Ready."
