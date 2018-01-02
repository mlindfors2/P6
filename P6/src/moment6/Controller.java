package moment6;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;




public class Controller
{
	private TestUI6 ui;
	private Array7x7 array;
	private Array7 leftColumn;
	private Array7 rightColumn;
	private Chars characters;
	Array7x7 charArray = new Array7x7();
	String inputText = "";
	private boolean first = true;
	
	private int index1 = 0;
	private int index2 = 0;
	private int index3 = 0;
	Random rand = new Random();
	public Controller()
	{
		array = new Array7x7();
		ui = new TestUI6();
		characters = new Chars();
		leftColumn = new Array7();
		rightColumn = new Array7();
	
	}
	public Controller(TestUI6 indata)
	{
		array = new Array7x7();
		this.ui = indata;
		characters = new Chars();
		leftColumn = new Array7();
		rightColumn = new Array7();
	}
	public Array7x7 getArray7x7()
	{
		return array;
	}
	
	public Array7 getLeftColumn()
	{
		return leftColumn;
	}
	public Array7 getRightColumn()
	{
		return rightColumn;
	}
	public void setLeftColumn(Array7 leftColumn)
	{
		this.leftColumn = leftColumn;
	}
	public void setRightColumn(Array7 rightColumn)
	{
		this.rightColumn = rightColumn;
	}
	
	public void randomize()
	{
		for (int row=0;row<7;row++)
		{
			leftColumn.setElement(row, Color.argb(255,rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
			rightColumn.setElement(row, Color.argb(255,rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
			for(int col=0;col<35;col++)
			{
				array.setElement(row,  col, Color.argb(255,rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));  
			}
		}
		ui.updateScreen();
	}
	
	public void randomizeLeftColumn()
	{
		for (int row=0;row<7;row++)
		{
			leftColumn.setElement(row, Color.argb(255,rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
		}
		ui.updateScreen();
	}
	public void randomizeRightColumn()
	{
		for(int row=0;row<7;row++)
		{
			rightColumn.setElement(row, Color.argb(255,rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
		}
		ui.updateScreen();
	}
	
	
	public void setAllToZero()
	{
		for (int row=0;row<7;row++)
		{
			for(int col=0;col<7;col++)
			{
				array.setElement(row, col, 0);
				
			}
		}
		ui.updateScreen();
	}
	public void moveLeft()
	{
		randomizeRightColumn();
		for (int col=0;col<35;col++)
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
//		setRightColumn(ui.readRightColumn());
		array.setCol(34, getRightColumn());
		ui.updateScreen();
	}
	
	public void moveRight()
	{
		randomizeLeftColumn();
		for(int col=34;col>=0;col--)
		{
			if (col==34)
			{
				setRightColumn(array.getCol(col));
			}
			else
			{
				array.setCol(col+1,array.getCol(col));
			}
		}
//		setLeftColumn(ui.readLeftColumn());
		array.setCol(0, getLeftColumn());
		ui.updateScreen();
	}
	
	public void resetCounters()
	{
		first = true;
	}
	public Array7x7 transformCharArray(Array7x7 a7x7)
	{
		Array7x7 newArray = new Array7x7();
		for (int row = 0;row<7;row++)
		{
			for(int col=0;col<7;col++)
			{
				if (a7x7.getElement(row, col) == 0)
				{
					//GÖR VIT
					newArray.setElement(row, col, Color.argb(255, 255, 255, 255));
				}
				else 
				{
					//GÖR SVART
					newArray.setElement(row, col, Color.argb(255, 0, 0, 0));
				}
			}
		}
		return newArray;
	}
	
	public void moveLeftText()
	{
		
		if (first) // Första gången jag är här?
		{
			first = false;
			index1 =0;
			index2 =0;
			index3 =0;
			inputText = ui.getTextField();
		
		}
		if (inputText.length() > index3)
		{
			charArray = transformCharArray(characters.getChar(inputText.charAt(index3)));
		}
		index1++;
		if ( index1 > 6)
		{
			index3++;
			index1 = 0;
		}
		for(int col=0;col<35;col++)
		{
			if (col == 0)
			{
				setLeftColumn(array.getCol(col));
			}
			else
			{
				array.setCol(col-1, array.getCol(col));
			}
		}
		if (index2 <7)
		{
			array.setCol(34, charArray.getCol(index2));
		}
		index2++;
		
		if (index2 >6)
			index2=0;
		ui.updateScreen();
		
	}
	public void moveRightText()
	{
		if (first) // Första gången jag är här?
		{
			first = false;
			index1 =0;
			index2 =0;
			index3 =0;
			inputText = ui.getTextField();
		}
		if (inputText.length() > index3)
		{
			charArray = transformCharArray(characters.getChar(inputText.charAt(index3)));
			
		}
		index1++;
		if ( index1 > 6)
		{
			index3++;
			index1 = 0;
		}
		for(int col=34;col>=0;col--)
		{
			if (col == 34)
			{
				setRightColumn(array.getCol(col));
			}
			else
			{
				array.setCol(col+1, array.getCol(col));
			}
		}
		if (index2 <7)
		{
			array.setCol(0, charArray.getCol(index2));
		}
		index2++;
		
		if (index2 >6)
			index2=0;
		ui.updateScreen();
	
	}
	
	public int[][] fetchPartOfArray(Array7x7 a7x7, int index)
	{
		int[][] newArray = new int[7][7];
		for (int row=0;row<7;row++)
		{
			for (int col=0;col<7;col++)
			{
				newArray[row][col] = a7x7.getElement(row, col+(index*7));
			}
		}
		return newArray;
	}
}
	

	
	






