package Inter;

import symbols.Type;

public class While extends Stmt {
	Expr expr;
	Stmt stmt;

	public While() {
		expr = null;
		stmt = null;
	}

	public void init(Expr x, Stmt s) {
		expr = x;
		stmt = s;
		if (expr.type != Type.Bool) {
			expr.error("boolean required in while");
		}
	}

	public void gen(int b, int a) {
		after = a; // 保存标号a
		expr.jumping(0, a);
		int label = newlable(); // 用于stmt的标号
		emitlable(label);
		stmt.gen(label, b);
		emit("goto L" + b);
	}
}
