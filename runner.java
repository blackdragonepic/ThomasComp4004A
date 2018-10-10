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

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            /*
            while((line = bufferedReader.readLine()) != null) {
            	if (count<5){
            		hand1[i]=line;
            		i++;
            		count++;
            	}
            	else if (count<10)
            	{
            		if (count==5) i=0;
            		
            	}
            	System.out.println(line);
            }  */
            for (int i=0;i<5;i++)
            {
            	line = bufferedReader.readLine();

            	hand1[i]=line.trim();
            }
            for (int i=0;i<5;i++)
            {
            	line = bufferedReader.readLine();

            	hand2[i]=line.trim();
            }
            System.out.println("The hands to beat is:"+myToString(hand1));
            System.out.println("The hands that the AIP has is:"+myToString(hand2));
            
            int[] swap=swapper.swap(hand2[0], hand2[1], hand2[2], hand2[3], hand2[4]);
            System.out.println("The cards to swap are(keep=0, swap=1): "+myToString(swap));
            for (int i=0;i<5;i++)
            {
            	if (swap[i]==1)
            	{
            		line = bufferedReader.readLine();
                	hand2[i]=line.trim();
            	}
            }
            System.out.println("The NEW hands that the AIP has is:"+myToString(hand2));
            int result=rank.Winner(hand1, hand2);
            if (result==1)
            	 System.out.println("The AIP Won!");
            else
            	System.out.println("The Player Won!");
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
