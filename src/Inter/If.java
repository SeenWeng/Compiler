package Inter;

import symbols.Type;

public class If extends Stmt {
	Expr expr; // CLass Expr 的字段的名字
	Stmt stmt; // Class Stmt 的字段的名字

	public If(Expr x, Stmt s) {
		expr = x;
		stmt = s;
		if (expr.type != Type.Bool) {
			expr.error("boolean required in if");
		}
	}

	public void gen(int b, int a) {
		int label = newlable(); // stmt的代码的标号
		expr.jumping(0, a); // 为真时控制流穿越，为假时转向a
		emitlable(label);
		stmt.gen(label, a);
	}
}
