package p6mikael;

import java.util.Random;

public class Array7
{
	private int[] array7;
	
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
//	****************************************************************************
	public void setElement(int pos, int value)
	{
		array7[pos] = value;
	}
	public int getElement(int pos)
	{
		return array7[pos];
	}
	public void setArray(Array7 array7)
	{
		for (int i=0;i<this.array7.length;i++)
		{
			this.array7[i] = array7.getElement(i);
		}
	}
	public void setArray(int[] array)
	{
		this.array7 = array;
	}
//	Tveksamt om den funkar, testa i debug
	public Array7 getArray()
	{
		Array7 newArray = new Array7();
		for(int i=0;i<array7.length;i++)
		{
			newArray.setElement(i, this.getElement(i));
		}
		return newArray;
	}
	public int[] toIntArray()
	{
		int[] newArray = new int[array7.length];
		for(int i=0;i<array7.length;i++)
		{
			newArray[i] = array7[i];
		}
		return newArray;
	}
}

