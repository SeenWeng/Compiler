package inter;

import lexer.*;

public class Node {

	int lexline = 0; // 保存了本节点对应的构造在源程序中的行号

	Node() {
		lexline = Lexer.line;
	}

	void error(String s) {
		throw new Error("near line " + lexline + ": " + s);
	}

	static int labels = 0;

	public int newlabel() {
		return ++labels;
	}

	public void emitlabel(int i) {
		System.out.print("L" + i + ":");
	}

	public void emit(String s) {
		System.out.println("\t" + s);
	}
}
