package moment3;

import java.util.Random;

public class Array7x7
{
	private Array7[] array7;

	public Array7x7()
	{
		this.array7 = new Array7[7];
		for(int i=0;i<7;i++)
		{
			array7[i] = new Array7();
		}
	}

	public Array7x7(Array7[] array7)
	{
		this.array7 = array7;
	}

	public Array7x7(int[][] array)
	{
		this.array7 = new Array7[7];
		
		for(int i=0;i<array7.length;i++)
		{
			array7[i] = new Array7();
			for(int j=0;j<array7.length;j++)
			{
				array7[i].setElement(j, array[i][j]);
			}
		}
		
	}

	// ***********************************************************
	public void setElement(int row, int col, int value)
	{
//		INTE ANROPAS HELA TIDEN
		array7[row].setElement(col, value);
	}

	public int getElement(int row, int col)
	{
		return array7[row].getElement(col);
	}
	public void setRow(int row, Array7 theRow)
	{
		array7[row].setArray(theRow);
	}
	public Array7 getRow(int row)
	{
		return array7[row];
	}
//	Tveksam
	public void setCol(int col, Array7 theCol)
	{
		for(int i=0;i<array7.length;i++)
		{
			array7[i].setElement(col, theCol.getElement(i));
		}
	}
//	Tveksam
	public Array7 getCol(int col)
	{
		Array7 newArray = new Array7();
		for (int row=0;row<array7.length;row++)
		{
//			int abarray = array7[row].getElement(col);
//			newArray.setElement(row, abarray);
			newArray.setElement(row,array7[row].getElement(col));
		}
		return newArray;
	}
//Tveksam
	public void setArray(Array7x7 array7x7)
	{
		for (int i=0;i<array7.length;i++)
		{
			array7[i].setArray(array7x7.getRow(i));
		}
		
	}
	public void setArray(int[][] array)
	{
		for(int i=0;i<array7.length;i++)
		{
			array7[i].setArray(array[i]);
		}
	}
//	Extremt tveksam
	public Array7x7 getArray()
	{
		Array7x7 newArray7 = new Array7x7();
		for(int i=0;i<array7.length;i++)
		{
			newArray7.setRow(i, array7[i].getArray());
		}
		return newArray7;
	}
	public int[][] toIntArray()
	{
		int[][] newArray7x7 = new int[7][7];
		for(int i=0;i<array7.length;i++)
		{
			for(int j=0;j<array7.length;j++)
			{
				newArray7x7[i][j] = array7[i].getElement(j);
			}
			
		}
		return newArray7x7;
	}
		
	
}

