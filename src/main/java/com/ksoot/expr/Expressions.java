package com.ksoot.expr;

import java.io.Serializable;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;
import org.apache.commons.lang3.function.TriFunction;
import org.mvel2.MVEL;
import org.mvel2.ParserContext;

public class Expressions {

  // Set up MVEL Context
  public static ParserContext parserContext = new ParserContext();
  static {
    // Import OfferType into the MVEL context since it may be used
    parserContext.addImport("Expressions", Expressions.class);
  }

  public static DoubleUnaryOperator square = x -> x * x;
//  public static Serializable mvel_square_expr =
//          MVEL.compileExpression(square_root_expr, parserContext);

  public static DoubleUnaryOperator square_root = Math::sqrt;

  public static DoubleBinaryOperator power = Math::pow;

  public static DoubleBinaryOperator add = (x, y) -> x + y;

  public static DoubleBinaryOperator multiply = (x, y) -> x * y;

  public static TriFunction<Integer, Integer, Integer, Integer> a_multiply_b_pluz_c =
      (a, b, c) -> a * b + c;

  public static String a_multiply_b_plus_c_expr = "a * b + c";
  public static Serializable mvel_a_multiply_b_plus_c_expr =
          MVEL.compileExpression(a_multiply_b_plus_c_expr, parserContext);

  public static String square_root_expr = "Math.sqrt(x)";
  public static Serializable mvel_square_root_expr =
          MVEL.compileExpression(square_root_expr, parserContext);


  public static String greater_than_equal_to_expr = "ge = def (source, target) { source >= target ? true : false }";
  public static Serializable mvel_greater_than_equal_to_expr =
          MVEL.compileExpression(greater_than_equal_to_expr, parserContext);
}
