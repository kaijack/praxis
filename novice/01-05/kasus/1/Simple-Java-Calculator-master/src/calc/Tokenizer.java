package calc;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import static calc.Parser.CHAR_OPEN;
import static calc.Parser.CHAR_CLOSE;

/** 
 * Statefull class that creates tokens from a mathematical expression. 
 */
class Tokenizer {
    
    /** All operators' symbols */
    private static Set<Character> opsSet = null;
    static {
	final BinaryOperator[] allOps = BinaryOperator.values();
	opsSet = new HashSet<>(allOps.length);
	for (BinaryOperator op : allOps) {
	    opsSet.add(op.getSymbol());
	}
    }

    /** Characters that represent a decimal number. */
    private StringBuilder number = null;
    /** List of tokens */
    private List<String> tokens = null;
    
    private void append(char c) {
	if (number == null) {
	    number = new StringBuilder();
	}
	number.append(c);
    }    

    private void poll() {
	if (number != null) {
	    tokens.add(number.toString());
	    number = null;
	}
    }

    private void add(char c) {
	tokens.add(String.valueOf(c));
    }

    Tokenizer tokenize(String... args) {
	// Reset
	number = null;
	tokens = new ArrayList<>(); // Do not know the size

	for (String arg : args) {
	    final char[] chars = arg.toCharArray();
	    for (char c : chars) {
		char current = c;
		switch (c) {
		case '_':
		case ' ':
		    break; // Ignore
		case ',':
		    current = '.'; // Replaces the ',' by '.'
		case '.':
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
		    // Part of a number
		    append(current);
		    break;
		case CHAR_OPEN:
		case CHAR_CLOSE:
		    // Scope delimiter
		    poll();
		    add(c);
		    break;
		default:
		    if (opsSet.contains(c)) {
			// Operator symbol
			poll();
			add(c);
		    } else {
			// Not allowed character
			throw new IllegalArgumentException("Unexpected character " + String.valueOf(c));
		    }
		}
	    }
	}
	poll();
	return this;
    }

    List<String> getTokens() {
	return tokens;
    }
}
