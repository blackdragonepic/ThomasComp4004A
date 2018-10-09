import java.lang.reflect.Array;
import java.util.Arrays;
public class handSwap {
	public boolean fullHouse(String s1, String s2, String s3, String s4, String s5)
	{
		int[] rank = new int[5];
		rank[0]=getRank(s1);
		rank[1]=getRank(s2);
		rank[2]=getRank(s3);
		rank[3]=getRank(s4);
		rank[4]=getRank(s5);
		int match1=0;
		for (int i=1;i<5;i++)
		{
			if (rank[0]==rank[i])
				match1++;
		}
		int req=0;
		if (match1==0||match1==3)
			return false;
		if (match1==1)
			req=2;
		else if (match1==2)
			req=1;
		int comp=-1;
		match1=0;
		for (int i=1;i<5;i++)
		{
			if (comp==-1)
			{
				if (rank[0]!=rank[i])
				{
					comp=i;
				}
			}
			else
			{
				if (rank[comp]==rank[i])
					match1++;
			}
		}
		if (match1!=req)
			return false;
		return true;
	}

	public boolean straight(String s1, String s2, String s3, String s4, String s5)
	{
		int[] rank = new int[5];
		rank[0]=getRank(s1);
		rank[1]=getRank(s2);
		rank[2]=getRank(s3);
		rank[3]=getRank(s4);
		rank[4]=getRank(s5);
		int match1=0;
		Arrays.sort(rank);
		for (int i=0;i<4;i++)
		{

			if ((rank[i])+1!=rank[i+1])
				return false;
		}
		return true;
	}

	public boolean straightFlush(String s1, String s2, String s3, String s4, String s5)
	{
		if (!straight(s1,s2,s3,s4,s5))
			return false;
		if (!flush(s1,s2,s3,s4,s5))
			return false;
		return true;
	}

	public boolean flush(String s1, String s2, String s3, String s4, String s5)
	{
		char[] suit = new char[5];
		suit[0]=s1.charAt(0);
		suit[1]=s2.charAt(0);
		suit[2]=s3.charAt(0);
		suit[3]=s4.charAt(0);
		suit[4]=s5.charAt(0);
		for (int i=0;i<4;i++)
		{
			if (suit[i]!=suit[i+1])
				return false;
		}
		return true;
	}

	public boolean fourOfAKind(String s1, String s2, String s3, String s4, String s5)
	{
		int[] rank = new int[5];
		rank[0]=getRank(s1);
		rank[1]=getRank(s2);
		rank[2]=getRank(s3);
		rank[3]=getRank(s4);
		rank[4]=getRank(s5);
		int match1=0;
		for (int i=1;i<5;i++)
		{
			if (rank[0]==rank[i])
				match1++;
		}
		if (match1==3)
			return true;
		match1=0;
		for (int i=2;i<5;i++)
		{
			if (rank[1]==rank[i])
				match1++;
		}
		if (match1==3)
			return true;
		return false;
	}

	public boolean royalFlush(String s1, String s2, String s3, String s4, String s5){
		int[] rank = new int[5];
		rank[0]=getRank(s1);
		rank[1]=getRank(s2);
		rank[2]=getRank(s3);
		rank[3]=getRank(s4);
		rank[4]=getRank(s5);
		Arrays.sort(rank);
		for (int i=0;i<5;i++)
		{
			if (rank[i]!=(i+10))
			{
				return false;
			}
		}
		if (!flush(s1,s2,s3,s4,s5))
			return false;
		return true;
	}

	public int getRank(String s1)
	{
		if (s1.length()==3)
			return 10;
		if (s1.charAt(1)<58)
			return s1.charAt(1)-48;
		if (s1.charAt(1)=='J')
			return 11;
		else if (s1.charAt(1)=='Q')
			return 12;
		else if (s1.charAt(1)=='K')
			return 13;
		else if (s1.charAt(1)=='A')
			return 14;
		return -1;
	}


	public boolean oneAwayRoyalFlush(String s1, String s2, String s3, String s4, String s5){
		int[] rank = new int[5];
		rank[0]=getRank(s1);
		rank[1]=getRank(s2);
		rank[2]=getRank(s3);
		rank[3]=getRank(s4);
		rank[4]=getRank(s5);
		char[] suit = new char[5];
		suit[0]=s1.charAt(0);
		suit[1]=s2.charAt(0);
		suit[2]=s3.charAt(0);
		suit[3]=s4.charAt(0);
		suit[4]=s5.charAt(0);
		if (suit[0]==suit[1])
		{
			int dif=0;
			int pos=-1;
			for (int i=2;i<5;i++)
			{
				if (suit[0]!=suit[i]){
					dif++;
					pos=i;
				}
			}
			if (dif>1)
				return false;
			if (dif==1)
			{
				for (int i=0;i<5;i++)
				{
					if (i!=pos){
						if (rank[i]<10)
							return false;
					}
				}

			}
			else if (dif==0)
			{
				int check=0;
				for (int i=0;i<5;i++)
				{
					if (rank[i]<10)
						check++;
				}
				if (check>1)
					return false;
			}

		}
		else
		{
			if (suit[0]==suit[2])
			{
				for (int i=2;i<5;i++)
				{
					if (suit[0]!=suit[i])
					{
						return false;
					}
					if (rank[i]<10)
						return false;
				}
				if (rank[0]<10)
					return false;
			}
			else if (suit[1]==suit[2])
			{
				for (int i=1;i<5;i++)
				{
					if (suit[1]!=suit[i])
					{
						return false;
					}
					if (rank[i]<10)
						return false;
				}
			}
			else
			{
				return false;
			}
		}
		return true;
	}

