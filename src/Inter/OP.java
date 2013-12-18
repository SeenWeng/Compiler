package Inter;

import lexer.Token;
import symbols.Type;

public class OP extends Expr {

	public OP(Token tok, Type p) {
		super(tok, p);
	}

	public Expr reduce() {
		Expr x = gen();
		Temp t = new Temp(type);
		emit(t.toString() + " = " + x.toString());
		return t;
	}
}
