
def COMMA = ','
def UNDERSCORE = '_'
def DASH = '-' 
def SPACE = ' '
def EMPTY = ''
def OPEN_PAREN = "("
def CLOSE_PAREN = ")"

// ----------- main 

def orig = args[0] 
def normal = orig.replace(COMMA, UNDERSCORE)
                 .replace(SPACE, EMPTY)
                 .replace(DASH, UNDERSCORE)
                 .replace(OPEN_PAREN, UNDERSCORE)
                 .replace(CLOSE_PAREN, UNDERSCORE)

println normal
