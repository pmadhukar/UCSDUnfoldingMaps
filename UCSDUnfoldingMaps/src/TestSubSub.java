
public class TestSubSub extends TestSub{
	public static void main( String[] args ) {
		TestSuper test = new TestSubSub();
		TestSuper test2 = test;
		System.out.println("test: " + test + ", test2: " + test2);
	}
}
