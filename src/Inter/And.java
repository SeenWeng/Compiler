package Inter;

import lexer.Token;

public class And extends Logical {

	public And(Token tok, Expr x1, Expr x2) {
		super(tok, x1, x2);
		// TODO Auto-generated constructor stub
	}

	public void jumping(int t, int f) {
		int label = f != 0 ? f : newlable();
		expr1.jumping(0, label);
		expr2.jumping(t, f);
		if (f == 0) {
			emitlable(label);
		}
	}

}
