package calc;

import java.math.BigDecimal;

/**
 * Represents an equation that can be computed.
 * Makes possible to handle scopes with parenthesis in the syntax when we handle a tree of Equation instances.
 */
interface Equation {
    
    /** Computes the equation. Can return NULL if the input was not allowed. */
    BigDecimal compute();
    
    /** Gets the left part of the equation tree. */
    Equation getLeft();

    /** Gets the right part of the equation tree. */
    Equation getRight();
    
    /** Gets the operator to be used for this node of the tree. */
    BinaryOperator getBinaryOperator();
}
