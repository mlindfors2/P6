package p6mikael;

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
	
	/*
	public Array7()
	{
		array7 = new int[7];

	}
	public Array7(Array7 array7)
	{
		for(int i=0;i<this.array7.length;i++)
		{
			this.array7[i] = array7.getElement(i);
		}
	}
	public Array7(int[] array)
	{
		this.array7 = array;
	}
	*/
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
		for (int i=0;i<this.array.length;i++)
		{
			this.array[i] = array7.getElement(i);
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
		for(int i=0;i<array.length;i++)
		{
			newArray.setElement(i, this.getElement(i));
		}
		return newArray;
	}
	public int[] toIntArray()
	{
		int[] newArray = new int[array.length];
		for(int i=0;i<array.length;i++)
		{
			newArray[i] = array[i];
		}
		return newArray;
	}
}

