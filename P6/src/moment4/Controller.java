package moment4;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;




public class Controller
{
	private TestUI4 ui;
	private Array7x7 array;
	private Array7 leftColumn;
	private Array7 rightColumn;
	private Chars characters;
//	private Timer timer = new Timer();
	Array7x7 charArray = new Array7x7();
	public int index1 = 0;
	Random rand = new Random();
	public Controller()
	{
		array = new Array7x7();
		ui = new TestUI4();
		characters = new Chars();
		leftColumn = new Array7();
		rightColumn = new Array7();
	
	}
	public Controller(TestUI4 indata)
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
		
		{
			for (int row=0;row<7;row++)
			{
				leftColumn.setElement(row, Color.argb(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
				rightColumn.setElement(row, Color.argb(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
				for(int col=0;col<7;col++)
				{
					array.setElement(row,  col, Color.argb(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));  
							
					
					
					 
				}
			}
			ui.updateScreen();
		}
	}
	public void randomizeLeftColumn()
	{
		for (int row=0;row<7;row++)
		{
			leftColumn.setElement(row, Color.argb(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
		}
		ui.updateScreen();
	}
	public void randomizeRightColumn()
	{
		for(int row=0;row<7;row++)
		{
			rightColumn.setElement(row, Color.argb(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
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
		for (int col=0;col<7;col++)
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
		setRightColumn(ui.readRightColumn());
		array.setCol(6, getRightColumn());
		ui.updateScreen();
	}
	
	public void moveRight()
	{
		randomizeLeftColumn();
		for(int col=6;col>=0;col--)
		{
			if (col==6)
			{
				setRightColumn(array.getCol(col));
			}
			else
			{
				array.setCol(col+1,  array.getCol(col));
			}
		}
		setLeftColumn(ui.readLeftColumn());
		array.setCol(0, ui.readLeftColumn());
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


	
	
	
	
	






