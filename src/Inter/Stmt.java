package Inter;

public class Stmt extends Node {
	/**
	 * 构造函数不用做任何事，相关处理工作是在子类中完成的
	 */
	public Stmt() {
	}

	public static Stmt Null = new Stmt();

	/**
	 * 调用时的参数是语句开始处的标号和语句的下一条指令的标号
	 */
	public void gen(int b, int a) {
	}

	int after = 0; // 保存语句的下一条指令的标号
	public static Stmt Enclosing = Stmt.Null; // 用于break语句
}
