

import java.util.Arrays;

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
		assertEquals(true, swapper.flush("C2","C3","C4","C10","C9"));
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
	
	public void testOneAwayFourOfAKind()
	{
		handSwap swapper = new handSwap();
		assertEquals(true, swapper.oneAwayFourOfAKind("C2","H2","D2","S3","C6"));
		assertEquals(false, swapper.oneAwayFourOfAKind("C2","S2","H4","D5","C7"));
	}
	
	public void testOneAwayRoyalFlush()
	{
		handSwap swapper = new handSwap();
		assertEquals(false, swapper.oneAwayRoyalFlush("C2","C3","C4","C5","C6"));
		assertEquals(false, swapper.oneAwayRoyalFlush("C10","SJ","HQ","DK","CA"));
		assertEquals(true, swapper.oneAwayRoyalFlush("H10","HJ","HQ","HK","DA"));
		
		assertEquals(true, swapper.oneAwayRoyalFlush("H10","HJ","HQ","HK","H3"));
	}

	public void testOneAwayFlush()
	{
		handSwap swapper = new handSwap();
		assertEquals(true, swapper.oneAwayFlush("C2","C3","C4","C5","H7"));
		assertEquals(false, swapper.oneAwayFlush("C2","S3","H4","D5","C7"));
	}
	
	public void testOneAwayStraightFlush()
	{
		handSwap swapper = new handSwap();
		assertEquals(true, swapper.oneAwayStraightFlush("C2","C3","C4","C5","C7"));
		assertEquals(false, swapper.oneAwayStraightFlush("C2","C3","C4","C5","D6"));//
		assertEquals(false, swapper.oneAwayStraightFlush("C2","S3","H4","D5","C7"));
		assertEquals(false, swapper.oneAwayStraightFlush("C2","S3","H4","D5","C6"));
	}
	
	public void testOneAwayStraight()
	{
		handSwap swapper = new handSwap();
		assertEquals(true, swapper.oneAwayStraight("C2","S3","H4","D5","C7"));
		assertEquals(false, swapper.oneAwayStraight("C2","S3","H4","D8","C7"));//swapper.swap("C2","S2","H10","D5","C6")
		assertEquals(false, swapper.oneAwayStraight("C2","S2","H10","D5","C6"));
	}
	
	public void testOneAwayFullHouse()
	{
		handSwap swapper = new handSwap();
		
		assertEquals(true, swapper.oneAwayFullHouse("C2","S2","H2","D5","C6"));
		assertEquals(true, swapper.oneAwayFullHouse("C2","S6","H2","D5","C5"));
		assertEquals(false, swapper.oneAwayFullHouse("C2","S6","H2","D4","C5"));
	}
	
	public void testThreeOfTheSameSuit()
	{
		handSwap swapper = new handSwap();
		assertEquals(true, swapper.threeOfTheSameSuit("C2","C3","C10","D7","H6"));
		assertEquals(false, swapper.threeOfTheSameSuit("C2","C3","C10","D7","C6"));
		assertEquals(false, swapper.threeOfTheSameSuit("C2","S6","H2","D4","C5"));
	}
	
	public void testThreeCardsInSequence()
	{
		handSwap swapper = new handSwap();
		
		assertEquals(true, swapper.threeCardsInSequence("C2","S3","H4","D10","C9"));
		assertEquals(false, swapper.threeCardsInSequence("C2","S3","H8","D6","C5"));
		assertEquals(false, swapper.threeCardsInSequence("C2","S3","H4","D7","C5"));
	}
	
	public void testOnePair()
	{
		handSwap swapper = new handSwap();
		
		assertEquals(true, swapper.onePair("C2","S2","H10","D5","C6"));
		assertEquals(false, swapper.onePair("C2","S10","H8","D4","C5"));
	}

	public void testSwapTester()
	{
		handSwap swapper = new handSwap();
		int[] result=new int[]{0,0,0,0,0};
		assertTrue(Arrays.equals(result, swapper.swap("C2","S2","H2","D5","C5")));
		assertTrue(Arrays.equals(result, swapper.swap("C2","S3","H4","D5","C6")));
		assertTrue(Arrays.equals(result, swapper.swap("C2","C3","C4","C5","C6")));
		assertTrue(Arrays.equals(result, swapper.swap("C2","C3","C4","C10","C9")));
		assertTrue(Arrays.equals(result, swapper.swap("C2","H2","D2","S2","C6")));
		assertTrue(Arrays.equals(result, swapper.swap("H10","HJ","HQ","HK","HA")));
		
		result[3]=1;
		//assertTrue(Arrays.equals(result, swapper.swap("C2","H2","D2","S3","C6")));//one away from 4 of a kind
		result[3]=0;
		result[4]=1;
		assertTrue(Arrays.equals(result, swapper.swap("H10","HJ","HQ","HK","D7")));

		assertTrue(Arrays.equals(result, swapper.swap("C2","C3","C4","C5","H7")));//flush		
		
		assertTrue(Arrays.equals(result, swapper.swap("C2","C3","C4","C5","D7")));//straight flush
		assertTrue(Arrays.equals(result, swapper.swap("C2","S3","H4","D5","C8")));//straight

		result[3]=1;

		assertTrue(Arrays.equals(result, swapper.swap("C2","S2","H2","D5","C6")));//fullhouse

		assertTrue(Arrays.equals(result, swapper.swap("C2","C3","C10","D7","H6")));
		
		assertTrue(Arrays.equals(result, swapper.swap("C2","S3","H4","D10","C9")));
		result[2]=1;
		assertTrue(Arrays.equals(result, swapper.swap("C2","S2","H10","D5","C6")));
		assertTrue(Arrays.equals(result, swapper.swap("CQ","SK","H10","D5","C6")));
		
	}

	public void testThreeOfAKind()
	{
		handSwap swapper=new handSwap();
		assertEquals(true, swapper.threeOfAKind("C2","S2","H2","D10","CQ"));
		assertEquals(false, swapper.threeOfAKind("C2","S2","H3","D10","CQ"));
		
	}
	public void testRankings(){
		Rankings ranker = new Rankings();
		assertEquals(1, ranker.getRank("H10","HJ","HQ","HK","HA"));
		assertEquals(3, ranker.getRank("C2","H2","D2","S2","C6"));
		assertEquals(5, ranker.getRank("C2","C3","C4","C10","C9"));
		
		assertEquals(2, ranker.getRank("C2","C3","C4","C5","C6"));
		assertEquals(6, ranker.getRank("C2","S3","H4","D5","C6"));
		assertEquals(4, ranker.getRank("C2","S2","H2","D5","C5"));
		

		assertEquals(7, ranker.getRank("C2","S2","H2","D10","CQ"));
		assertEquals(8, ranker.getRank("C2","S2","H10","D10","CQ"));

		assertEquals(9, ranker.getRank("C2","S2","H11","D10","CQ"));
	}
}
