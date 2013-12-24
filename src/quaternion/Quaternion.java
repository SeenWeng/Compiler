package quaternion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Interpret.VirtualMachine;

/**
 * 中間代碼轉換成四元式
 * 
 * @author seanweng
 * 
 */
public class Quaternion {

	String[] qtnInfo = new String[200];
	List<String[]> cs = new ArrayList<String[]>();
	int lineNum = 0;

	/**
	 * 读取文件
	 */
	public void readCode() {
		try {
			FileReader fr = new FileReader("tests/quaternion.i");
			BufferedReader br = new BufferedReader(fr);
			while (br.readLine() != null) {
				lineNum++;
				String string = br.readLine();
				// System.out.println(string);
				// System.out.println("现在是第" + lineNum + "行");
				qtnInfo[lineNum] = string;
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 四元式
	 * 
	 * @author seanweng
	 * 
	 */
	public class Instruction {
		char op;
		char arg1;
		char arg2;
		char result;
	}

	public void getQuaternion() {
		String[] strTemp = new String[4];
		for (int i = 0; i < lineNum; i++) {
			if (qtnInfo[i].matches(" = ")) {
				int temp = qtnInfo[i].indexOf(" = ");
				strTemp[3] = qtnInfo[i].substring(temp - 1, temp);
				strTemp[1] = qtnInfo[i].substring(temp, temp + 1);
				if (qtnInfo[i].matches(" + ")) {
					strTemp[0] = "InsAdd";
					int temp2 = qtnInfo[i].indexOf(" + ");
					strTemp[2] = qtnInfo[i].substring(temp2, temp2 + 1);
				} else if (qtnInfo[i].matches(" minus ")) {
					temp = qtnInfo[i].indexOf(" minus ");
					strTemp[0] = "InsUminus";
				} else if (qtnInfo[i].matches(" - ")) {
					temp = qtnInfo[i].indexOf(" - ");
					strTemp[0] = "InsSub";
					int temp2 = qtnInfo[i].indexOf(" - ");
					strTemp[2] = qtnInfo[i].substring(temp2, temp2 + 1);
				} else if (qtnInfo[i].matches(" * ")) {
					temp = qtnInfo[i].indexOf(" * ");
					strTemp[0] = "InsMul";
					int temp2 = qtnInfo[i].indexOf(" * ");
					strTemp[2] = qtnInfo[i].substring(temp2, temp2 + 1);
				} else if (qtnInfo[i].matches(" / ")) {
					temp = qtnInfo[i].indexOf(" / ");
					strTemp[0] = "InsDiv";
					int temp2 = qtnInfo[i].indexOf(" / ");
					strTemp[2] = qtnInfo[i].substring(temp2, temp2 + 1);
				} else {
					strTemp[2] = "";
				}
				cs.add(strTemp);
			} else if (qtnInfo[i].matches(" goto ")) {
				int temp = qtnInfo[i].indexOf(" goto ");
				strTemp[0] = "InsJmp";
				strTemp[1] = "";
				strTemp[2] = "";
				strTemp[3] = qtnInfo[i].substring(temp + 6, temp + 8);
				cs.add(strTemp);
			}
		}
		VirtualMachine v = new VirtualMachine();
		v.interpret(cs);
	}

	String[] instrs = { "Jtrue", // 为真则跳转 (InsJtrue, arg1, , dest)
			"Jfalse", // 为假则跳转 (InsJfalse,arg1, , dest)
			"Jmp", // 无条件跳转 (InsJmp, , , dest)
			"Mov", // 数据复制 (InsMov, arg1, ,dest)
			"Init", // 初始化某单元 (InsInit,arg1,num, )
			"Add", // 加法 (InsAdd, arg1,arg2,dest)
			"Sub", // 减法 (InsSub, arg1,arg2,dest)
			"Mul", // 乘法 (InsMul, arg1,arg2,dest)
			"Div", // 除法 (InsDiv, arg1,arg2,dest)
			"Mod", // 取余
			"Nop", // 空操作 (InsNop, , , )
			"Jlt", // 判断是否< (InsLt,arg1,arg2,result)
			"Jle", // 判断是否<= (InsLe,arg1,arg2,result)
			"Jgt", // 判断是否> (InsGt,arg1,arg2,result)
			"Jge", // 判断是否>=
			"Jeq", // 判断是否==
			"Jne", // 判断是否!=
			"Or", // 逻辑或运算
			"And", // 逻辑与运算
			"Not", // 逻辑非运算
			"In", // 输入
			"Out", // 输出
			"Uminus", // 求相反数
			"Call", // 过程调用 (InsCall,des, , ,);
			"Ret", // 过程返回 (InsRet,expr, , );
			"SetBx", // 设置bx指针，指向活动记录首地址(InsSetBx,addr, , )
			"AddBx", // 增加bx的值
	};

}
