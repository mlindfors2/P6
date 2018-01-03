package moment2;

import java.util.Random;

public class Array7
{
	private int[] array;
	
	public Array7()
	{
		this(new int [7]);
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
	
		for (int col=0;col<this.array.length;col++)
		{
			this.array[col] = array7.getElement(col);
		}
	
	}
	public void setArray(int[] array)
	{
		this.array = array;
	}
//	Tveksamt om den funkar, testa i debug
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

