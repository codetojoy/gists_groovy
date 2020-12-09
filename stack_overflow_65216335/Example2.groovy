
@Grab('org.codehaus.groovy.modules.http-builder:http-builder:0.7.1')
@Grab('io.github.http-builder-ng:http-builder-ng-okhttp:1.0.4')

import groovy.json.*
import static groovyx.net.http.ContentType.JSON
import groovyx.net.http.OkHttpBuilder

// build JSON

def map = [:]
map["fromSoo"] = 'true'
map["attachments"] = []
map["signer"] = 'jfjf'
map["executor"] = 'kjdf'
map["isElectronicSign"] = 'true'
map["shortDescription"] = 'dskjh'
map["sheetsNumber"] = 3
map["note"] = 'dshsd'
map["reviewList"] = []
map["NodeRef"] = ''
map["apps"] = 5

def jsonBody = new JsonBuilder(map).toString()

// HTTP POST

def url = 'http://jsonplaceholder.typicode.com/posts'

def response = OkHttpBuilder.configure {
    request.uri = url
}.post {
    request.contentType = JSON
    request.body = jsonBody
}

println response
