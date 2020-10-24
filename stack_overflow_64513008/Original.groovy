
def lines = new File('data.csv').readLines()
def keys = lines[0].split(',')
def rows = [:].withDefault { key -> [] }

lines[1..-1].each { line ->
    def vals = line.split(',')
    def i = 0 
    vals.each { val ->
        def key = keys[i]
        rows[key] << val
        i++
    }
}
      
def chunkSize = 5000 
def builder = new StringBuilder() 
def i = 1

rows["Id"].each { id ->
    builder.append("'${id}',") 

    if (i % chunkSize == 0) {
        builder.append("\n")
    }    

    i++
}

println builder.toString()