	public boolean oneAwayFourOfAKind(String s1, String s2, String s3, String s4, String s5){
		int[] rank = new int[5];
		rank[0]=getRank(s1);
		rank[1]=getRank(s2);
		rank[2]=getRank(s3);
		rank[3]=getRank(s4);
		rank[4]=getRank(s5);
		int[] ranks=new int[14];
		for (int i=0;i<5;i++)
		{
			ranks[rank[i]-1]++;
		}
		for (int i=0;i<14;i++){
			if (ranks[i]==3) 
				return true;
		}
		return false;
	}

	public boolean oneAwayFlush(String s1, String s2, String s3, String s4, String s5){
		char[] suit = new char[5];
		suit[0]=s1.charAt(0);
		suit[1]=s2.charAt(0);
		suit[2]=s3.charAt(0);
		suit[3]=s4.charAt(0);
		suit[4]=s5.charAt(0);
		int count=0;
		if (suit[0]==suit[1])
		{
			for (int i=2;i<5;i++)
			{
				if (suit[0]!=suit[i])
					count++;
			}
			if (count!=1)
				return false;
		}
		else if (suit[0]==suit[2])
		{
			for (int i=3;i<5;i++)
			{
				if (suit[0]!=suit[i])
					return false;
			}
		}
		else if (suit[1]==suit[2])
		{
			for (int i=3;i<5;i++)
			{
				if (suit[1]!=suit[i])
					return false;
			}
		}
		else
		{
			return false;
		}

		return true;
	}

	public boolean oneAwayStraightFlush(String s1, String s2, String s3, String s4, String s5)
	{
		int[] rank = new int[5];
		rank[0]=getRank(s1);
		rank[1]=getRank(s2);
		rank[2]=getRank(s3);
		rank[3]=getRank(s4);
		rank[4]=getRank(s5);
		char[] suit = new char[5];
		suit[0]=s1.charAt(0);
		suit[1]=s2.charAt(0);
		suit[2]=s3.charAt(0);
		suit[3]=s4.charAt(0);
		suit[4]=s5.charAt(0);
		if (suit[0]==suit[1])
		{
			int dif=0;
			int pos=-1;
			for (int i=2;i<5;i++)
			{
				if (suit[0]!=suit[i]){
					dif++;
					pos=i;
				}
			}
			if (dif>1)
				return false;
			if (dif==1)
			{
				int lowest=20;
				int highest=-1;
				for (int i=0;i<5;i++)
				{
					if (i!=pos){
						if (rank[i]<lowest)
							lowest=rank[i];
						if (rank[i]>highest)
							highest=rank[i];
					}
				}
				if (highest-lowest<5)
					return false;
				else
					return false;
			}
			else if (dif==0)
			{
				Arrays.sort(rank);
				if (rank[4]-rank[0]<5)
					return false;
				else if (rank[3]-rank[0]<5)
					return true;
				else if (rank[4]-rank[1]<5)
					return true;
				else
					return false;
			}

		}
		else
		{
			if (suit[0]==suit[2])
			{
				for (int i=2;i<5;i++)
				{
					if (suit[0]!=suit[i])
					{
						return false;
					}

				}
				Arrays.sort(rank);
				if (rank[4]-rank[0]<5)
					return false;
				else if (rank[3]-rank[0]<5)
					return true;
				else if (rank[4]-rank[1]<5)
					return true;
				else
					return false;
			}
			else if (suit[1]==suit[2])
			{
				for (int i=1;i<5;i++)
				{
					if (suit[1]!=suit[i])
					{
						return false;
					}

				}
				Arrays.sort(rank);
				if (rank[4]-rank[0]<5)
					return false;
				else if (rank[3]-rank[0]<5)
					return true;
				else if (rank[4]-rank[1]<5)
					return true;
				else
					return false;
			}
			else
			{
				return false;
			}
		}
		return true;
	}

