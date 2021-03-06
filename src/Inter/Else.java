package Inter;

import symbols.Type;

public class Else extends Stmt {
	Expr expr;
	Stmt stmt1, stmt2;

	public Else(Expr x, Stmt s1, Stmt s2) {
		expr = x;
		stmt1 = s1;
		stmt2 = s2;
		if (expr.type != Type.Bool) {
			expr.error("boolean required in if");
		}
	}

	public void gen(int b, int a) {
		int label1 = newlable(); // label1用于语句stmt1
		int label2 = newlable(); // label2用于语句stmt2
		expr.jumping(0, label2);
		emitlable(label1);
		stmt1.gen(label1, a);
		emit("goto L" + a);
		emitlable(label2);
		stmt2.gen(label2, a);
	}
}
