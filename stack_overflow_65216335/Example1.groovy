
@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.7.1' )

import groovy.json.*

import groovyx.net.http.RESTClient
import static groovyx.net.http.ContentType.JSON

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

// build HTTP POST

def url = 'http://jsonplaceholder.typicode.com/posts'
def client = new RESTClient(url)
def resp = client.post(body : jsonBody, contentType: JSON)
println resp.data 

