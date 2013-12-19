package Inter;

import lexer.Token;

/**
 * 实现单目运算
 * 
 * @author seanweng
 * 
 */
public class Not extends Logical {
	public Not(Token tok,Expr x1) {
		super(tok, x1, x1);
		// TODO Auto-generated constructor stub
	}

	public void jumping(int t, int f) {
		expr2.jumping(f,t);
	}

	public String toString() {
		return op.toString() + " " + expr2.toString();
	}
}
