
def COMMA = ','
def UNDERSCORE = '_'
def DASH = '-' 
def SPACE = ' '
def EMPTY = ''

// ----------- main 

def orig = args[0] 
def normal = orig.replace(COMMA, UNDERSCORE)
                 .replace(SPACE, EMPTY)
                 .replace(DASH, UNDERSCORE)

println normal
