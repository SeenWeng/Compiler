package symbols;

import java.util.Hashtable;

import org.omg.PortableServer.IdAssignmentPolicy;

import Inter.Id;
import lexer.Token;

/**
 * Class Lexer 把字符串映射为字，Class Env 把字符串词法单元映射为Class ID的对象
 * 
 * @author seanweng
 * 
 */
public class Env {
	private Hashtable<Token, Id> table;
	protected Env prev;

	public Env(Env n) {
		table = new Hashtable<Token, Id>();
		prev = n;
	}

	public void put(Token w, Id i) {
		table.put(w, i);
	}

	public Id get(Token w) {
		for (Env e = this; e != null; e = e.prev) {
			Id found = (Id) (e.table.get(w));
			if (found != null)
				return found;
		}
		return null;
	}
}
