package lexer;

/**
 * 用于处理浮点数
 * 
 * @author seanweng
 * 
 */
public class Real extends Token {
	public final float value;

	public Real(float f) {
		super(Tag.REAL);
		value = f;
	}

	public String toString() {
		return "" + value;
	}
}