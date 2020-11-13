import groovy.json.JsonSlurper
// import ru.itrpro.xm.plugins.groovy.ResultSetReader;

class ResultSetReader {
}

class XM_PARSE_XLS {

    def execute(ResultSetReader reader, String pfile) {
        def jsonSlurper = new JsonSlurper()
        def list = jsonSlurper.parseText pfile

        List names = list.inject( new LinkedHashSet<>() ){ res, map ->
            res.addAll map.keySet()
            res
        }.toList()
    
        def typeMap = [:].withDefault { key -> "String" }
        list.each { map ->
            map.each { key, value ->
                if (value) {
                    typeMap[key] = value.getClass().simpleName
                }
            }
        }
        def types = names.collect { name -> typeMap[name] }
        types.each { println "TRACER type: ${it}" } 
        
        // TODO: re-enable this for actual example with ResultSetReader
        /*
        //formation of the dataset header
        reader.outputLinesSetHeaders(names,types);

        list.each{ e ->
            reader.outputLines names.collect{ e[ it ] }
            //println names.collect{ e[ it ] }
        }

        //closing dataset
        reader.outputLinesEnd();
        return null;
        */
    }
}

// static void main(String... args) {

String pfile =  """
[{"AUTO":"bmw",
  "HOME":null,
  "JOB":""},
  
  {"AUTO":"audi",
  "HOME":135,
  "JOB":null},
  
  {"AUTO":"opel1",
  "HOME":10,
  "JOB":null}]
"""

String pfile2 =  """
[{"AUTO":null,
  "HOME":null,
  "JOB":""},
  
  {"AUTO":null,
  "HOME":135,
  "JOB":null},
  
  {"AUTO":null,
  "HOME":10,
  "JOB":null}]
"""

def SSC = new XM_PARSE_XLS()
def res = SSC.execute(new ResultSetReader(), pfile)

println "Ready."
