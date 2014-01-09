package chaper5;

public class Q5_8DrawLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte[] screen = {(byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
		drawLine(screen, 24, 3, 21, 1);
		for(int i = 0; i < screen.length; i++) {
			System.out.print( String.format("%8s", Integer.toBinaryString(screen[i] & 0xFF)).replace(' ', '0'));
		}

	}
	static void drawLine(byte[] screen, int width, int x1, int x2, int y) {
		assert screen.length * 8 > x1 && screen.length * 8 > x2 && screen.length * 8 > y;
		int bytesBeforeCurrent = y * (width/8);
		int startByte = bytesBeforeCurrent + x1 / 8;
		int endByte = bytesBeforeCurrent + x2 / 8;
		//int startOffset = 7 - x1 % 8;
		//int endOffset = 7 - x2 % 8;
		//byte mask1 = (byte)((1 << (startOffset + 1)) - 1);
		//byte mask2 = (byte)~((1 << endOffset) - 1);
		int startOffset = x1 % 8;
		int endOffset = x2 % 8;
		//Assume Big Endian similar mapping
		byte mask1 = (byte) (0xFF >> startOffset);
		
		byte mask2 = (byte) ~(0xFF >> endOffset + 1);
		if(startByte == endByte) {
			byte mask = (byte) (mask1 & mask2);
			screen[startByte] |= mask;
		}
		else {
			screen[startByte] |= mask1;
			
			for(int i = startByte + 1; i < endByte; i++) {
				screen[i] |= (byte) 0xFF;
			}
			
			screen[endByte] |= mask2;
		}
	}

}
