package calc;

import java.math.BigDecimal;
import java.math.MathContext;


/** 
 * Binary (two parameters) mathematical operator. 
 */
enum BinaryOperator {
    
    ADD('+', "Addition") {
	BigDecimal compute(BigDecimal l, BigDecimal r) {
	    return l.add(r);
	}
    },
    MINUS('-', "Subtraction") {
	BigDecimal compute(BigDecimal l, BigDecimal r) {
	    return l.subtract(r);
	}
    },
    MULTIPLY('*', "Multiplication") {
	BigDecimal compute(BigDecimal l, BigDecimal r) {
	    return l.multiply(r);
	}
    },
    DIVIDE('/', "Division") {
	BigDecimal compute(BigDecimal l, BigDecimal r) {
	    return isZero(r) ? null : l.divide(r);
	}
    },
    INT_DIVIDE('\\', "Integer division") {
	BigDecimal compute(BigDecimal l, BigDecimal r) {
	    return isZero(r) ? null : l.divideToIntegralValue(r);
	}	
    },
    REMAINDER('%', "Remainder of division") {
	BigDecimal compute(BigDecimal l, BigDecimal r) {
	    return isZero(r) ? null : l.remainder(r, MathContext.DECIMAL64);
	}
    },
    POWER('^', "Power") {
	BigDecimal compute(BigDecimal l, BigDecimal r) {
	    if (l.scale() > 1) { // Is decimal
		if (r.scale() > 1) {
		    if (r.compareTo(HALF) == 0) {
			return new BigDecimal(Math.sqrt(l.doubleValue()));
		    } else {
			throw new ArithmeticException("The power by an decimal operand is not supported");
		    }
		} else {
		    return l.pow(r.intValueExact()); // The power can not be decimal
		}
	    } else {
		return new BigDecimal(Math.pow(l.doubleValue(), r.doubleValue()));
	    }
	}
    },
    POWER_INVERSED('µ', "Inverse power : Square root of 'l' is <l µ 2>") {
	BigDecimal compute(BigDecimal l, BigDecimal r) {
	    return isZero(r) ? null : POWER.compute(l, BigDecimal.ONE.divide(r));
	}
    },
    COMPARE('~', "Comparison : Sign of l minus r") {
	BigDecimal compute(BigDecimal l, BigDecimal r) {
	    final int comparison = l.compareTo(r);
	    return comparison < 0 ? BigDecimal.ONE.negate() : 
                   comparison > 0 ? BigDecimal.ONE : BigDecimal.ZERO;
	}
    },
    MOVE_POINT_LEFT('{', "Move point to the left") {
	BigDecimal compute(BigDecimal l, BigDecimal r) {
	    return l.movePointLeft(r.intValueExact());
	}
    },    
    MOVE_POINT_RIGHT('}', "Move point to the right") {
	BigDecimal compute(BigDecimal l, BigDecimal r) {
	    return l.movePointRight(r.intValueExact());
	}
    },    
    SHIFT_BIT_LEFT('<', "Binary left shift") {
	BigDecimal compute(BigDecimal l, BigDecimal r) {
	    return new BigDecimal((l.longValueExact()) << (r.longValueExact()));
	}
    },
    SHIFT_BIT_RIGHT('>', "Binary right shift") {
	BigDecimal compute(BigDecimal l, BigDecimal r) {
	    return new BigDecimal((l.longValueExact()) >> (r.longValueExact()));
	}
    },
    AND('&', "Binary AND operation") {
	BigDecimal compute(BigDecimal l, BigDecimal r) {
	    return new BigDecimal((l.longValueExact()) & (r.longValueExact()));
	}
    },
    OR('|', "Binary OR operation") {
	BigDecimal compute(BigDecimal l, BigDecimal r) {
	    return new BigDecimal((l.longValueExact()) | (r.longValueExact()));
	}
    },
    MAX('M', "Maximum") {
	BigDecimal compute(BigDecimal l, BigDecimal r) {
	    return l.max(r);
	}
    },
    MIN('m', "Minimum") {
	BigDecimal compute(BigDecimal l, BigDecimal r) {
	    return l.min(r);
	}
    },
    POWER_BY_TEN('E', "Exponent (power by ten)") {
	BigDecimal compute(BigDecimal l, BigDecimal r) {
	    return l.scaleByPowerOfTen(r.intValueExact()); 
	}
    },
    /*
    NAND('!', "Binary NAND operation") {
	BigDecimal compute(BigDecimal l, BigDecimal r) {
	//TODO
	}
    },
    NOR('#', "Binary NOR operation") {
	BigDecimal compute(BigDecimal l, BigDecimal r) {
	// TODO
	}
    },
    XOR('X', "Binary XOR operation") {
	BigDecimal compute(BigDecimal l, BigDecimal r) {
	// TODO
	}
    },
    */
    ;

    private static boolean isZero(BigDecimal n) {
	return n.compareTo(BigDecimal.ZERO) == 0;
    }

    private static final BigDecimal HALF = new BigDecimal("0.5");

    private BinaryOperator(char symbol, String desc) {
	this.symbol = symbol;
	this.desc = desc;
    }

    private final char symbol;
    private final String desc;

    char getSymbol() { return symbol; }

    String getDescription() { return desc; }
    
    /** Delivers the result. It returns NULL if it could not compute a result. */
    abstract BigDecimal compute(BigDecimal l, BigDecimal r) throws ArithmeticException;
    
    public String toString() {
	return String.valueOf(symbol);
    }
}
