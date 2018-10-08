

import junit.framework.TestCase;
public class handtester extends TestCase {
	public void testFullHouse()
	{
		handSwap swapper = new handSwap();
		
		assertEquals(true, swapper.fullHouse("C2","S2","H2","D5","C5"));
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
	
	public void testFourOfAKind()
	{
		handSwap swapper = new handSwap();
		assertEquals(true, swapper.fourOfAKind("C2","H2","D2","S2","C6"));
		assertEquals(false, swapper.fourOfAKind("C2","S3","H4","D5","C7"));
	}
	public void testGetRank()
	{
		handSwap swapper = new handSwap();
		assertEquals(14, swapper.getRank("HA"));
		assertEquals(2, swapper.getRank("C2"));
		assertEquals(10, swapper.getRank("C10"));
		assertEquals(11, swapper.getRank("CJ"));
		assertEquals(12, swapper.getRank("CQ"));
		assertEquals(13, swapper.getRank("CK"));
		
	}
	
	public void testRoyalFlush()
	{
		handSwap swapper = new handSwap();
		assertEquals(false, swapper.royalFlush("C2","C3","C4","C5","C6"));
		assertEquals(false, swapper.royalFlush("C10","SJ","HQ","DK","CA"));
		assertEquals(true, swapper.royalFlush("H10","HJ","HQ","HK","HA"));
	}
	
}
