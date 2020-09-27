try {
    def foo = args[0]
    def bar = args[1]
    new File("out.txt").withWriter { writer ->
        writer.write("TRACER foo : ${foo}\n")
        writer.write("TRACER bar : ${bar}\n")
    }
} catch (Exception ex) {
    new File("error.txt").withWriter { writer ->
        writer.write("TRACER caught exception ${ex.message}\n")
    }
}
