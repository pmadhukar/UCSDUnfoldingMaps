package myTest;

import processing.core.PApplet;

public class TestSplit extends PApplet{

	public void splitText() {
		String[] rows = loadStrings("testSplit");
		//System.out.println(rows[0]);

		for( String row : rows){
			String[] columns = row.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
			System.out.println("Length of columns array: " + columns.length);
			for( int i=0; i<columns.length; i++){
				System.out.println((i+1) + ". " + columns[i]);
			}
			System.out.println("End of line");
			System.out.println("\n\n\n");
		}

	}

	public static void main(String[] args) {
		TestSplit test = new TestSplit();
		test.splitText();
	}

}
