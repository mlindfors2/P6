package moment4;


public class Array7x7
{
	private Array7[] array7;
	protected static final int ARRAY_SIZE = 7;

	public Array7x7()
	{
		this.array7 = new Array7[ARRAY_SIZE];
		for(int i=0;i<ARRAY_SIZE;i++)
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
		this.array7 = new Array7[ARRAY_SIZE];
		
		for(int row=0;row<array7.length;row++)
		{
			array7[row] = new Array7();
			for(int col=0;col<array7.length;col++)
			{
				array7[row].setElement(col, array[row][col]);
			}
		}
		
	}

	// ***********************************************************
	public void setElement(int row, int col, int value)
	{
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
	public void setCol(int col, Array7 theCol)
	{
		for(int row=0;row<array7.length;row++)
		{
			array7[row].setElement(col, theCol.getElement(row));
		}
	}
	public Array7 getCol(int col)
	{
		Array7 newArray = new Array7();
		for (int row=0;row<array7.length;row++)
		{
			newArray.setElement(row,array7[row].getElement(col));
		}
		return newArray;
	}

	public void setArray(Array7x7 array7x7)
	{
		for (int row=0;row<array7.length;row++)
		{
			array7[row].setArray(array7x7.getRow(row));
		}
		
	}
	public void setArray(int[][] array)
	{
		for(int row=0;row<array7.length;row++)
		{
			array7[row].setArray(array[row]);
		}
	}
	public Array7x7 getArray()
	{
		Array7x7 newArray7 = new Array7x7();
		for(int row=0;row<array7.length;row++)
		{
			newArray7.setRow(row, array7[row].getArray());
		}
		return newArray7;
	}
	public int[][] toIntArray()
	{
		int[][] newArray7x7 = new int[ARRAY_SIZE][ARRAY_SIZE];
		for(int row=0;row<array7.length;row++)
		{
			for(int col=0;col<array7.length;col++)
			{
				newArray7x7[row][col] = array7[row].getElement(col);
			}
		}
		return newArray7x7;
	}
		
	
}

