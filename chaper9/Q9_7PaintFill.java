package chaper9;

enum color {
	GREEN, RED, WHITE;
}
public class Q9_7PaintFill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		color[][] screen = {
				{color.GREEN, color.GREEN, color.WHITE,}, 
				{color.GREEN, color.RED, color.RED,},
				{color.GREEN, color.RED, color.RED,},
				};
		printScreen(screen);
		paintFill(screen, 1, 0, color.GREEN, color.WHITE);
		printScreen(screen);
	}
	static void printScreen(color[][] screen) {
		for(int i = 0; i < screen.length; i++){
			for(int j = 0; j < screen[0].length; j++) {
				System.out.print(screen[i][j] + " ");
			}
			System.out.println();
		}
	}
	static void paintFill(color[][] screen, int x, int y, color ori, color c) {
		if(x >= screen.length | y >= screen[0].length | x < 0 | y < 0)
			return;
		if(ori == (c)) {
			return;
		}
		if(screen[x][y] != ori) 
			return;
		screen[x][y] = c;
		paintFill(screen, x + 1, y, ori, c);
		paintFill(screen, x - 1, y, ori, c);
		paintFill(screen, x, y + 1, ori, c);
		paintFill(screen, x, y - 1, ori, c);
	}

}
