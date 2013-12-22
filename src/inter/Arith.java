package inter;

import lexer.*;
import symbols.*;

/**
 * 实现双目运算
 * 
 * @author seanweng
 * 
 */
public class Arith extends Op {

	public Expr expr1, expr2;

	public Arith(Token tok, Expr x1, Expr x2) {
		super(tok, null); // tok是一个表示该运算符的词法单元,null是类型的占位符
		expr1 = x1;
		expr2 = x2;
		// 检查两个运算分量是否可以被类型强制为一个常见的数字类型
		type = Type.max(expr1.type, expr2.type);
		if (type == null)
			error("type error");
	}

	/**
	 * 把表达式的子表达式归约为地址，并将表达式的运算符作用于这些地址
	 */
	public Expr gen() {
		return new Arith(op, expr1.reduce(), expr2.reduce());
	}

	public String toString() {
		return expr1.toString() + " " + op.toString() + " " + expr2.toString();
	}
}
