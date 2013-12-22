package symbols;

import lexer.*;

/**
 * 将int,float,char,boo等基本类型名字就是保留字，将被词法分析器从词素映射为适当的对象
 * 
 * @author seanweng
 * 
 */
public class Type extends Word {

	public int width = 0; // width is used for storage allocation

	public Type(String s, int tag, int w) {
		super(s, tag);
		width = w;
	}

	public static final Type Int = new Type("int", Tag.BASIC, 4),
			Float = new Type("float", Tag.BASIC, 8), Char = new Type("char",
					Tag.BASIC, 1), Bool = new Type("bool", Tag.BASIC, 1);

	public static boolean numeric(Type p) {
		if (p == Type.Char || p == Type.Int || p == Type.Float)
			return true;
		else
			return false;
	}

	/**
	 * 当一个运算符应用与两个数字类型时，结果类型是这两个类型的"max"值
	 * 
	 * @return
	 */
	public static Type max(Type p1, Type p2) {
		if (!numeric(p1) || !numeric(p2))
			return null;
		else if (p1 == Type.Float || p2 == Type.Float)
			return Type.Float;
		else if (p1 == Type.Int || p2 == Type.Int)
			return Type.Int;
		else
			return Type.Char;
	}
}
