/*
def binding = [:]
binding["foo"] = 5150
def shell = new GroovyShell(binding)
*/

def myArgs = ["6160", "5150"]
def shell = new GroovyShell()
def script = new File('TestScript.groovy')
shell.run(script, myArgs)
