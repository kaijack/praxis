package calc;

import java.util.List;
import java.math.BigDecimal;

/**
 * Static main class of calculator.
 * 
 * @author fabrice
 */
public class Calculator {
    
    private Calculator() {} // No need of any instance

    private static final String HELP_MSG = "Evaluates a mathematical expression with binary operators and parenthesis.\n"+
	"The first argument must be a number or a scope, then an operator and finally a number or a scope.\n"+
	"A scope has the same content between parenthesis characters.\n"+
	"Special arguments are :\n" +
	"\t-h : Print this help message\n" + 
	"Known operator characters are : \n";

    /* Return codes of the program */
    private static final int RETURN_BAD_INPUT = 1;
    private static final int RETURN_OK = 0;
    private static final int RETURN_INTERNAL_ERROR = 2;

    private static void printHelp() {
	final StringBuilder str = new StringBuilder(HELP_MSG);
	for (BinaryOperator op : BinaryOperator.values()) {
	    str.append("\t")
		.append(op.getSymbol())
		.append(" : ")
		.append(op.getDescription())
		.append("\n");
	}
	print(str.toString());
    }

    public static void main(String... args) {
	if (args.length == 0) {
	    print("No input");
	    printHelp();
	    System.exit(RETURN_BAD_INPUT);

	} else if (args[0].equals("-h")) {
	    printHelp();
	    System.exit(RETURN_OK);

	} else {
	    try {
		final BigDecimal result = run(args);
		print("Result = " + result);
		System.exit(RETURN_OK);

	    } catch (IllegalArgumentException e) {
		print("Syntax error : " + e.getMessage());
		printHelp();
		System.exit(RETURN_BAD_INPUT);

	    } catch (ArithmeticException e) {
		print("Computation error (precision loss) : " + e.getMessage());
		System.exit(RETURN_BAD_INPUT);

	    } catch (Exception e) {
		print("Internal error : " + e.getMessage());
		e.printStackTrace();
		System.exit(RETURN_INTERNAL_ERROR);	

	    }
	}
    }
    
    static void print(String msg) {
	System.out.println(msg);	
    }
    
    /** Used for testing. */
    static BigDecimal run(String... args) throws IllegalArgumentException, ArithmeticException {
	final List<String> tokens = new Tokenizer()
	    .tokenize(args)
	    .getTokens();
	print("Tokens = " + tokens);
	final Equation eq = new Parser()
	    .parse(tokens);
	print("Equation = " + eq);
	return eq.compute();
    }
}