	public boolean oneAwayStraight(String s1, String s2, String s3, String s4, String s5){
		int[] rank = new int[5];
		rank[0]=getRank(s1);
		rank[1]=getRank(s2);
		rank[2]=getRank(s3);
		rank[3]=getRank(s4);
		rank[4]=getRank(s5);
		Arrays.sort(rank);
		if (rank[4]-rank[0]<5)
			return false;
		if (rank[3]-rank[0]<5)
		{
			int check=0;
			for (int i=0;i<3;i++)
			{
				if (rank[i]==rank[i+1])
					check=1;
			}
			if (check==0)
				return true;
		}
		if (rank[4]-rank[1]<5)
		{
			for (int i=1;i<4;i++)
			{
				if (rank[i]==rank[i+1])
					break;
			}
			return true;
		}
		
		return false;
	}

	public boolean oneAwayFullHouse(String s1, String s2, String s3, String s4, String s5){
		int[] rank = new int[5];
		rank[0]=getRank(s1);
		rank[1]=getRank(s2);
		rank[2]=getRank(s3);
		rank[3]=getRank(s4);
		rank[4]=getRank(s5);
		int two=0;
		int[] ranks=new int[14];
		for (int i=0;i<5;i++)
		{
			ranks[rank[i]-1]++;
		}
		for (int i=0;i<14;i++){
			if (ranks[i]==3) 
				return true;
			else if (ranks[i]==2)
				two++;
		}
		if (two==2)
			return true;
		return false;

	}

	public boolean onePair(String s1, String s2, String s3, String s4, String s5){
		int[] rank = new int[5];
		rank[0]=getRank(s1);
		rank[1]=getRank(s2);
		rank[2]=getRank(s3);
		rank[3]=getRank(s4);
		rank[4]=getRank(s5);

		int[] ranks=new int[14];
		for (int i=0;i<5;i++)
		{
			ranks[rank[i]-1]++;
		}
		for (int i=0;i<14;i++){
			if (ranks[i]==2) 
				return true;
		}
		return false;

	}

	public boolean threeOfTheSameSuit(String s1, String s2, String s3, String s4, String s5){
		char[] suit = new char[5];
		suit[0]=s1.charAt(0);
		suit[1]=s2.charAt(0);
		suit[2]=s3.charAt(0);
		suit[3]=s4.charAt(0);
		suit[4]=s5.charAt(0);
		int H=0;
		int S=0;
		int D=0;
		int C=0;
		for (int i=0;i<5;i++)
		{
			if (suit[i]=='H')
				H++;
			else if (suit[i]=='S')
				S++;
			else if (suit[i]=='D')
				D++;
			else 
				C++;
		}
		if (D==3||H==3||S==3||C==3)
			return true;
		return false;
	}
	public boolean threeCardsInSequence(String s1, String s2, String s3, String s4, String s5){
		int[] rank = new int[5];
		rank[0]=getRank(s1);
		rank[1]=getRank(s2);
		rank[2]=getRank(s3);
		rank[3]=getRank(s4);
		rank[4]=getRank(s5);
		int count=0;
		int h=0;
		Arrays.sort(rank);
		if (rank[0]+1==rank[1]) count++;
		for (int i=0;i<4;i++)
		{
			if (rank[i]+1==rank[i+1])
			{
				count++;
			}
			else{
				if (count>h)
					h=count;
				count=0;
			}
		}
		if (h!=3&&count!=3)
			return false;
		return true;

	}

