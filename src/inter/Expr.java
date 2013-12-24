package inter;

import java.io.IOException;

import lexer.*;
import symbols.*;

/**
 * Expr的某些方法处理布尔表达式和跳转代码
 * 
 * @author seanweng
 * 
 */
public class Expr extends Node {

	public Token op;
	public Type type;

	Expr(Token tok, Type p) {
		op = tok;
		type = p;
	}

	public Expr gen() {
		return this;
	}

	/**
	 * 把一个表达式计算(归约)成为一个单一的地址,返回一个常量，一个标识符或者一个临时名字
	 * 
	 * @return
	 */
	public Expr reduce() {
		return this;
	}

	public void jumping(int t, int f){
		emitjumps(toString(), t, f);
	}

	public void emitjumps(String test, int t, int f){
		if (t != 0 && f != 0) {
			emit("if " + test + " goto L" + t);
			emit("goto L" + f);
		} else if (t != 0)
			emit("if " + test + " goto L" + t);
		else if (f != 0)
			emit("iffalse " + test + " goto L" + f);
		else
			; // 不生成指令，因为t和f都直接穿越
	}

	public String toString() {
		return op.toString();
	}
}
