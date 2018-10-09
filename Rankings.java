
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
		
	}
}