	public int[] swap(String s1, String s2, String s3, String s4, String s5)
	{
		int[] rank = new int[5];
		rank[0]=getRank(s1);
		rank[1]=getRank(s2);
		rank[2]=getRank(s3);
		rank[3]=getRank(s4);
		rank[4]=getRank(s5);
		char[] suit = new char[5];
		suit[0]=s1.charAt(0);
		suit[1]=s2.charAt(0);
		suit[2]=s3.charAt(0);
		suit[3]=s4.charAt(0);
		suit[4]=s5.charAt(0);
		int[] output=new int[5];

		if (fullHouse(s1,s2,s3,s4,s5)||royalFlush(s1,s2,s3,s4,s5)||straightFlush(s1,s2,s3,s4,s5)||flush(s1,s2,s3,s4,s5)||
				straight(s1,s2,s3,s4,s5)||fourOfAKind(s1,s2,s3,s4,s5))
		{
			return output;
		}
		else if (oneAwayRoyalFlush(s1,s2,s3,s4,s5))
		{
			if (suit[0]==suit[1])
			{
				for (int i=0;i<5;i++)
				{
					if (suit[0]!=suit[i])
					{
						output[i]=1;
						return output;
					}
					if (rank[0]<10)
					{
						output[i]=1;
						return output;
					}
				}

			}
			else if (suit[0]!=suit[1])
			{
				if (suit[0]==suit[2])
				{
					output[1]=1;
					return output;
				}
				else
				{
					output[0]=1;
					return output;
				}
			}


		}
		else if (oneAwayStraightFlush(s1,s2,s3,s4,s5))///////////////////////////////////////////////////
		{
			if (suit[0]==suit[1])
			{
				for (int i=0;i<5;i++)
				{
					if (suit[0]!=suit[i])
					{
						output[i]=1;
						return output;
					}
				}
				int[] rank2=rank.clone();
				Arrays.sort(rank2);
				int check=0;
				if (rank2[4]-rank2[1]<5)
					check=0;
				else 
					check=4;
				output[check]=1;
				for (int i =0;i<5;i++)
				{
					if (rank[i]==rank2[check])
					{
						output[i]=1;
						return output;
					}
				}

			}
			else if (suit[0]!=suit[1])
			{
				if (suit[0]==suit[2])
				{
					output[1]=1;
					return output;
				}
				else
				{
					output[0]=1;
					return output;
				}
			}
		}
		else if (oneAwayFlush(s1,s2,s3,s4,s5))///////////////////////////////////////////////////
		{
			if (suit[0]==suit[1])
			{
				for (int i=0;i<5;i++)
				{
					if (suit[0]!=suit[i])
					{
						output[i]=1;
						return output;
					}
				}

			}
			else if (suit[0]!=suit[1])
			{
				if (suit[0]==suit[2])
				{
					output[1]=1;
					return output;
				}
				else
				{
					output[0]=1;
					return output;
				}
			}
		}
		else if (oneAwayStraight(s1,s2,s3,s4,s5))/////////
		{
			int[] rank2=rank.clone();
			Arrays.sort(rank2);
			int check=0;
			if (rank2[4]-rank2[1]<5)
				check=0;
			else 
				check=4;
			output[check]=1;
			for (int i =0;i<5;i++)
			{
				if (rank[i]==rank2[check])
				{
					output[i]=1;
					return output;
				}
			}
		}
		else if (oneAwayFullHouse(s1,s2,s3,s4,s5))
		{

			int pos1=-1;
			int pos2=-1;
			int[] ranks=new int[14];
			for (int i=0;i<5;i++)
			{
				ranks[rank[i]-1]++;
			}
			for (int i=0;i<14;i++){
				if (ranks[i]==3) 
				{
					for (int x=0;x<5;x++)
					{
						if (rank[x]!=i+1)
						{
							output[x]=1;
						}
					}
					return output;
				}
				else if (ranks[i]==2)
				{
					if (pos1==-1)
						pos1=i;
					else
						pos2=i;
				}
			}
			for (int i=0;i<5;i++)
			{
				if (rank[i]!=pos1+1||rank[i]!=pos2+1)
					output[i]=1;
			}
			return output;

		}
		else if (threeOfTheSameSuit(s1,s2,s3,s4,s5))///////////////////////////
		{
			int H=0;
			int S=0;
			int D=0;
			int C=0;
			for (int i=0;i<5;i++)
			{
				if (suit[i]=='H')
					H++;
				else if (suit[i]=='S')
					S++;
				else if (suit[i]=='D')
					D++;
				else 
					C++;
			}
			char look=' ';
			if (H==3)
				look='H';
			else if (S==3)
				look='S';
			else if (D==3)
				look='D';
			else
				look='C';
			for (int i=0;i<5;i++)
			{
				if (suit[i]!=look)
					output[i]=1;
			}
			return output;
		}
		else if(threeCardsInSequence(s1,s2,s3,s4,s5))//////////////////
		{
			int[] rank2=rank.clone();
			Arrays.sort(rank2);
			int start=-1;
			int end=0;
			int count=0;
			if (rank2[0]+1==rank2[1])
			{
				count++;
				start=0;
			}
			for (int i=0;i<4;i++)
			{
				if (rank[i]+1==rank[i+1])
				{
					if (start==-1) start=i;
					count++;
					if (count==3)
					{
						end=i+1;
						break;
					}
				}
				else{
					count=0;
					start=-1;
				}
			}
			for (int i=0;i<5;i++)
			{
				if (i<start||i>end)
					output[i]=1;
			}
			return output;
		}
		else if (onePair(s1,s2,s3,s4,s5))
		{
			int look=-1;
			int[] ranks=new int[14];
			for (int i=0;i<5;i++)
			{
				ranks[rank[i]-1]++;
			}
			for (int i=0;i<14;i++){
				if (ranks[i]==2){
					look=i+1;
					break;
				}
			}
			for (int i=0;i<5;i++)
			{
				if (rank[i]!=look)
					output[i]=1;
			}
			return output;
		}
		else
		{
			int[] rank2=rank.clone();
			Arrays.sort(rank2);
			for (int i=0;i<5;i++)
			{
				if (rank[i]!=rank2[4]&&rank[i]!=rank2[3])
					output[i]=1;
			}
		}
		return output;

	}

}
