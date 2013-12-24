package Interpret;

import java.util.List;

public class VirtualMachine {

	static int pc; // 程序计数器
	static int bx; // 变址寄存器 指向活动记录的开始位置
	static int sum = 100;
	static boolean t1;

	// static List<String[]> cs;

	// static String InsJtrue; // 为真则跳转 (InsJtrue, arg1, , dest)
	// static String InsJfalse; // 为假则跳转 (InsJfalse,arg1, , dest)
	// static String InsJmp; // 无条件跳转 (InsJmp, , , dest)
	// static String InsMov; // 数据复制 (InsMov, arg1, ,dest)
	// static String InsInit; // 初始化某单元 (InsInit,arg1,num, )
	// static String InsAdd; // 加法 (InsAdd, arg1,arg2,dest)
	// static String InsSub; // 减法 (InsSub, arg1,arg2,dest)
	// static String InsMul; // 乘法 (InsMul, arg1,arg2,dest)
	// static String InsDiv; // 除法 (InsDiv, arg1,arg2,dest)
	// static String InsMod; // 取余
	// static String InsNop; // 空操作 (InsNop, , , )
	// static String InsJlt; // 判断是否< (InsLt,arg1,arg2,result)
	// static String InsJle; // 判断是否<= (InsLe,arg1,arg2,result)
	// static String InsJgt; // 判断是否> (InsGt,arg1,arg2,result)
	// static String InsJge; // 判断是否>=
	// static String InsJeq; // 判断是否==
	// static String InsJne; // 判断是否!=
	// static String InsOut; // 输出一个整数 (InsOut,num, ,);
	// static String InsUminus; // 负数 (InsUminus,oprn, ,dest)
	// static String InsCall; // 过程调用 (InsCall,des, , ,);
	// static String InsRet; // 过程返回 (InsRet,expr, , );

	// 虚拟机指令集
	// public enum InstrType {
	// InsJtrue, // 为真则跳转 (InsJtrue, arg1, , dest)
	// InsJfalse, // 为假则跳转 (InsJfalse,arg1, , dest)
	// InsJmp, // 无条件跳转 (InsJmp, , , dest)
	// InsMov, // 数据复制 (InsMov, arg1, ,dest)
	// InsInit, // 初始化某单元 (InsInit,arg1,num, )
	// InsAdd, // 加法 (InsAdd, arg1,arg2,dest)
	// InsSub, // 减法 (InsSub, arg1,arg2,dest)
	// InsMul, // 乘法 (InsMul, arg1,arg2,dest)
	// InsDiv, // 除法 (InsDiv, arg1,arg2,dest)
	// InsMod, // 取余
	// InsNop, // 空操作 (InsNop, , , )
	// InsJlt, // 判断是否< (InsLt,arg1,arg2,result)
	// InsJle, // 判断是否<= (InsLe,arg1,arg2,result)
	// InsJgt, // 判断是否> (InsGt,arg1,arg2,result)
	// InsJge, // 判断是否>=
	// InsJeq, // 判断是否==
	// InsJne, // 判断是否!=
	// InsOr, // 逻辑或运算
	// InsAnd, // 逻辑与运算
	// InsNot, // 逻辑非运算
	// InsIn, // 读入一个整数到单元dest (InsIn,dest , ,);
	// InsOut, // 输出一个整数 (InsOut,num, ,);
	// InsUminus, // 负数 (InsUminus,oprn, ,dest)
	// InsCall, // 过程调用 (InsCall,des, , ,);
	// InsRet, // 过程返回 (InsRet,expr, , );
	// InsSetBx, // 设置bx指针，指向活动记录首地址(InsSetBx,addr, , )
	// InsAddBx, // bx指针增加 (InsSetBx,addr);
	// };

	// /////////////////////////////////////////////////////////////////////

	// static int getAddress(int offset); //由活动记录内的偏移来求"变量的地址"

	// /////////////////////////////////////////////////////////////////////

	// 由偏移量求地址
	// static int getAddress(int offset) {
	// if (offset < 0) { // 全局变量的地址
	// return -offset;
	// } else { // 局部变量的地址
	// return bx + offset;
	// }
	// }

