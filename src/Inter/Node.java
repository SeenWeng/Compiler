package Inter;

import lexer.Lexer;

/**
 * 节点类
 * 
 * @author seanweng
 * 
 */
public class Node {
	public int lexline = 0; // 保存了本节点对应的构造在源程序中的行号

	public Node() {
		lexline = Lexer.line;
	}

	void error(String s) {
		throw new Error("near line" + lexline + ": " + s);
	}

	static int labels = 0;

	public int newlable() {
		return ++labels;
	}

	public void emitlable(int i) {
		System.out.print("L" + i + ":");
	}

	public void emit(String s) {
		System.out.println("\t" + s);
	}
}
