package inter;

/**
 * 实现了一个语句序列
 * 
 * @author seanweng
 * 
 */
public class Seq extends Stmt {

	Stmt stmt1;
	Stmt stmt2;

	public Seq(Stmt s1, Stmt s2) {
		stmt1 = s1;
		stmt2 = s2;
	}

	public void gen(int b, int a) {
		if (stmt1 == Stmt.Null) // 测试空语句，避免使用标号
			stmt2.gen(b, a);
		else if (stmt2 == Stmt.Null)
			stmt1.gen(b, a);
		else {
			int label = newlabel();
			stmt1.gen(b, label);
			emitlabel(label);
			stmt2.gen(label, a);
		}
	}
}