	public void interpret(List<String[]> cs) {
		int savedBx;
		String input, arg1, arg2, result;
		int arg1Int, arg2Int, resultInt;
		while (pc != sum) {
			switch (cs.get(pc)[0]) {
			case "InsUminus":
				result = String.valueOf(-Integer.parseInt(cs.get(pc)[1]));
				pc++;
				break;
			case "InsJne":
				arg1Int = Integer.parseInt(cs.get(pc)[1]);
				arg2Int = Integer.parseInt(cs.get(pc)[2]);
				if (arg1Int != arg2Int)
					pc = Integer.parseInt(cs.get(pc)[3]);
				else
					pc++;
				break;
			case "InsJeq":
				arg1Int = Integer.parseInt(cs.get(pc)[1]);
				arg2Int = Integer.parseInt(cs.get(pc)[2]);
				if (arg1Int == arg2Int)
					pc = Integer.parseInt(cs.get(pc)[3]);
				else
					pc++;
				break;
			case "InsJge":
				arg1Int = Integer.parseInt(cs.get(pc)[1]);
				arg2Int = Integer.parseInt(cs.get(pc)[2]);
				if (arg1Int >= arg2Int)
					pc = Integer.parseInt(cs.get(pc)[3]);
				else
					pc++;
				break;
			case "InsJgt":
				arg1Int = Integer.parseInt(cs.get(pc)[1]);
				arg2Int = Integer.parseInt(cs.get(pc)[2]);
				if (arg1Int > arg2Int)
					pc = Integer.parseInt(cs.get(pc)[3]);
				else
					pc++;
				break;
			case "InsJle":
				arg1Int = Integer.parseInt(cs.get(pc)[1]);
				arg2Int = Integer.parseInt(cs.get(pc)[2]);
				if (arg1Int <= arg2Int)
					pc = Integer.parseInt(cs.get(pc)[3]);
				else
					pc++;
				break;
			case "InsJlt":
				arg1Int = Integer.parseInt(cs.get(pc)[1]);
				arg2Int = Integer.parseInt(cs.get(pc)[2]);
				if (arg1Int < arg2Int)
					pc = Integer.parseInt(cs.get(pc)[3]);
				else
					pc++;
				break;
			case "InsNop":
				pc++;
				break;
			case "InsMod":
				arg1Int = Integer.parseInt(cs.get(pc)[1]);
				arg2Int = Integer.parseInt(cs.get(pc)[2]);
				result = String.valueOf((arg1Int) % (arg2Int));
				cs.get(pc)[3] = result;
				pc++;
				break;
			case "InsDiv":
				arg1Int = Integer.parseInt(cs.get(pc)[1]);
				arg2Int = Integer.parseInt(cs.get(pc)[2]);
				result = String.valueOf((arg1Int) / (arg2Int));
				cs.get(pc)[3] = result;
				pc++;
				break;
			case "InsMul":
				arg1Int = Integer.parseInt(cs.get(pc)[1]);
				arg2Int = Integer.parseInt(cs.get(pc)[2]);
				result = String.valueOf((arg1Int) * (arg2Int));
				cs.get(pc)[3] = result;
				pc++;
				break;
			case "InsSub":
				arg1Int = Integer.parseInt(cs.get(pc)[1]);
				arg2Int = Integer.parseInt(cs.get(pc)[2]);
				result = String.valueOf((arg1Int) - (arg2Int));
				cs.get(pc)[3] = result;
				pc++;
				break;
			case "InsAdd":
				arg1Int = Integer.parseInt(cs.get(pc)[1]);
				arg2Int = Integer.parseInt(cs.get(pc)[2]);
				result = String.valueOf((arg1Int) + (arg2Int));
				cs.get(pc)[3] = result;
				pc++;
				break;
			case "InsInit":
				result = cs.get(pc)[1];
				cs.get(pc)[3] = result;
				pc++;
				break;
			case "InsMov":
				arg1 = cs.get(pc)[1];
				arg2 = cs.get(pc)[2];
				arg1 = arg2;
				cs.get(pc)[1] = cs.get(pc)[2];
				pc++;
				break;
			case "InsJmp":
				pc = Integer.parseInt(cs.get(pc)[3]);
				break;
			default:
				System.out.println("unknown instruction.");
			}
		}
	}
}
