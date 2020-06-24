import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Runner {
	
	public static void main(String[] args) {
		openGame();
	}
	
	public static void openGame() {
		try {
			Robot robot = new Robot();
			
			//Opens chrome tab
			robot.keyPress(KeyEvent.VK_WINDOWS);
			Thread.sleep(10);
			robot.keyRelease(KeyEvent.VK_WINDOWS);
			Thread.sleep(50);
			type(robot,KeyEvent.VK_C);
			type(robot,KeyEvent.VK_H);
			type(robot,KeyEvent.VK_R);
			type(robot,KeyEvent.VK_O);
			type(robot,KeyEvent.VK_M);
			type(robot,KeyEvent.VK_E);
			Thread.sleep(100);
			type(robot,KeyEvent.VK_ENTER);
			Thread.sleep(2000);

			//opens website 
			//IMPORTANT - in order for the bot to work you have to have previously gone onto the website 
			//and selected an expert mode puzzle, otherwise the coordinates will be desynced
			type(robot,KeyEvent.VK_2);
			type(robot,KeyEvent.VK_4);
			type(robot,KeyEvent.VK_7);
			type(robot,KeyEvent.VK_W);
			type(robot,KeyEvent.VK_O);
			type(robot,KeyEvent.VK_R);
			type(robot,KeyEvent.VK_D);
			type(robot,KeyEvent.VK_S);
			type(robot,KeyEvent.VK_E);
			type(robot,KeyEvent.VK_A);
			type(robot,KeyEvent.VK_R);
			type(robot,KeyEvent.VK_C);
			type(robot,KeyEvent.VK_H);
			type(robot,KeyEvent.VK_PERIOD);
			type(robot,KeyEvent.VK_C);
			type(robot,KeyEvent.VK_O);
			type(robot,KeyEvent.VK_M);
			type(robot,KeyEvent.VK_ENTER);
			type(robot,KeyEvent.VK_WINDOWS,KeyEvent.VK_UP);
			
			Thread.sleep(10000);
			
			
			//Opens up the puzzle
			robot.mouseMove(1275, 200);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			Thread.sleep(1000);
			robot.mouseMove(600, 685);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			Thread.sleep(500);
			robot.mouseMove(600, 560);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			Thread.sleep(500);
			robot.mouseMove(750, 600);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			
			Thread.sleep(100);
			
			
			
			
			//Starts to make selections
			
			//Uncomment Thread.sleep(5); for it to look more aesthetically pleasing
			//Without them the graphics dont even load in time before the puzzle is done
			for(int row = 0; row < 10; row++) {
				for(int col = 0; col < 12; col++) {
					for(int length = 2; length < 12 - row; length++) {
						drag(robot, 505 + 44*col, 227 + 44*row, 505 + 44*col, 227 + (44*row) + (44*length));
						Thread.sleep(5);
						drag(robot, 505 + 44*row, 227 + 44*col, 505 + (44*row) + (44*length), 227 + 44*col);
						Thread.sleep(5);
					}
				}
			}
			for(int col = 0; col < 10; col++) {
				for(int row = 0; row < 10; row++) {
					for(int length = 2; row + length < 12 && col + length < 12; length++) {
						drag(robot, 505 + 44*col, 227 + 44*row, 505 + (44*col) + (44*length), 227 + (44*row) + (44*length));
						Thread.sleep(5);
					}
				}
			}
			
			for(int col = 0; col < 10; col++) {
				for(int row = 2; row < 12; row++) {
					for(int length = 2; row - length >= 0 && length + col < 12; length++) {
						drag(robot, 505 + 44*col, 227 + (44*row), 505 + (44*(col+length)), 227 + (44*(row-length)));
						Thread.sleep(5);
					}
				}
			}
			
			
			
		} catch (Exception e) {}
	}
	
	public static void drag(Robot robot, int x1, int y1, int x2, int y2) throws IOException{
		robot.mouseMove(x1, y1);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseMove(x2, y2);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}
	
	public static void type(Robot robot, int key) throws IOException {
		robot.keyPress(key);
		robot.keyRelease(key);
	}
	
	public static void type(Robot robot, int key1, int key2) throws IOException {
		robot.keyPress(key1);
		robot.keyPress(key2);
		robot.keyRelease(key2);
		robot.keyRelease(key1);
	}

	
	
}
