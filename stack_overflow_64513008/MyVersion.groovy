
def lists = []
def currentList = [] 
def i = 1
final int CHUNK_SIZE = 5000
final int ID_INDEX = 0
def isHeader = true

new File('data.csv').eachLine { line ->
    if (! isHeader) {
        def tokens = line.split(',')
        def id = tokens[ID_INDEX]
        currentList << id

        if (i % CHUNK_SIZE == 0) {
            lists << currentList
            currentList = [] 
        }         

        i++
    } else {
        isHeader = false
    }
}

def builder = new StringBuilder()

lists.each { list ->
    def count = 1
    list.each { id -> 
        builder.append("'${id}',")

        if (count % CHUNK_SIZE == 0) {
            builder.append("\n")
        }

        count++
    }
}

println builder.toString()
