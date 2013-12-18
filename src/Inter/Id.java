package Inter;

import symbols.Type;
import lexer.Word;

public class Id extends Expr {
	public int offset; // 保存了标识符的相对地址

	public Id(Word id, Type p, int b) {
		super(id, p); // 保存在继承得到的字段op和type中
		offset = b;
	}
}
