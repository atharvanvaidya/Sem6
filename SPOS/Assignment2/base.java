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
		String line, lineMot;
		Integer Location = new Integer(100);
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
			//BufferedReader readerMot = new BufferedReader(new FileReader("mot.txt"));
			BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
			
				while ((line = reader.readLine()) != null) 
				{
					//List<String> words = Arrays.asList(line.split(";"));
					//list.addAll(words);
					//System.out.println(line);
					//StringTokenizer st = new StringTokenizer(line);
					String[] FullLine = line.split(" ");
					writer.write(Location+" ");
					//if(FullLine[0].equals("\t"))
					switch(FullLine[1])
					{
						case "START":
						{
							Location = Integer.parseInt(FullLine[2]);
						}
						
						case "DC":
						{
							if(FullLine[2].charAt(0) == 'H')
							{
								Location += 2;
							}
							else if(FullLine[2].charAt(0) == 'F')
							{
								Location += 4;
							}
							else if(FullLine[2].charAt(0) == 'D')
							{
								Location += 8;
							}
						}
						case "DS":
						{
							
							
						}
						case "LTORG":
						{
							
							
						}
					}
					BufferedReader readerMot = new BufferedReader(new FileReader("mot.txt"));
					while((lineMot = readerMot.readLine()) != null)
					{
						String[] MotLine = lineMot.split(" ");
						if(FullLine[0].equals(MotLine[0]))
						{
							Location += Integer.parseInt(MotLine[2]);
						}
					}
					readerMot.close();
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
