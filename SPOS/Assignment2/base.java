import java.io.*;
import java.util.*;
class SymbolTable
{
	String SymbolName;
	int SymbolAddress;
	int SymbolValue;
	int SymbolLength;
	char SymbolRelocation;
	
	SymbolTable(String SymbolName, int SymbolAddress, int SymbolValue,int SymbolLength, char SymbolRelocation)
	{
		this.SymbolName = SymbolName;
		this.SymbolAddress = SymbolAddress;
		this.SymbolValue = SymbolValue;
		this.SymbolLength = SymbolLength;
		this.SymbolRelocation = SymbolRelocation;
	}
}
class base
{
	public static void main(String[] args)
	{
		//List<String> FullLine;
		String line;
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
			BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
				while ((line = reader.readLine()) != null) 
				{
					//List<String> words = Arrays.asList(line.split(";"));
					//list.addAll(words);
					//System.out.println(line);
					//StringTokenizer st = new StringTokenizer(line);
					String[] FullLine = line.split(" ");
					for(String token:FullLine)
					{
						System.out.println(token);
					}
					System.out.println("Number of Tokens:"+FullLine.length);
					//IF the Line Contains Symbols
					if(FullLine.length == 3)
					{
						System.out.println("This Contains Symbol!");
					}
					//If the Line Does Not Contain Symbols
					else if(FullLine.length == 2)
					{
						System.out.println("This Does NOT Contain Symbol!");
					}
					writer.write(line);
					writer.write("\n");
				}
			reader.close();
			writer.close();
		}catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
