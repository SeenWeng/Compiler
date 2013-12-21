package main;

import java.io.IOException;
import parser.Parser;
import lexer.Lexer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lexer lex = new Lexer();
		Parser parse;
		try {
			parse = new Parser(lex);
			parse.program();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
	}

}
