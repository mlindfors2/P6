package moment2;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class Controller
{
	private TestUI2 ui;
	private Array7x7 array;
	private Array7 leftColumn;
	private Array7 bottomRow;
	private Chars characters;
//	private Timer timer = new Timer();
	Array7x7 charArray = new Array7x7();
	public int index1 = 0;
	
	public Controller()
	{
		array = new Array7x7();
		ui = new TestUI2();
		characters = new Chars();
		leftColumn = new Array7();
		bottomRow = new Array7();
	
	}
	public Controller(TestUI2 indata)
	{
		array = new Array7x7();
		this.ui = indata;
		characters = new Chars();
		leftColumn = new Array7();
		bottomRow = new Array7();
	}
	public Array7x7 getArray7x7()
	{
		return array;
	}
	public Array7 getLeftColumn()
	{
		return leftColumn;
	}
	public Array7 getBottomRow()
	{
		return bottomRow;
	}
	public void setLeftColumn(Array7 leftColumn)
	{
		this.leftColumn = leftColumn;
	}
	public void setBottomRow(Array7 bottomRow)
	{
		this.bottomRow = bottomRow;
	}
	public void Randomize()
	{
		Random rand = new Random();
		{
			for (int row=0;row<7;row++)
			{
				for(int col=0;col<7;col++)
				{
					array.setElement(row,  col,  rand.nextInt(100)+1);
					
				}
			}
			ui.updateScreen();
		}
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
		for(int col=1;col<7;col++)
		{
			array.setCol(col-1, array.getCol(col));
		}		
		ui.updateScreen();
	}
	
	public void moveRight()
	{
		for(int col=6;col>=0;col--)
		{
			array.setCol(col+1,  array.getCol(col));
		}
		ui.updateScreen();
	}
	
	public void StringToScreen(String text) 
	{
		
		for(int index=0;index<text.length();index++)
		{
			char character = text.charAt(index);
						
			charArray = characters.getChar(character);
			
			
			for (int i=0;i<7;i++)
			{
				try {
					moveLeft();
					array.setCol(6, charArray.getCol(i));
					ui.updateScreen();
					Thread.sleep(40);
				} catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
				}	
				
			}
		
			
		}
	}
	public void CharToScreen(char chr)	{
		
		
		
		
			
		
	}
	private class ToDo extends TimerTask
	{

		
		public void run()
		{
				moveLeft();
				System.out.println(index1);
				index1++;
		
			
		}
		
	}

	}


	
	
	
	
	






