

import junit.framework.TestCase;
public class handtester extends TestCase {
	public void fullHouseTester()
	{
		handSwap swapper = new handSwap();
		
		assertEquals(true, swapper.fullHouse(2,2));
	}

}
