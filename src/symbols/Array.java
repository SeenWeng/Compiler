package symbols;

import lexer.Tag;

/**
 * 数组是源语言中唯一的构造类型
 * 
 * @author seanweng
 * 
 */
public class Array extends Type {

	public Type of; // 设置数组的元素类型
	public int size = 1; // 元素个数

	public Array(int sz, Type p) {
		super("[]", Tag.INDEX, sz * p.width);
		size = sz;
		of = p;
	}

	public String toString() {
		return "[" + size + "]" + of.toString();
	}

}
