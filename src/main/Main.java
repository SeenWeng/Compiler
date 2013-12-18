package main;

import javax.swing.text.html.parser.Parser;
import javax.xml.bind.ParseConversionEvent;

import lexer.Lexer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lexer lex = new Lexer();
		Parse parse = new Parser(lex);
		parse.program();
		System.out.println();
	}

}
