package com.ksoot;

import com.ksoot.expr.Expressions;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.mvel2.MVEL;

public class TryMe {

  public static void main(String[] args) {
    Double a_multiply_b_plus_c_result =
        MVEL.executeExpression(
            Expressions.mvel_a_multiply_b_plus_c_expr,
            Map.of("a", 5, "b", 10, "c", 15),
            Double.class);
    System.out.println("a_multiply_b_plus_c_result --->>" + a_multiply_b_plus_c_result);

    // Define the expression where 'square' will be used
    Serializable square_expr =
        MVEL.compileExpression("square.applyAsDouble(x)", Expressions.parserContext);
    Double square_result =
        MVEL.executeExpression(
            square_expr, Map.of("square", Expressions.square, "x", 5), Double.class);
    System.out.println("square_result --->>" + square_result);

    // Use a mutable map instead of Map.of()
    Map<String, Object> variables = new HashMap<>();
    variables.put("x", 5);
    variables.put("y", 10);

    Object greater_than_equal_to_result =
        MVEL.executeExpression(Expressions.mvel_greater_than_equal_to_expr, variables);
    System.out.println("greater_than_equal_to_result --->>" + greater_than_equal_to_result);
  }
}
