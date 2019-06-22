package calc;

import java.math.BigDecimal;

/**
 * An equation that has children equations. 
 */
class EquationBranch implements Equation {
    
    EquationBranch(BinaryOperator op, Equation left, Equation right) {
	this.op = op;
	this.left = left;
	this.right = right;
    }

    private final Equation left;
    private final Equation right;
    private final BinaryOperator op;

    /** Computes the equation. Can return NULL if the input was not allowed. */
    public BigDecimal compute() {
	final BigDecimal leftResult = left.compute();
	if (leftResult == null) {
	    return null;
	}
	final BigDecimal rightResult = right.compute();
	if (rightResult == null) {
	    return null;
	}
	final BigDecimal r = op.compute(leftResult, rightResult);
	if (r == null) {
	    Calculator.print("Unable to compute " + leftResult + " " + op + " " + rightResult);
	} else {
	    Calculator.print(this + " = " + r);
	}
	return r;
    }
    
    /** Gets the left part of the equation tree. */
    public Equation getLeft() { return left; }

    /** Gets the right part of the equation tree. */
    public Equation getRight() { return right; }
    
    /** Gets the operator to be used for this node of the tree. */
    public BinaryOperator getBinaryOperator() { return op; }
    
    public String toString() {
	return "(" + left + " " + op + " " + right + ")";
    }
}
