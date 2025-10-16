#!/usr/bin/env groovy

@Grapes([
    @Grab(group='org.apache.httpcomponents.client5', module='httpclient5', version='5.3.1'),
    @Grab(group='org.apache.httpcomponents.core5', module='httpcore5', version='5.2.4')
])

import org.apache.hc.client5.http.classic.methods.HttpGet
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient
import org.apache.hc.client5.http.impl.classic.HttpClients
import org.apache.hc.core5.http.io.entity.StringEntity
import org.apache.hc.core5.http.io.entity.EntityUtils
import org.apache.hc.core5.http.ContentType

// Create HTTP client
CloseableHttpClient httpClient = HttpClients.createDefault()

try {
    // Create GET request
    String url = "https://httpbin.org/get"
    HttpGet httpGet = new HttpGet(url)

    // Add JSON body to GET request
    def jsonBody = [
        name: "John Doe",
        email: "john.doe@example.com",
        message: "This is a GET request with a body"
    ]

    String jsonString = groovy.json.JsonOutput.toJson(jsonBody)
    StringEntity entity = new StringEntity(jsonString, ContentType.APPLICATION_JSON)
    httpGet.setEntity(entity)

    // Set headers
    httpGet.setHeader("Content-Type", "application/json")
    httpGet.setHeader("Accept", "application/json")

    println "Sending GET request to: ${url}"
    println "Request body: ${jsonString}"
    println ""

    // Execute request
    httpClient.execute(httpGet) { response ->
        println "Response Status: ${response.getCode()} ${response.getReasonPhrase()}"
        println ""

        def responseBody = EntityUtils.toString(response.getEntity())
        println "Response Body:"
        println responseBody
    }

} catch (Exception e) {
    println "Error occurred: ${e.message}"
    e.printStackTrace()
} finally {
    httpClient.close()
}
