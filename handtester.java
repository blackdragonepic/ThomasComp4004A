

import junit.framework.TestCase;
public class handtester extends TestCase {
	public void testFullHouse()
	{
		handSwap swapper = new handSwap();
		
		assertEquals(true, swapper.fullHouse("C2","S2","H2","D5","C2"));
		assertEquals(false, swapper.fullHouse("C2","S6","H2","D5","C2"));
	}
	
	public void testStraight()
	{
		handSwap swapper = new handSwap();
		assertEquals(true, swapper.straight("C2","S3","H4","D5","C6"));
		assertEquals(false, swapper.straight("C2","S3","H4","D5","C7"));
	}
	
	public void testStraightFlush()
	{
		handSwap swapper = new handSwap();
		assertEquals(true, swapper.straightFlush("C2","C3","C4","C5","C6"));
		assertEquals(false, swapper.straightFlush("C2","S3","H4","D5","C7"));
		assertEquals(false, swapper.straightFlush("C2","S3","H4","D5","C6"));
	}
	
	public void testFlush()
	{
		handSwap swapper = new handSwap();
		assertEquals(true, swapper.flush("C2","C3","C4","C5","C6"));
		assertEquals(false, swapper.flush("C2","S3","H4","D5","C7"));
	}
	
	
	
}
