package myTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class MyClass implements Comparable{
	int a;

	/*
	 * This compareTo method will cause
	 * sorting in descending order.
	 */
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if( this.a < ((MyClass)o).a ) {
			return 1; //if this returns -1
		}
		else if( this.a > ((MyClass)o).a ) {
			return -1; //and this returns 1, then sorts in ascending order
		}
		else return 0;
	}



}

public class SortTest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);


		List<MyClass> myList = new ArrayList<MyClass>();
		for( int i=0; i<9; i++ ) {
			MyClass obj = new MyClass();

			System.out.println("Enter a: ");
			obj.a = in.nextInt();

			myList.add(obj);
		}

		/*
		display(myList);
		Collections.sort(myList);

		display(myList);
		*/

		MyClass[] myArr = new MyClass[myList.size()];
		myArr = myList.toArray( myArr );
		display(myArr);

		Arrays.sort(myArr);
		display(myArr);

		in.close();
	}

	public static void display( List<MyClass> arr ) {
		for( int i=0; i<arr.size(); i++ ) {
			System.out.print(arr.get(i).a + " ");
		}

		System.out.println();
	}

	public static void display( MyClass[] arr ) {
		for( int i=0; i<arr.length; i++ ) {
			System.out.print(arr[i].a + " ");
		}

		System.out.println();
	}
}