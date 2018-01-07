package moment6;

import java.util.Random;


public class Controller {
	private TestUI6 ui;
	private Array7 leftColumn;
	private Array7 rightColumn;
	private Chars characters;
	Array7x7 charArray = new Array7x7();
	protected static int ARRAY_SIZE = 7;
	protected static int NUMBER_OF_ARRAYS_WIDE = 5;
	String inputText;

	private boolean firstTime = true;
	private int columnCounter = 0;
	private int characterIndex = 0;
	Random rand = new Random();
	private Array7x7[] array5x7x7 = new Array7x7[5];

	/**
	 * Constructor that create links to the user interface and Chars class, and new
	 * Array7s for the left and the right column, and creates an array with
	 * NUMBER_OF_ARRAYS_WIDE (5) Array7x7 objects.
	 */
	public Controller() {
		ui = new TestUI6();
		characters = new Chars();
		leftColumn = new Array7();
		rightColumn = new Array7();
		inputText = "";
		for (int index = 0; index < NUMBER_OF_ARRAYS_WIDE; index++) {
			array5x7x7[index] = new Array7x7();
		}
	}

	/**
	 * Constructor that receive an incoming TestUI6 object to link with the user
	 * interface and create a link to the Chars class, and new Array7 for the left
	 * and right column, and create an array with NUMBER_OF_ARRAYS_WIDE (5) Array7x7
	 * objects.
	 * 
	 * @param indata
	 *            TestUI6 object to connect with the UI.
	 */
	public Controller(TestUI6 indata) {
		this.ui = indata;
		characters = new Chars();
		leftColumn = new Array7();
		rightColumn = new Array7();
		inputText = "";
		for (int index = 0; index < NUMBER_OF_ARRAYS_WIDE; index++) {
			array5x7x7[index] = new Array7x7();
		}
	}

	/**
	 * Method that return a specific Array7x7 from our 5x7x7 Array.
	 * 
	 * @param int
	 *            index - the index of a specific Array7x7 we want to be returned.
	 * @return An Array7x7 object.
	 */
	public Array7x7 getArray7x7(int index) {
		return array5x7x7[index];
	}

	/**
	 * Method that return the left column as an Array7.
	 * 
	 * @return The left column as an Array7.
	 */
	public Array7 getLeftColumn() {
		return leftColumn;
	}

	/**
	 * Method that return the right column as an Array7.
	 * 
	 * @return The right column as an Array7.
	 */
	public Array7 getRightColumn() {
		return rightColumn;
	}

	/**
	 * Method that get an incoming Array7 object and write it to our left
	 * column-array.
	 * 
	 * @param leftColumn
	 *            - Array7 object with 7 values.
	 */
	public void setLeftColumn(Array7 leftColumn) {
		this.leftColumn = leftColumn;
	}

	/**
	 * Method that get and incoming Array7 object and write it to our right
	 * column-array.
	 * 
	 * @param rightColumn
	 *            - Array7 object with 7 values.
	 */
	public void setRightColumn(Array7 rightColumn) {
		this.rightColumn = rightColumn;
	}

