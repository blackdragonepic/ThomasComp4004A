import java.util.Arrays;
public class handSwap {
	public boolean fullHouse(String s1, String s2, String s3, String s4, String s5)
	{
		char[] rank = new char[5];
		rank[0]=s1.charAt(1);
		rank[1]=s2.charAt(1);
		rank[2]=s3.charAt(1);
		rank[3]=s4.charAt(1);
		rank[4]=s5.charAt(1);
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
		char[] rank = new char[5];
		rank[0]=s1.charAt(1);
		rank[1]=s2.charAt(1);
		rank[2]=s3.charAt(1);
		rank[3]=s4.charAt(1);
		rank[4]=s5.charAt(1);
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
		char[] rank = new char[5];
		rank[0]=s1.charAt(1);
		rank[1]=s2.charAt(1);
		rank[2]=s3.charAt(1);
		rank[3]=s4.charAt(1);
		rank[4]=s5.charAt(1);
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
}