package com.generalPrograms;

public class GeneralPrograms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//QuickSort();
		
		//int result = factorial(4);
		//System.out.println("Result: "+result);
		
		stringReverse("Test");
	}
	
	public static void QuickSort()
	{
		int[] array = {1,4,3,8,5,9};
		int temp;
		
		for(int i=0;i<array.length;i++)
		{
			for(int j=0;j<array.length;j++)
			{
				if(array[i]>array[j])
				{
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		for(int i=0;i<array.length;i++)
		{
			System.out.println(array[i]);
		}
	}
	
	public static int factorial(int num)
	{
		if(num == 0)
		{
			return 1;
		}
		return num*factorial(num-1);
	}

	public static void stringReverse(String str)
	{
		String result = "";
		for(int i=str.length()-1;i>=0;i--)
		{
			result = result + str.charAt(i);
		}
		System.out.println(result);
	}
}
