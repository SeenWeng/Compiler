package inter;

import java.io.FileWriter;
import java.io.IOException;

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

		FileWriter fw;
		try {
			fw = new FileWriter("tests/quaternion.txt");
			fw.write("L" + i + ":");
			System.out.print("L" + i + ":");
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void emit(String s) {
		FileWriter fw;
		try {
			fw = new FileWriter("tests/quaternion.txt");
			fw.write("\t" + s);
			fw.flush();
			fw.close();
			System.out.println("\t" + s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
