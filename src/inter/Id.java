package inter;

import lexer.*;
import symbols.*;

public class Id extends Expr {

	public int offset; // 保存了标识符的相对地址

	public Id(Word id, Type p, int b) {
		super(id, p); // 保存在继承得到的字段op和type中
		offset = b;
	}

	// public String toString() {return "" + op.toString() + offset;}
}
