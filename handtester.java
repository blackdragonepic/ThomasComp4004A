

import java.util.Arrays;

import junit.framework.TestCase;
public class handtester extends TestCase {
	public void testFullHouse()
	{
		handSwap swapper = new handSwap();
		
		assertEquals(true, swapper.fullHouse("C2","S2","H2","D5","C5"));
		assertEquals(true, swapper.fullHouse("C2","S2","C5","D5","H2"));
		assertEquals(false, swapper.fullHouse("C2","S6","H2","D5","C2"));
	}
	
	public void testStraight()
	{
		handSwap swapper = new handSwap();
		assertEquals(true, swapper.straight("C2","S3","H4","D5","C6"));
		assertEquals(true, swapper.straight("C2","S3","H4","C6","D5"));
		assertEquals(false, swapper.straight("C2","S3","H4","D5","C7"));
	}
	
	public void testStraightFlush()
	{
		handSwap swapper = new handSwap();
		assertEquals(true, swapper.straightFlush("C2","C3","C4","C5","C6"));
		assertEquals(true, swapper.straightFlush("C2","C4","C3","C6","C5"));
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
		assertEquals(true, swapper.fourOfAKind("C2","H2","D2","C6","S2"));
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
		assertEquals(true, swapper.royalFlush("HJ","H10","HK","HQ","HA"));
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
		/*
		 * 	
		assertTrue(Arrays.equals(new int[]{0,0,0,0,0}, swapper.swap("C2","S2","H2","D5","C5")));
		assertTrue(Arrays.equals(new int[]{0,0,0,0,0}, swapper.swap("C2","S3","H4","D5","C6")));
		assertTrue(Arrays.equals(new int[]{0,0,0,0,0}, swapper.swap("C2","C3","C4","C5","C6")));
		assertTrue(Arrays.equals(new int[]{0,0,0,0,0}, swapper.swap("C2","C3","C4","C10","C9")));
		assertTrue(Arrays.equals(new int[]{0,0,0,0,0}, swapper.swap("C2","H2","D2","S2","C6")));
		assertTrue(Arrays.equals(new int[]{0,0,0,0,0}, swapper.swap("H10","HJ","HQ","HK","HA")));
		 */
		
		result[3]=1;
		//assertTrue(Arrays.equals(result, swapper.swap("C2","H2","D2","S3","C6")));//one away from 4 of a kind
		result[3]=0;
		result[4]=1;
		assertTrue(Arrays.equals(result, swapper.swap("H10","HJ","HQ","HK","D7")));
;
		assertTrue(Arrays.equals(result, swapper.swap("C2","C3","C4","C10","H7")));//flush		
		
		assertTrue(Arrays.equals(result, swapper.swap("C2","C3","C4","C5","D7")));//straight flush
		assertTrue(Arrays.equals(result, swapper.swap("C2","S3","H4","D5","C8")));//straight

		result[3]=1;

		assertTrue(Arrays.equals(result, swapper.swap("C2","S2","H2","D5","C6")));//fullhouse
		//assertTrue(Arrays.equals(new int[]{0,0,1,1,1}, swapper.swap("CQ","SK","H10","D5","C6")))
		assertTrue(Arrays.equals(result, swapper.swap("C2","C3","C10","D7","H6")));
		
		assertTrue(Arrays.equals(result, swapper.swap("C2","S3","H4","D10","C9")));
		result[2]=1;
		assertTrue(Arrays.equals(result, swapper.swap("C2","S2","H10","D5","C6")));
		assertTrue(Arrays.equals(result, swapper.swap("CQ","SK","H10","D5","C6")));
		result[2]=0;
		result[3]=0;
		assertTrue(Arrays.equals(result, swapper.swap("C2","D2", "S4", "H4", "H8")));//C2 D2 S4 H4 H8
	}

	public void testThreeOfAKind()
	{
		handSwap swapper=new handSwap();
		assertEquals(true, swapper.threeOfAKind("C2","S2","H2","D10","CQ"));
		assertEquals(false, swapper.threeOfAKind("C2","S2","H2","D2","CQ"));
		assertEquals(false, swapper.threeOfAKind("C2","S2","H3","D10","CQ"));
		
	}
	
	public void testSuitRank()
	{
		handSwap swapper=new handSwap();
		assertEquals(4, swapper.suitRank("S3"));
		assertEquals(1, swapper.suitRank("C2"));
		assertEquals(3, swapper.suitRank("H4"));
		assertEquals(2, swapper.suitRank("D4"));
	}
	
