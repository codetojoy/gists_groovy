
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

ObjectMapper mapper = new ObjectMapper();
ObjectNode rootNode = mapper.createObjectNode();

rootNode.put("my-string", "foobar");
rootNode.put("my-int", 5150);
rootNode.put("my-bool", true);

ArrayNode array = mapper.createArrayNode();
array.add(buildSimpleNode(mapper, "name", "mozart"));
array.add(buildSimpleNode(mapper, "name", "bach"));
array.add(buildSimpleNode(mapper, "name", "brahms"));
rootNode.put("my-array", array);

String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
System.out.println(jsonString);
