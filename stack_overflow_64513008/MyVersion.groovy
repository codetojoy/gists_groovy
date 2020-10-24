
final int CHUNK_SIZE = 5000
// set this to be the 'Id' field index: 
final int ID_INDEX = 0

def lists = []
def currentList = [] 
def i = 1
def isHeader = true

// Build a list of lists:
// [ [1,2,3,4,5,...,5000] , [5001,5002,...] , ... ]

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

// Build a string by iterating over each list.
// At the end of each chunk, write a newline.

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
