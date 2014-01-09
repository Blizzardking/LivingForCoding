package chaper8;
public enum Suit {
	Club(0), Diamond(1), Heart(2), Spade(3);
	private int value;
	private Suit(int i) {
		value = i;
	}
	public int getValue() {
		return value;
	}
	public static Suit getSuitFromValue(int value) throws Exception{

		switch(value) {
		case 0: return Club;
		case 1: return Diamond;
		case 2: return Heart;
		case 3: return Spade;
		default: 
			throw new Exception("Unsupported value");
		}
	}
}