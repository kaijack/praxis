package calc;

import java.math.BigDecimal;

class EquationLeaf implements Equation {
    
    EquationLeaf(BigDecimal value) {
	this.value = value;
    }

    private final BigDecimal value;

    /** Computes the equation. Can return NULL if the input was not allowed. */
    public BigDecimal compute() { return value; }
    
    /** Gets the left part of the equation tree. */
    public Equation getLeft() { return null; }

    /** Gets the right part of the equation tree. */
    public Equation getRight() { return null; }
    
    /** Gets the operator to be used for this node of the tree. */
    public BinaryOperator getBinaryOperator() { return null;}

    public String toString() {
	return String.valueOf(value);
    }
}
