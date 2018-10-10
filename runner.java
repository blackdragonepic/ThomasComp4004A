import java.io.*;

public class runner {

	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the poker AIP!");
		//FileInputStream in = null;
		//System.out.println("Working Directory = " + System.getProperty("user.dir"));
		// The name of the file to open.
		String fileName = "src/main/java/input.txt";
		String[] hand1=new String[5];
		String[] hand2=new String[5];
		handSwap swapper=new handSwap();
		Rankings rank=new Rankings();
		// This will reference one line at a time
		String line = null;
		int gameNum=1;
		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = 
					new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = 
					new BufferedReader(fileReader);

			while((line = bufferedReader.readLine()) != null) {
				System.out.println("///////////////////////////////////////////");
				System.out.println("Game Number: "+gameNum);
				System.out.println("///////////////////////////////////////////");
				String[] game=line.split(" ");
				int count=0;
				for (int i=0;i<5;i++)
				{

					hand1[i]=game[count];
					count++;
				}
				for (int i=0;i<5;i++)
				{
					hand2[i]=game[count];
					count++;
				}
				System.out.println("The hands to beat is:"+myToString(hand1));
				System.out.println("The hands that the AIP has is:"+myToString(hand2));
				int[] swap=swapper.swap(hand2[0], hand2[1], hand2[2], hand2[3], hand2[4]);
				System.out.print("The cards to swap are: ");

				for (int i=0;i<5;i++)
				{
					if (swap[i]==1)
					{
						System.out.print("Swap ");
						hand2[i]=game[count];
						count++;
					}
					else
					{
						System.out.print("Keep ");
					}
				}
				System.out.println("\nThe NEW hands that the AIP has is:"+myToString(hand2));
				int result=rank.Winner(hand1, hand2);
				if (result==1)
					System.out.println("The AIP Won!");
				else
					System.out.println("The Opponent Won!");
				gameNum++;
			}  

			// Always close files.
			bufferedReader.close();         
		}
		catch(FileNotFoundException ex) {
			System.out.println(
					"Unable to open file '" + 
							fileName + "'");                
		}
		catch(IOException ex) {
			System.out.println(
					"Error reading file '" 
							+ fileName + "'");                  
			// Or we could just do this: 
			// ex.printStackTrace();
		}
	}

	static String myToString(String[] str)
	{
		String output="";
		output+=str[0];
		for (int i=1;i<str.length;i++)
		{
			output+=" "+str[i];
		}
		return output;
	}
	static String myToString(int[] str)
	{
		String output="";
		output+=str[0];
		for (int i=1;i<str.length;i++)
		{
			output+=" "+str[i];
		}
		return output;
	}
}