	/**
	 * Method that will put random colors in the left and right column (with 255
	 * alpha value) and in all elements in every Array7x7 object. Method is used on
	 * startup to put colors on the display before any buttons are pressed. When all
	 * elements got a random color, ui.updateScreen() will run to sync it with
	 * ColorDisplay.
	 */
	public void randomize() {
		for (int row = 0; row < 7; row++) {
			leftColumn.setElement(row, Color.argb(255, rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
			rightColumn.setElement(row, Color.argb(255, rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
			for (int col = 0; col < 7; col++) {
				for (int index = 0; index < array5x7x7.length; index++) {
					array5x7x7[index].setElement(row, col,
							Color.argb(255, rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
				}
			}
		}
		ui.updateScreen();
	}

	/**
	 * Method that will put random colors in the left column (with 255 alpha value).
	 */
	public void randomizeLeftColumn() {
		for (int row = 0; row < ARRAY_SIZE; row++) {
			leftColumn.setElement(row, Color.argb(255, rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
		}
		ui.updateScreen();
	}

	/**
	 * Method that will put random colors in the right column (with 255 alpha value)
	 */
	public void randomizeRightColumn() {
		for (int row = 0; row < ARRAY_SIZE; row++) {
			rightColumn.setElement(row, Color.argb(255, rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
		}
		ui.updateScreen();
	}

	/**
	 * Method that randomize new colors for the right column and then check if col
	 * is 0. If col is 0, then it will check if it has reached the first Array7x7
	 * (the one most to the left) then it will copy the column to our left column,
	 * otherwise it will copy the column to the previous Array7x7 array. If col isnt
	 * 0, then it will copy the column one step to the left. This will be repeated
	 * until all columns have moved one step. When all movement is done the last
	 * column to the right will get new colors from the right-column array and the
	 * screen will be updated.
	 */
	public void moveLeft() {
		randomizeRightColumn();
		for (int index = 0; index < array5x7x7.length; index++) {
			for (int col = 0; col < ARRAY_SIZE; col++) {
				if (col == 0 && index == 0) {
					setLeftColumn(array5x7x7[index].getCol(col));
				} else if (col == 0 && index > 0) {
					array5x7x7[index - 1].setCol(ARRAY_SIZE - 1, array5x7x7[index].getCol(col));
				} else {
					array5x7x7[index].setCol(col - 1, array5x7x7[index].getCol(col));
				}
			}

		}
		array5x7x7[array5x7x7.length - 1].setCol(ARRAY_SIZE - 1, getRightColumn());
		ui.updateScreen();

	}

	/**
	 * Method that randomize new colors for the left column and then check if col is
	 * ARRAY_SIZE - 1 (6). If so it will check if it has reach the last Array7x7
	 * (the one most to the right) then it will copy the column to our right-column,
	 * otherwise it will copy the column to the next Array7x7 array. If col isnt
	 * ARRAY_SIZE, then it will copy the column on step to the right. This will be
	 * repeated until all columns have moved one step. When all movement is done the
	 * first column on the left will get new colors from the left-column array. and
	 * the screen will be updated.
	 */
	public void moveRight() {
		randomizeLeftColumn();
		for (int index = array5x7x7.length - 1; index >= 0; index--) {
			for (int col = ARRAY_SIZE - 1; col >= 0; col--) {
				if (col == ARRAY_SIZE - 1 && index == array5x7x7.length - 1) {
					setRightColumn(array5x7x7[index].getCol(col));
				} else if (col == ARRAY_SIZE - 1 && index < array5x7x7.length - 1) {
					array5x7x7[index + 1].setCol(0, array5x7x7[index].getCol(col));
				} else {
					array5x7x7[index].setCol(col + 1, array5x7x7[index].getCol(col));
				}
			}
		}
		array5x7x7[0].setCol(0, getLeftColumn());
		ui.updateScreen();
	}

	/**
	 * Method that reset the moveLeftText() and moveRightText() after an String has
	 * been sent to ColorDisplay.
	 */
	public void resetCounters() {
		firstTime = true;
	}

	/**
	 * Method that take an incoming Array7x7 character and set all fields with
	 * values 0 to white color and all fields with value 1 to black color.
	 * 
	 * @param a7x7
	 *            An Array7x7 object with a complete character.
	 * @return newArray - An Array7x7 object with black and white values.
	 */
	public Array7x7 colorizeCharArray(Array7x7 a7x7) {
		Array7x7 newArray = new Array7x7();
		for (int row = 0; row < ARRAY_SIZE; row++) {
			for (int col = 0; col < ARRAY_SIZE; col++) {
				if (a7x7.getElement(row, col) == 0) {
					newArray.setElement(row, col, Color.argb(255, 255, 255, 255));
				} else {
					newArray.setElement(row, col, Color.argb(255, 0, 0, 0));
				}
			}
		}
		return newArray;
	}

	/**
	 * Method that first checks if it has been run by the timer before. If not it
	 * will read inputTextField in the UI and save it as a String and reset all
	 * counters. The method will then check if characterIndex is still less then our
	 * length of the input String and if so, it will send a char to the Chars class
	 * and receive a complete character as an Array7x7 object. That Array7x7 object
	 * will get colorized by colorizeCharArray() and saved in charArray.
	 * 
	 * The method will then move every column one step to the left and if columnCounter
	 * reaches 7 it will reset and fetch a new character from Chars, otherwise it will  
	 * fetch a new column from the charArray and then update the screen.
	 */

	public void moveLeftText() {
		if (firstTime) // Första gången jag är här?
		{
			firstTime = false;
			columnCounter = 0;
			characterIndex = 0;
			inputText = ui.getTextField();
		}
		if (inputText.length() > characterIndex) {
			charArray = colorizeCharArray(characters.getChar(inputText.charAt(characterIndex)));
		}
		for (int index = 0; index < array5x7x7.length; index++) {
			for (int col = 0; col < ARRAY_SIZE; col++) {
				if (col == 0 && index == 0) {
					setLeftColumn(array5x7x7[index].getCol(col));
				} else if (col == 0 && index > 0) {
					array5x7x7[index - 1].setCol(ARRAY_SIZE-1, array5x7x7[index].getCol(col));
				} else {
					array5x7x7[index].setCol(col - 1, array5x7x7[index].getCol(col));
				}
			}
		}
		if (columnCounter < ARRAY_SIZE) {
			array5x7x7[array5x7x7.length - 1].setCol(ARRAY_SIZE-1, charArray.getCol(columnCounter));
		}
		columnCounter++;
		if (columnCounter == ARRAY_SIZE) {
			characterIndex++;
			columnCounter = 0;
		}
		ui.updateScreen();
	}

	/**
	 * Method that first check if it has been run by the timer before. If not it 
	 * will read inputTextField in the UI and save it as a String and reset all 
	 * counters. The method will then check if characterIndex is still less then our
	 * length of the input String and if so, it will send a char to the Chars class
	 * and receive a complete character as an Array7x7 object. That Array7x7 object
	 * will get colorized by colorizeCharArray() and saved in charArray. 
	 *
	 * The method will then move every column one step to the right and if columnCounter
	 * reaches -1 it will reset and fetch a new character from Chars, otherwise it will  
	 * fetch a new column from the charArray and then update the screen.
	 */
	
	public void moveRightText() {
		if (firstTime) 
		{
			firstTime = false;
			columnCounter = ARRAY_SIZE-1;
			characterIndex = 0;
			inputText = ui.getTextField();
		}
		if (inputText.length() > characterIndex) {
			charArray = colorizeCharArray(characters.getChar(inputText.charAt(characterIndex)));
		}
		for (int index = array5x7x7.length - 1; index >= 0; index--) {
			for (int col = ARRAY_SIZE-1; col >= 0; col--) {
				if (col == ARRAY_SIZE-1 && index == array5x7x7.length - 1) {
					setRightColumn(array5x7x7[index].getCol(col));
				} else if (col == ARRAY_SIZE-1 && index < array5x7x7.length - 1) {
					array5x7x7[index + 1].setCol(0, array5x7x7[index].getCol(col));
				} else {
					array5x7x7[index].setCol(col + 1, array5x7x7[index].getCol(col));
				}
			}
		}
		if (columnCounter >= 0) {
			array5x7x7[0].setCol(0, charArray.getCol(columnCounter));
		}
		columnCounter--;
		if (columnCounter < 0) {
			characterIndex++;
			columnCounter = ARRAY_SIZE-1;
		}
		ui.updateScreen();
	}
}
