package calc;

import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;

/** 
 * Stateless class which constructs a mathematical logical tree 
 * from a list of tokens that represent a mathematical expression. 
 * <br/>
 * Methods may throw an {@link IllegalArgumentException} if any
 * syntax error is detected.
 */
class Parser {

    private static boolean hasIndex(int index, List<String> args) {
	return args.size() > index && args.get(index) != null;
    }

    static final char CHAR_OPEN = '(';
    static final char CHAR_CLOSE= ')';
    private static final String STRING_OPEN = String.valueOf(CHAR_OPEN);
    private static final String STRING_CLOSE= String.valueOf(CHAR_CLOSE);

    Equation parse(List<String> args) throws IllegalArgumentException {
	
	// Fist token is either 'OPEN' or a number
	int nextTokenIndex;
	Equation left;
	if (!hasIndex(0, args)) {
	    throw new IllegalArgumentException("First operand can not be null");
	} else if (args.get(0).equals(STRING_OPEN)) {
	    final List<String> subArgs = getScope(0, args);
	    nextTokenIndex = subArgs.size() + 2;
	    left = parse(subArgs); // Recursive call
	} else {
	    final BigDecimal value = getNumber(args.get(0));
	    left = new EquationLeaf(value);
	    nextTokenIndex = 1;
	}
	
	// Second token is optional but can only be an operator if any
	if (!hasIndex(nextTokenIndex, args)) {
	    return left;
	}
	BinaryOperator op = getBinaryOperator(args.get(nextTokenIndex).trim()); // is never null
	nextTokenIndex += 1;
	
	// Third token is mandatory since we have an operator
	Equation right;
	if (!hasIndex(nextTokenIndex, args)) {
	    throw new IllegalArgumentException("Second operand can not be null");
	} else if (args.get(nextTokenIndex).equals(STRING_OPEN)) {
	    final List<String> subArgs = getScope(nextTokenIndex, args);
	    right = parse(subArgs); // Recursive call
	} else {
	    final BigDecimal value = getNumber(args.get(nextTokenIndex));
	    right = new EquationLeaf(value);
	}
	
	return new EquationBranch(op, left, right);
    }
    
    private BinaryOperator getBinaryOperator(String str) throws IllegalArgumentException {
	if (str == null || str.length() != 1) {
	    throw new IllegalArgumentException("An operator is represented by one character, " + str + " is an invalid operator");
	}
	final char opChar = str.charAt(0);
	for (BinaryOperator op : BinaryOperator.values()) {
	    if (op.getSymbol() == opChar) {
		return op;
	    }
	}
	throw new IllegalArgumentException("Unknown or unsupported operator " + opChar);
    }

    /** Returns all tokens in a parenthesis scope. The first argument must be OPEN. */
    private List<String> getScope(int index, List<String> args) throws IllegalArgumentException {
	assert args.size() > index;
	assert args.get(index).equals(STRING_OPEN);
	if (args.size() < index + 2) {
	    throw new IllegalArgumentException("Expecting 3 or more arguments in a parenthesis scope");
	}

	final List<String> subArgs = new ArrayList<>(args.size() - index); // Can not be bigger
	int ococ = 1; // Open Character Occurrence Count
	for (int i = index+1; i < args.size(); i++) {
	    final String current = args.get(i);
	    
	    if (current.equals(STRING_OPEN)) { ococ += 1; } 
	    else if (current.equals(STRING_CLOSE)) { ococ -= 1; }

	    if (ococ == 0) { break; } // Found
	    else { subArgs.add(current); }
	}
	if (ococ > 0) { // We did not find the corresponding closing parenthesis
	    throw new IllegalArgumentException("Expecting closing parenthesis but reached the end");
	}
	
	return subArgs;
    }
    
    private BigDecimal getNumber(String token) throws IllegalArgumentException {
	assert token != null;
	try {
	    return new BigDecimal(token.trim());
	} catch (NumberFormatException e) {
	    throw new IllegalArgumentException(token + " is not a number");
	}
    }

}
