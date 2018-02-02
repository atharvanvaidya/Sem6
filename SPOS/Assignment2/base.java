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
	void ShowSymbolEntry()
	{
		System.out.print(this.SymbolName+" ");
		System.out.print(this.SymbolAddress+" ");
		System.out.print(this.SymbolValue+" ");
		System.out.print(this.SymbolLength+" ");
		System.out.println(this.SymbolRelocation);
	}
	void SetSymbolLength(int SymbolLength)
	{
		this.SymbolLength = SymbolLength;
	}
	String getSymbolName()
	{
		return this.SymbolName;
	}
	int getSymbolAddress()
	{
		return this.SymbolAddress;
	}
	int getSymbolValue()
	{
		return this.SymbolValue;
	}
	int getSymbolLength()
	{
		return this.SymbolLength;
	}
	char getSymbolRelocation()
	{
		return this.SymbolRelocation;
	}
	
}
class base
{
	public static void main(String[] args)
	{
		//List<String> FullLine;
		String line, lineMot;
		Integer Location = new Integer(100);
		Integer Start = Location;
		Integer len = new Integer(0);
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
			//BufferedReader readerMot = new BufferedReader(new FileReader("mot.txt"));
			BufferedWriter writer = new BufferedWriter(new FileWriter("intermediate.txt"));
			BufferedWriter writerST = new BufferedWriter(new FileWriter("symbol.txt"));
			List <SymbolTable> l = new ArrayList<SymbolTable>();
			while ((line = reader.readLine()) != null) 
			{
				//List<String> words = Arrays.asList(line.split(";"));
				//list.addAll(words);
				//System.out.println(line);
				//StringTokenizer st = new StringTokenizer(line);
				String[] FullLine = line.split(" ");
				writer.write(Location+" ");
				//if(FullLine[0].equals("\t"))
				c:
				switch(FullLine[1])
				{
					case "START":
					{
						//System.out.println("In Start Case");
						Location = Integer.parseInt(FullLine[2]);
						SymbolTable obj = new SymbolTable(FullLine[0],Location,-1,0,'R');
						l.add(obj);
						
						//continue;
						break c;
					}
					
					case "DC":
					{
						Integer val = new Integer(Integer.parseInt(FullLine[2].substring(FullLine[2].indexOf("\'")+1,FullLine[2].lastIndexOf("\'"))));
						int Loc = Location;
						if(FullLine[2].charAt(0) == 'H')
						{
							len = 2;
							Location += 2;
						}
						else if(FullLine[2].charAt(0) == 'F')
						{
							len = 4;
							Location += 4;
						}
						else if(FullLine[2].charAt(0) == 'D')
						{
							len = 8;
							Location += 8;
						}
						SymbolTable obj = new SymbolTable(FullLine[0],Loc,val,len,'R');
						l.add(obj);
						//obj.ShowSymbolEntry();
						break c;
					}
					case "DS":
					{
						
						System.out.println("In DS Case");
						break c;
					}
					case "LTORG":
					{
						
						break c;
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
			SymbolTable temp = l.get(0);
			temp.SetSymbolLength(Location-Start);
			reader.close();
			writer.close();
			for(SymbolTable iter:l)
			{
				iter.ShowSymbolEntry();
				writerST.write(iter.getSymbolName()+" ");
				writerST.write(iter.getSymbolAddress()+" ");
				writerST.write(iter.getSymbolValue()+" ");
				writerST.write(iter.getSymbolLength()+" ");
				writerST.write(iter.getSymbolRelocation()+"\n");
			}
			writerST.close();
			System.out.println("Symbol Table Created...");
			
		}catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
