
def input="""
  \${Ordinal.ACE}   | \${Suit.CLUBS}    | \${0}
  \${Ordinal.TWO}   | \${Suit.CLUBS}    | \${1}
  \${Ordinal.THREE} | \${Suit.CLUBS}    | \${2}
  \${Ordinal.FOUR}  | \${Suit.CLUBS}    | \${3}
  \${Ordinal.FIVE}  | \${Suit.CLUBS}    | \${4}
  \${Ordinal.SIX}   | \${Suit.CLUBS}    | \${5}
  \${Ordinal.SEVEN} | \${Suit.CLUBS}    | \${6}
  \${Ordinal.EIGHT} | \${Suit.CLUBS}    | \${7}
  \${Ordinal.NINE}  | \${Suit.CLUBS}    | \${8}
  \${Ordinal.TEN}   | \${Suit.CLUBS}    | \${9}
  \${Ordinal.JACK}  | \${Suit.CLUBS}    | \${10}
  \${Ordinal.QUEEN} | \${Suit.CLUBS}    | \${11}
  \${Ordinal.KING}  | \${Suit.CLUBS}    | \${12}
  \${Ordinal.ACE}   | \${Suit.DIAMONDS} | \${0 + 1 * 13}
  \${Ordinal.TWO}   | \${Suit.DIAMONDS} | \${1 + 1 * 13}
  \${Ordinal.THREE} | \${Suit.DIAMONDS} | \${2 + 1 * 13}
  \${Ordinal.FOUR}  | \${Suit.DIAMONDS} | \${3 + 1 * 13}
  \${Ordinal.FIVE}  | \${Suit.DIAMONDS} | \${4 + 1 * 13}
  \${Ordinal.SIX}   | \${Suit.DIAMONDS} | \${5 + 1 * 13}
  \${Ordinal.SEVEN} | \${Suit.DIAMONDS} | \${6 + 1 * 13}
  \${Ordinal.EIGHT} | \${Suit.DIAMONDS} | \${7 + 1 * 13}
  \${Ordinal.NINE}  | \${Suit.DIAMONDS} | \${8 + 1 * 13}
  \${Ordinal.TEN}   | \${Suit.DIAMONDS} | \${9 + 1 * 13}
  \${Ordinal.JACK}  | \${Suit.DIAMONDS} | \${10 + 1 * 13}
  \${Ordinal.QUEEN} | \${Suit.DIAMONDS} | \${11 + 1 * 13}
  \${Ordinal.KING}  | \${Suit.DIAMONDS} | \${12 + 1 * 13}
  \${Ordinal.ACE}   | \${Suit.HEARTS}   | \${0 + 2 * 13}
  \${Ordinal.TWO}   | \${Suit.HEARTS}   | \${1 + 2 * 13}
  \${Ordinal.THREE} | \${Suit.HEARTS}   | \${2 + 2 * 13}
  \${Ordinal.FOUR}  | \${Suit.HEARTS}   | \${3 + 2 * 13}
  \${Ordinal.FIVE}  | \${Suit.HEARTS}   | \${4 + 2 * 13}
  \${Ordinal.SIX}   | \${Suit.HEARTS}   | \${5 + 2 * 13}
  \${Ordinal.SEVEN} | \${Suit.HEARTS}   | \${6 + 2 * 13}
  \${Ordinal.EIGHT} | \${Suit.HEARTS}   | \${7 + 2 * 13}
  \${Ordinal.NINE}  | \${Suit.HEARTS}   | \${8 + 2 * 13}
  \${Ordinal.TEN}   | \${Suit.HEARTS}   | \${9 + 2 * 13}
  \${Ordinal.JACK}  | \${Suit.HEARTS}   | \${10 + 2 * 13}
  \${Ordinal.QUEEN} | \${Suit.HEARTS}   | \${11 + 2 * 13}
  \${Ordinal.KING}  | \${Suit.HEARTS}   | \${12 + 2 * 13}
  \${Ordinal.ACE}   | \${Suit.SPADES}   | \${0 + 3 * 13}
  \${Ordinal.TWO}   | \${Suit.SPADES}   | \${1 + 3 * 13}
  \${Ordinal.THREE} | \${Suit.SPADES}   | \${2 + 3 * 13}
  \${Ordinal.FOUR}  | \${Suit.SPADES}   | \${3 + 3 * 13}
  \${Ordinal.FIVE}  | \${Suit.SPADES}   | \${4 + 3 * 13}
  \${Ordinal.SIX}   | \${Suit.SPADES}   | \${5 + 3 * 13}
  \${Ordinal.SEVEN} | \${Suit.SPADES}   | \${6 + 3 * 13}
  \${Ordinal.EIGHT} | \${Suit.SPADES}   | \${7 + 3 * 13}
  \${Ordinal.NINE}  | \${Suit.SPADES}   | \${8 + 3 * 13}
  \${Ordinal.TEN}   | \${Suit.SPADES}   | \${9 + 3 * 13}
  \${Ordinal.JACK}  | \${Suit.SPADES}   | \${10 + 3 * 13}
  \${Ordinal.QUEEN} | \${Suit.SPADES}   | \${11 + 3 * 13}
  \${Ordinal.KING}  | \${Suit.SPADES}   | \${12 + 3 * 13}
"""

// ------------- main

// const getCardIdTestCases = [{ ord: Ordinal.ACE, suit: Suit.CLUBS, expected: 0 }];

def strip = { s ->
    def regex = /.*\$\{(.*)\}.*/
    def matcher = s =~ regex
    assert matcher.matches()
    def result = matcher[0][1]
    return result
}

def convert = { s ->
    def trimLine = s.trim()
    if (! trimLine.isEmpty()) {
        def tokens =  trimLine.split(/\|/)
        def ord = strip(tokens[0])
        def suit = strip(tokens[1])
        def expected = strip(tokens[2])
        println "{ ord: ${ord}, suit: ${suit}, expected: ${expected} },"
    }
}

input.eachLine { convert(it) }

