@Grab(group='io.rest-assured', module='rest-assured', version='4.3.1')

import static io.restassured.RestAssured.*

import io.restassured.http.*
import io.restassured.response.*

class Dummy {}

def endpoint = "http://localhost:3130/ids.json"
def jsonResponse = get(endpoint).then().contentType(ContentType.JSON).extract().response()
def path = jsonResponse.jsonPath()

def result = path.getString("find { it.name == 'John Smith' }.preferences.find {it.image == 'papaya.jpg'}.dependentPreferences.description")

println "TRACER result: " + result 
