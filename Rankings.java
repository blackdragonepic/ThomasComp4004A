
public class Rankings {
	public int getRank(String s1, String s2, String s3, String s4, String s5){
		handSwap swapper = new handSwap();
		if (swapper.royalFlush(s1, s2, s3, s4, s5))
			return 1;
		if (swapper.straightFlush(s1, s2, s3, s4, s5))
			return 2;
		if (swapper.fourOfAKind(s1, s2, s3, s4, s5))
			return 3;
		if (swapper.fullHouse(s1, s2, s3, s4, s5))
			return 4;
		if (swapper.flush(s1, s2, s3, s4, s5))
			return 5;
		if (swapper.straight(s1, s2, s3, s4, s5))
			return 6;
		if (swapper.threeOfAKind(s1, s2, s3, s4, s5))
			return 7;
		if (swapper.twoPairs(s1, s2, s3, s4, s5))
			return 8;
		if (swapper.onePair(s1, s2, s3, s4, s5))
			return 9;
		return 10;
	}
	
	public int Winner(String[] hand1, String[] hand2){
		handSwap swapper =new handSwap();
		int rank1=getRank(hand1[0],hand1[1],hand1[2],hand1[3],hand1[4]);
		int rank2=getRank(hand2[0],hand2[1],hand2[2],hand2[3],hand2[4]);
		if (rank1==rank2) {
			if (swapper.royalFlush(hand1[0],hand1[1],hand1[2],hand1[3],hand1[4]))
			{
				
			}
		}
		return 0;
	}
}
