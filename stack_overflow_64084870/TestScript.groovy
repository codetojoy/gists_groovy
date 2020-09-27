// TestScript.groovy

try {
    new File("out.txt").withWriter { writer ->
        args.each { arg ->
            writer.write("TRACER arg : ${arg}\n")
        }
    }
} catch (Exception ex) {
    new File("error.txt").withWriter { writer ->
        writer.write("TRACER caught exception ${ex.message}\n")
    }
}