	public void testTwoPairs(){
		handSwap swapper=new handSwap();
		assertEquals(true, swapper.twoPairs("C2","S2","H10","D10","CQ"));
		assertEquals(false, swapper.twoPairs("C2","S2","H3","D10","CQ"));
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

		assertEquals(9, ranker.getRank("C2","S2","HJ","D10","CQ"));
		assertEquals(10, ranker.getRank("C2","S3","HJ","D10","CQ"));
	}
	
	
	public void testWinner(){
		Rankings rank=new Rankings();
		String[] hand1=new String[]{"H10","HJ","HQ","HK","HA"};//royal flush
		String[] hand2=new String[]{"S10","SJ","SQ","SK","SA"};
		assertEquals(1,rank.Winner(hand1,hand2));
		
		
		hand1=new String[]{"H3","H4","H5","H6","H7"};
		hand2=new String[]{"S10","SJ","SQ","SK","S9"};
		assertEquals(1,rank.Winner(hand1,hand2));
		hand1=new String[]{"H3","H4","H5","H6","H7"};//straight flush
		hand2=new String[]{"S3","S4","S5","S6","S7"};
		assertEquals(1,rank.Winner(hand1,hand2));
		
		hand1=new String[]{"H3","S3","D3","C3","H7"};//four of a kind;
		hand2=new String[]{"H5","S5","D5","C5","D7"};
		assertEquals(1,rank.Winner(hand1,hand2));
		
		
		hand1=new String[]{"H3","S3","D3","C7","H7"};//fullhouse;
		hand2=new String[]{"H5","S5","D5","C8","D8"};
		assertEquals(1,rank.Winner(hand1,hand2));
		
		assertEquals(1,rank.Winner(new String[]{"H2","H4","H5","H6","H7"},new String[]{"S2","S4","S5","S6","S7"}));
		
		hand1=new String[]{"H2","H4","H5","H6","H7"};//flush
		hand2=new String[]{"S2","S4","S5","S6","S7"};
		assertEquals(1,rank.Winner(hand1,hand2));
		hand1=new String[]{"H2","H4","H5","H6","H8"};//flush
		hand2=new String[]{"S2","S4","S5","S6","S7"};
		assertEquals(0,rank.Winner(hand1,hand2));
		
		hand1=new String[]{"H3","H4","H5","H6","D7"};//straight
		hand2=new String[]{"S3","S4","S5","D6","S7"};
		assertEquals(1,rank.Winner(hand1,hand2));
		hand1=new String[]{"H4","H5","H6","H7","D8"};//straight
		hand2=new String[]{"S3","S4","S5","D6","S7"};
		assertEquals(0,rank.Winner(hand1,hand2));
		
		
		
		hand1=new String[]{"H3","S3","D3","C6","H7"};//three of a kind;
		hand2=new String[]{"H5","S5","D5","C9","D8"};
		assertEquals(1,rank.Winner(hand1,hand2));

		
		hand1=new String[]{"H3","S3","D6","C6","H7"};//2 pairs;
		hand2=new String[]{"H5","S5","D4","C4","D7"};
		assertEquals(0,rank.Winner(hand1,hand2));
		hand1=new String[]{"H3","S3","D6","C6","H7"};//2 pairs;
		hand2=new String[]{"H5","S5","S6","H6","D7"};
		assertEquals(1,rank.Winner(hand1,hand2));
		hand1=new String[]{"H3","S3","D6","C6","H7"};//2 pairs;
		hand2=new String[]{"C3","D3","S6","H6","D7"};//
		assertEquals(0,rank.Winner(hand1,hand2));
		
		hand1=new String[]{"H3","S3","D6","C8","H7"};//1 pairs;
		hand2=new String[]{"H5","S5","D9","C4","D7"};
		assertEquals(1,rank.Winner(hand1,hand2));
		hand1=new String[]{"H3","S3","D6","C8","H7"};//1 pairs;
		hand2=new String[]{"C3","D3","D9","C4","D7"};
		assertEquals(1,rank.Winner(hand1,hand2));
		hand1=new String[]{"H3","S3","S9","C8","H7"};//1 pairs;
		hand2=new String[]{"C3","D3","D9","C4","D7"};
		assertEquals(0,rank.Winner(hand1,hand2));
		
		
		
		hand1=new String[]{"H3","S4","D6","C8","H7"};//high card;
		hand2=new String[]{"H5","S3","D9","C4","D7"};
		assertEquals(1,rank.Winner(hand1,hand2));
		
		assertEquals(1,rank.Winner(hand1,hand2));
		hand1=new String[]{"H3","S4","D6","S9","H7"};//high card;
		hand2=new String[]{"H5","S3","D9","C4","D7"};
		assertEquals(0,rank.Winner(hand1,hand2));
		
		
		
	}

    public void testInde(){
    	Rankings rank = new Rankings();
    	assertEquals(rank.getRank("S10", "SJ", "SQ","SK","SA"),rank.getRank("H10", "HJ", "HQ","HK" ,"HA"));	
    }
}
