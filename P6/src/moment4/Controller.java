package moment4;

import java.util.Random;



public class Controller
{
	private TestUI4 ui;
	private Array7x7 array;
	private Array7 leftColumn;
	private Array7 rightColumn;
	Array7x7 charArray;
	protected static final int ARRAY_SIZE = 7;
	
	Random rand = new Random();
	/**
	 * Constructor that create links to our user interface and Array7x7 
	 * and also initializes left- and right- column arrays.
	 */
	public Controller()
	{
		ui = new TestUI4();
		array = new Array7x7();
		leftColumn = new Array7();
		rightColumn = new Array7();
	}
	/**
	 * Constructor that receives a TestUI4 object and link the
	 * controller to the user interface. It also creates a link to
	 * Array7x7 and initializes left- and right- column arrays.
	 * @param indata TestUI4 Object containing the user interface.
	 */
	public Controller(TestUI4 indata)
	{
		this.ui = indata;
		array = new Array7x7();
		leftColumn = new Array7();
		rightColumn = new Array7();
	}
	/**
	 * Method that returns the Array7x7 object.
	 * @return Array7x7 object.
	 */
	public Array7x7 getArray7x7()
	{
		return array;
	}
	/**
	 * Method that returns the leftColumn-array as an Array7 object.
	 * @return Array7 object with 7 values.
	 */
	public Array7 getLeftColumn()
	{
		return leftColumn;
	}
	/**
	 * Method that returns the rightColumn-array as an Array7 object.
	 * @return Array7 object with 7 values.
	 */
	public Array7 getRightColumn()
	{
		return rightColumn;
	}
	/**
	 * Method that takes an incoming Array7 object and writes it to our leftColumn-array.
	 * @param leftColumn - Array7 object with 7 values.
	 */
	public void setLeftColumn(Array7 leftColumn)
	{
		this.leftColumn = leftColumn;
	}
	/**
	 * Method that takes an incoming Array7 object and writes it to our rightColumn-array.
	 * @param rightColumn - Array7 object with 7 values.
	 */
	public void setRightColumn(Array7 rightColumn)
	{
		this.rightColumn = rightColumn;
	}
	
	/**
	 * Method that will put random colors in the left and right column (with 155-255
	 * alpha value) and in all elements in our Array7x7 object. Method is used on
	 * startup to put colors on the display before any buttons are pressed. When all
	 * elements got a random color, ui.updateScreen() will run to sync it with
	 * ColorDisplay.
	 */	public void randomize()
	{
		for (int row=0;row<ARRAY_SIZE;row++)
		{
			leftColumn.setElement(row, Color.argb(rand.nextInt(100)+155,rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
			rightColumn.setElement(row, Color.argb(rand.nextInt(100)+155,rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
			for(int col=0;col<ARRAY_SIZE;col++)
			{
				array.setElement(row,  col, Color.argb(rand.nextInt(100)+155,rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));  
			}
		}
		ui.updateScreen();
	}
	 
	 /**
	 * Method that will put random colors in the left column (with 155-255 alpha value).
	 */ 
	public void randomizeLeftColumn()
	{
		for (int row=0;row<ARRAY_SIZE;row++)
		{
			leftColumn.setElement(row, Color.argb(rand.nextInt(100)+155,rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
		}
		ui.updateScreen();
	}
	/**
	 * Method that will put random colors in the right column (with 155-255 alpha value).
	 */
	public void randomizeRightColumn()
	{
		for(int row=0;row<ARRAY_SIZE;row++)
		{
			rightColumn.setElement(row, Color.argb(rand.nextInt(100)+155,rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
		}
		ui.updateScreen();
	}
	
	/**
	 * Method that randomize new colors for the right column and then check if col
	 * is 0. If col is 0, then it will copy the column to our left column-array.
	 * If col is'nt 0 then it will copy the column one step to the left. This will 
	 * be repeated until all columns have moved one step. When all movement is done
	 * the last column to the right will get new colors from the right-column array
	 * and the screen will be updated.
	 */
	public void moveLeft()
	{
		randomizeRightColumn();
		for (int col=0;col<ARRAY_SIZE;col++)
		{
			if (col==0)
			{
				setLeftColumn(array.getCol(col));				
			}
			else
			{
				array.setCol(col-1, array.getCol(col));
			}
		}
		array.setCol(ARRAY_SIZE-1, getRightColumn());
		ui.updateScreen();
	}
	
	/**
	 * Method that randomize new colors for the left column and then check if col is
	 * ARRAY_SIZE-1 (6). If col is ARRAY_SIZE-1, then it will copy the column to our 
	 * right-column array. If col is'nt ARRAY_SIZE-1 then it will copy the columns one 
	 * step to the right. This will be repeated until all columns have moved one step.
	 * When all movement is done the last column to the left will get new colors from 
	 * left-column array and the screen will be updated.
	 */
	public void moveRight()
	{
		randomizeLeftColumn();
		for(int col=ARRAY_SIZE-1;col>=0;col--)
		{
			if (col==ARRAY_SIZE-1)
			{
				setRightColumn(array.getCol(col));
			}
			else
			{
				array.setCol(col+1,  array.getCol(col));
			}
		}
		array.setCol(0, ui.readLeftColumn());
		ui.updateScreen();
	}
}


	
	
	
	
	






