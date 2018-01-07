package moment4;

import java.util.Random;

public class Array7
{
	private int[] array;
	protected static final int ARRAY_SIZE = 7;
	
	public Array7()
	{
		this(new int [ARRAY_SIZE]);
	}
	public Array7(int[] array)
	{
		this.array = array;
	}
	public Array7(Array7 array)
	{
		this(array.toIntArray());
	}
	
	//	****************************************************************************
	public void setElement(int pos, int value)
	{
		array[pos] = value;
	}
	public int getElement(int pos)
	{
		return array[pos];
	}
	public void setArray(Array7 array7)
	{
		this.array = array7.toIntArray();
	}
	public void setArray(int[] array)
	{
		this.array = array;
	}

	public Array7 getArray()
	{
		Array7 newArray = new Array7();
		for(int col=0;col<array.length;col++)
		{
			newArray.setElement(col, this.getElement(col));
		}
		return newArray;
	}
	public int[] toIntArray()
	{
		int[] newArray = new int[array.length];
		for(int col=0;col<array.length;col++)
		{
			newArray[col] = array[col];
		}
		return newArray;
	}
}

