// import com.sap.gateway.ip.core.customdev.util.Message
import groovy.xml.MarkupBuilder
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.text.DecimalFormat
import java.util.HashSet


def xmlStr = """
<DELVRY07>
    <IDOC BEGIN="1">
    <E1EDL20 SEGMENT="1">
         <E1EDL24 SEGMENT="1">
                <POSNR>000010</POSNR>
                <VGBEL>0010001035</VGBEL>
            </E1EDL24>
            <E1EDL24 SEGMENT="1">
                <POSNR>000020</POSNR>
                <VGBEL>0010001036</VGBEL>
            </E1EDL24>
            <E1EDL24 SEGMENT="1">
                <POSNR>900001</POSNR>
                <VGBEL>0010001035</VGBEL>
            </E1EDL24>
            <E1EDL24 SEGMENT="1">
                <POSNR>900002</POSNR>
                <VGBEL>0010001035</VGBEL>
            </E1EDL24>
            <E1EDL24 SEGMENT="1">
                <POSNR>900003</POSNR>
                <VGBEL>0010001036</VGBEL>
            </E1EDL24>
            <E1EDL24 SEGMENT="1">
                <POSNR>900004</POSNR>
                <VGBEL>0010001036</VGBEL>
            </E1EDL24>
            <E1EDL24 SEGMENT="1">
                <POSNR>900005</POSNR>               
                <VGBEL>0010001036</VGBEL>
            </E1EDL24>
        </E1EDL20>
      </IDOC>
</DELVRY07>
"""

class Message {
    def xmlStr
    def getBody() { return new StringReader(xmlStr) }
} 

def Message processData(Message message) {
    def reader = message.getBody()
    def DELVRY07 = new XmlSlurper().parse(reader)

    def mySet = DELVRY07.IDOC.E1EDL20.E1EDL24.VGBEL.inject(new HashSet(),{
        acc, node -> acc << node.text()
    })
    
    mySet.each { order ->
        println order
    }

    return message;
}

// ------------ main

def message = new Message()
message.xmlStr = xmlStr
processData(message)

