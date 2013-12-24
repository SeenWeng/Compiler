package inter;

import java.io.IOException;

import lexer.*;
import symbols.*;

/**
 * Class Logical 为Or,And和Not提供了一些常见的功能
 * 
 * @author seanweng
 * 
 */
public class Logical extends Expr {

	public Expr expr1, expr2; // 对应于一个逻辑运算符的运算分量

	/**
	 * 
	 * @param tok
	 *            运算符
	 * @param x1
	 *            运算分量
	 * @param x2
	 *            运算分量
	 */
	Logical(Token tok, Expr x1, Expr x2) {
		super(tok, null); // null type to start
		expr1 = x1;
		expr2 = x2;
		type = check(expr1.type, expr2.type);
		if (type == null)
			error("type error");
	}

	/**
	 * check()保证a和b都是布尔类型
	 */
	public Type check(Type p1, Type p2) {
		if (p1 == Type.Bool && p2 == Type.Bool)
			return Type.Bool;
		else
			return null;
	}

	public Expr gen() {
		int f = newlabel();
		int a = newlabel();
		Temp temp = new Temp(type);
		this.jumping(0, f);
		emit(temp.toString() + " = true");
		emit("goto L" + a);
		emitlabel(f);
		emit(temp.toString() + " = false");
		emitlabel(a);
		return temp;
	}

	public String toString() {
		return expr1.toString() + " " + op.toString() + " " + expr2.toString();
	}
}
