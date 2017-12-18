package p6mikael;

import java.util.Random;

public class Controller
{
	private Test1UI ui;
	private Array7x7 array;
	private Array7 leftColumn;
	private Array7 bottomRow;


	public Controller()
	{
		array = new Array7x7();
		ui = new Test1UI();
	
	}
	public Controller(Test1UI indata)
	{
		array = new Array7x7();
		this.ui = indata;
	}
	public Array7x7 getArray7x7()
	{
		return array;
	}
	
	
	public void Randomize()
	{
		Random rand = new Random();
		{
			//array.get
		}
	}
	public void setAllToZero()
	{
		for (int row=0;row<7;row++)
		{
			for(int col=0;col<7;col++)
			{
				array.setElement(row, col, 0);
				ui.updateScreen();
			}
		}
		
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
}