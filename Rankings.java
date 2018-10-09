import java.util.Arrays;

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
			if (rank1==1)
			{
				if (swapper.suitRank(hand1[0])<swapper.suitRank(hand2[0]))
					return 1;
				return 0;
			}
			else if (rank1==2)
			{
				int[] cardRank1=new int[5];
				cardRank1[0]=swapper.getRank(hand1[0]);
				cardRank1[1]=swapper.getRank(hand1[1]);
				cardRank1[2]=swapper.getRank(hand1[2]);
				cardRank1[3]=swapper.getRank(hand1[3]);
				cardRank1[4]=swapper.getRank(hand1[4]);
				int[] cardRank2=new int[5];
				cardRank2[0]=swapper.getRank(hand2[0]);
				cardRank2[1]=swapper.getRank(hand2[1]);
				cardRank2[2]=swapper.getRank(hand2[2]);
				cardRank2[3]=swapper.getRank(hand2[3]);
				cardRank2[4]=swapper.getRank(hand2[4]);
				Arrays.sort(cardRank1);
				Arrays.sort(cardRank2);
				if (cardRank1[4]<cardRank2[4])
				{
					return 1;
				}
				else if (cardRank1[4]>cardRank2[4])
				{
					return 0;
				}
				if (swapper.suitRank(hand1[0])<swapper.suitRank(hand2[0]))
					return 1;
				return 0;
			}
			else if (rank1==3)
			{
				int high1=0;
				int high2=0;
				if (swapper.getRank(hand1[0])==swapper.getRank(hand1[1]))
				{
					high1=swapper.getRank(hand1[0]);
				}
				else
				{
					high1=swapper.getRank(hand1[2]);
				}
				if (swapper.getRank(hand2[0])==swapper.getRank(hand2[1]))
				{
					high2=swapper.getRank(hand2[0]);
				}
				else
				{
					high2=swapper.getRank(hand2[2]);
				}
				if (high1<high2)
					return 1;
				return 0;
			}
			else if (rank1==4)
			{
				int[] cardRank1=new int[5];
				cardRank1[0]=swapper.getRank(hand1[0]);
				cardRank1[1]=swapper.getRank(hand1[1]);
				cardRank1[2]=swapper.getRank(hand1[2]);
				cardRank1[3]=swapper.getRank(hand1[3]);
				cardRank1[4]=swapper.getRank(hand1[4]);
				int[] cardRank2=new int[5];
				cardRank2[0]=swapper.getRank(hand2[0]);
				cardRank2[1]=swapper.getRank(hand2[1]);
				cardRank2[2]=swapper.getRank(hand2[2]);
				cardRank2[3]=swapper.getRank(hand2[3]);
				cardRank2[4]=swapper.getRank(hand2[4]);
				int[] ranks=new int[14];
				int high1=0;
				int high2=0;
				for (int i=0;i<5;i++)
				{
					ranks[cardRank1[i]-1]++;
				}
				for (int i=0;i<14;i++)
				{
					if (ranks[i]==3)
					{
						high1=i+1;
					}
					ranks[i]=0;
				}
				//hand2
				for (int i=0;i<5;i++)
				{
					ranks[cardRank2[i]-1]++;
				}
				for (int i=0;i<14;i++)
				{
					if (ranks[i]==3)
					{
						high2=i+1;
					}
					ranks[i]=0;
				}
				if (high1<high2)
					return 1;
				return 0;
			}
			else if (rank1==5)
			{
				int[] cardRank1=new int[5];
				cardRank1[0]=swapper.getRank(hand1[0]);
				cardRank1[1]=swapper.getRank(hand1[1]);
				cardRank1[2]=swapper.getRank(hand1[2]);
				cardRank1[3]=swapper.getRank(hand1[3]);
				cardRank1[4]=swapper.getRank(hand1[4]);
				int[] cardRank2=new int[5];
				cardRank2[0]=swapper.getRank(hand2[0]);
				cardRank2[1]=swapper.getRank(hand2[1]);
				cardRank2[2]=swapper.getRank(hand2[2]);
				cardRank2[3]=swapper.getRank(hand2[3]);
				cardRank2[4]=swapper.getRank(hand2[4]);
				Arrays.sort(cardRank1);
				Arrays.sort(cardRank2);
				for (int i=4;i>=0;i--)
				{
					if (cardRank1[i]<cardRank2[i])
						return 1;
					else if (cardRank1[i]>cardRank2[i])
						return 0;
				}
				if (swapper.suitRank(hand1[0])<swapper.suitRank(hand2[0]))
					return 1;
				return 0;
			}
			else if (rank1==6)
			{
				int[] cardRank1=new int[5];
				cardRank1[0]=swapper.getRank(hand1[0]);
				cardRank1[1]=swapper.getRank(hand1[1]);
				cardRank1[2]=swapper.getRank(hand1[2]);
				cardRank1[3]=swapper.getRank(hand1[3]);
				cardRank1[4]=swapper.getRank(hand1[4]);
				int[] cardRank2=new int[5];
				cardRank2[0]=swapper.getRank(hand2[0]);
				cardRank2[1]=swapper.getRank(hand2[1]);
				cardRank2[2]=swapper.getRank(hand2[2]);
				cardRank2[3]=swapper.getRank(hand2[3]);
				cardRank2[4]=swapper.getRank(hand2[4]);
				int[] sort1 =cardRank1.clone();
				int[] sort2 =cardRank2.clone();
				Arrays.sort(sort1);
				Arrays.sort(sort2);
				if (sort1[4]<sort2[4])
					return 1;
				else if (sort1[4]>sort2[4])
					return 0;
				int suit1=0;
				int suit2=0;
				for (int i=0;i<5;i++)
				{
					if (cardRank1[i]==sort1[4])
						suit1=swapper.suitRank(hand1[i]);
					if (cardRank2[i]==sort2[4])
						suit2=swapper.suitRank(hand2[i]);
				}
				if (suit1<suit2)
					return 1;
				return 0;
				
			}
		}
		return 0;
	}
}
