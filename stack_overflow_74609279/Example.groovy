

def someInfo = new XmlSlurper().parse("book.xml") 

someInfo.Shops.shop.each { thisShop ->
    println "shop id: " + thisShop."@id"
    thisShop.ctr.each { thisCtr ->
        println "country: " + thisCtr.country + " code: " + thisCtr.text()
    }
}

println "Ready."
