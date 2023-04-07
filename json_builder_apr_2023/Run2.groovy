
@Grapes([
@Grab(group='com.fasterxml.jackson.core', module='jackson-core', version='2.14.2'),
@Grab(group='com.fasterxml.jackson.core', module='jackson-databind', version='2.14.2')
])

import com.fasterxml.jackson.databind.*; 
import com.fasterxml.jackson.databind.node.*;

// from https://stackoverflow.com/questions/40967921/create-json-object-using-jackson-in-java

ObjectNode buildSimpleNode(ObjectMapper mapper, String key, String value) {
    ObjectNode node = mapper.createObjectNode();
    node.put(key, value);
    return node;
}

String buildJson(String s, Integer i, Boolean b, List<String> names) {
    ObjectMapper mapper = new ObjectMapper();
    ObjectNode rootNode = mapper.createObjectNode();

    if (s != null) {
        rootNode.put("my-string", s);
    }

    if (i != null) {
        rootNode.put("my-int", i);
    }

    if (b != null) {
        rootNode.put("my-bool", b.booleanValue());
    }

    if (names != null) {
        ArrayNode array = mapper.createArrayNode();
        for (String name : names) {
            array.add(buildSimpleNode(mapper, "name", name));
        }
        rootNode.put("my-array", array);
    }

    String result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
    return result
}

// ----------- main

def result = buildJson("evh", 5150, null, ["mozart", "bach", "chopin"])
System.out.println(result);
