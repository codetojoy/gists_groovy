
def body = """
<ROOT>
 <JDE>
   <ID>1</ID>
   <ORDERS>
     <ORDER>123</ORDER>
   </ORDERS>
 </JDE>
 <JDE>
   <ID>1</ID>
   <ORDERS>   
     <ORDER>234</ORDER>
   </ORDERS>
 </JDE>
 <JDE>
   <ID>2</ID>
   <ORDERS>   
     <ORDER>345</ORDER>
   </ORDERS>
 </JDE>
</ROOT>
"""

def xmlParser = new XmlParser()
def root = xmlParser.parseText(body)
def map = [:].withDefault{ key -> [] }

root.JDE.each { jde ->
    def id = jde.ID.text()
    jde.ORDERS.each { order ->
        map[id] << order.text()
    }
}

def writer = new StringWriter()
new groovy.xml.MarkupBuilder(writer).ROOT {
    map.each { id, orderIds ->
        JDE() {
            ID(id)
            ORDERS() {
                orderIds.each { orderId ->
                    ORDER(orderId)
                }
            }
        }
    }
}

println writer.toString()
