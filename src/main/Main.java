package main;

import java.io.*;

import lexer.*;
import parser.*;
import quaternion.Quaternion;

public class Main {

	public static void main(String[] args) throws IOException {
		Lexer lex = new Lexer();
		Parser parse = new Parser(lex);
		parse.program();
		System.out.write('\n');
		Quaternion quaternion = new Quaternion();
		quaternion.readCode();
		quaternion.getQuaternion();
	}
}
