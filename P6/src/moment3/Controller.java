package moment3;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;




public class Controller
{
	private TestUI3 ui;
	private Array7x7 array;
	private Array7 leftColumn;
	private Array7 rightColumn;
	
	
	public Controller()
	{
		array = new Array7x7();
		ui = new TestUI3();
		leftColumn = new Array7();
		rightColumn = new Array7();
	
	}
	public Controller(TestUI3 indata)
	{
		array = new Array7x7();
		this.ui = indata;
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
}


	
	
	
	
	






