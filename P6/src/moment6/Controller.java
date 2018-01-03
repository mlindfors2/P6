package moment6;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;




public class Controller
{
	private TestUI6 ui;
//	private Array7x7 array;
	private Array7 leftColumn;
	private Array7 rightColumn;
	private Chars characters;
	Array7x7 charArray = new Array7x7();
	String inputText = "";
	private boolean firstTime = true;
	
	private int columnCounter = 0;
	private int columnInCharacter = 0;
	private int characterIndex = 0;
	Random rand = new Random();
	private Array7x7[] array5x7x7 = new Array7x7[5];
	public Controller()
	{
//		array = new Array7x7();
		ui = new TestUI6();
		characters = new Chars();
		leftColumn = new Array7();
		rightColumn = new Array7();
		for (int index = 0 ; index < 5; index++)
		{
			array5x7x7[index] = new Array7x7();
		}
		
		
	}
	public Controller(TestUI6 indata)
	{
//		array = new Array7x7();
		this.ui = indata;
		characters = new Chars();
		leftColumn = new Array7();
		rightColumn = new Array7();
		for (int index=0;index<5;index++)
		{
			array5x7x7[index] = new Array7x7(); 
		}
	}
	public Array7x7 getArray7x7(int index)
	{
		return array5x7x7[index];
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
			for(int col=0;col<7;col++)
			{
				for (int index=0;index<array5x7x7.length;index++)
				{
					
					array5x7x7[index].setElement(row,  col, Color.argb(255,rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
				}
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
	
	
	public void moveLeft()
	{
		randomizeRightColumn();
		for (int index=0;index<array5x7x7.length;index++)
		{
			for (int col=0;col<7;col++)
			{
				if (col==0 && index == 0 ) 
				{
					setLeftColumn(array5x7x7[index].getCol(col));				
				}
				else if (col == 0 && index>0)
				{
					array5x7x7[index-1].setCol(6, array5x7x7[index].getCol(col));
				}
				else
				{
					array5x7x7[index].setCol(col-1, array5x7x7[index].getCol(col));
				}
			}
		
		}
			array5x7x7[array5x7x7.length-1].setCol(6, getRightColumn());		
			ui.updateScreen();
			
	}
	public void moveRight()
	{
		randomizeLeftColumn();
		for (int index=array5x7x7.length-1;index>=0;index--)
		{
			for(int col=6;col>=0;col--)
			{
				if (col==6 && index == array5x7x7.length-1)
				{
					setRightColumn(array5x7x7[index].getCol(col));
				}
				else if (col == 6 && index<array5x7x7.length-1)
				{
					array5x7x7[index+1].setCol(0, array5x7x7[index].getCol(col));
				}
				else
				{
					array5x7x7[index].setCol(col+1,array5x7x7[index].getCol(col));
				}
			}
		}
		array5x7x7[0].setCol(0, getLeftColumn());
		ui.updateScreen();
		
	}
	
	public void resetCounters()
	{
		firstTime = true;
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
		if (firstTime) // Första gången jag är här?
		{
			firstTime = false;
			columnCounter =0;
			columnInCharacter =0;
			characterIndex =0;
			inputText = ui.getTextField();
		
		}
		if (inputText.length() > characterIndex)
		{
			charArray = transformCharArray(characters.getChar(inputText.charAt(characterIndex)));
		}
		columnCounter++;
		if ( columnCounter > 6)
		{
			characterIndex++;
			columnCounter = 0;
		}
		for (int index=0;index<array5x7x7.length;index++)
		{
			for(int col=0;col<7;col++)
			{
				if (col == 0 && index == 0)
				{
					setLeftColumn(array5x7x7[index].getCol(col));
				}
				else if (col == 0 && index > 0)
				{
					array5x7x7[index-1].setCol(6,  array5x7x7[index].getCol(col));
				}
				else
				{
					array5x7x7[index].setCol(col-1, array5x7x7[index].getCol(col));
				}
			}
			
		}
		if (columnInCharacter <7)
		{
			array5x7x7[array5x7x7.length-1].setCol(6, charArray.getCol(columnInCharacter));
		}
		columnInCharacter++;
		if (columnInCharacter >6)
		{
			columnInCharacter=0;
		}
		ui.updateScreen();
	}
	public void moveRightText()
	{
		
	
		if (firstTime) // Första gången jag är här?
		{
			firstTime = false;
			columnInCharacter = 6;
			columnCounter = 0;
			characterIndex = 0;
			
			inputText = ui.getTextField();
		}
		if (inputText.length() > characterIndex)
		{
			charArray = transformCharArray(characters.getChar(inputText.charAt(characterIndex)));
			
		}
		columnCounter++;
		if ( columnCounter > 6)
		{
			characterIndex++;
			columnCounter = 0;
		}
		for (int index=array5x7x7.length-1;index>=0;index--)
		{
			for(int col=6;col>=0;col--)
			{
				if (col == 6 && index == array5x7x7.length-1)
				{
					setRightColumn(array5x7x7[index].getCol(col));
				}
				else if( col == 6 && index<array5x7x7.length-1)
				{
					array5x7x7[index+1].setCol(0, array5x7x7[index].getCol(col));
				}
				else
				{
					array5x7x7[index].setCol(col+1, array5x7x7[index].getCol(col));
				}
			}
		}
		if (columnInCharacter >=0)
		{
			array5x7x7[0].setCol(0, charArray.getCol(columnInCharacter));
		}
		columnInCharacter--;
		if (columnInCharacter <0)
		{
			columnInCharacter=6;
		}
		ui.updateScreen();
	
	}
	
	
}
	

	
	






