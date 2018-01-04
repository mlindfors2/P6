package moment2;

import java.util.Random;


public class Controller
{
	private TestUI2 ui;
	private Array7x7 array;
	private Array7 leftColumn;
	private Array7 bottomRow;
	public int index1 = 0;
	
	public Controller()
	{
		array = new Array7x7();
		ui = new TestUI2();
		leftColumn = new Array7();
		bottomRow = new Array7();
	
	}
	public Controller(TestUI2 indata)
	{
		array = new Array7x7();
		this.ui = indata;
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
}
	




	
	
	
	
	






