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

class LiteralTable
{
	String literal;
	int address;
	int length;
	
	LiteralTable(String literal , int address , int length)
	{
		this.literal = literal;
		this.address = address;
		this.length = length;
	}
	void ShowLiteralTable()
	{
		System.out.println(this.literal + " ");
		System.out.println(this.address + " ");
		System.out.println(this.length);
	}
	String getLiteral()
	{
		return this.literal;
	}
	int getLiteralAddress()
	{
		return this.address;
	}
	int getLiteralLength()
	{
		return this.length;
	}
}

class base
{
	static int returnLength(String s)
	{
		if(s.charAt(0) == 'H')
		{
			return 2;
		}
		else if(s.charAt(0) == 'F')
		{
			return 4;
		}
		else if(s.charAt(0) == 'D')
		{
			return 8;
		}
		else
		{
			return 0;
		}
	}
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
			List <SymbolTable> l = new ArrayList <SymbolTable> ();
			List <LiteralTable> l1 = new ArrayList <LiteralTable> ();
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
						len = returnLength(FullLine[2]);
						Location += len;
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
						while(Location % 8 != 0)
						{
							Location++;
						}
						
						break c;
					}
				}
				if(FullLine.length == 3)
				{
					//System.out.println(FullLine[2]);
				}
				else
				{
					if(FullLine[1].indexOf("=") != -1)
					{
						//System.out.println(FullLine[1].split("=")[1]);
						String temp = FullLine[1].split("=")[1];
						//System.out.println(temp.substring(2,temp.length()-1));
						String content = temp.substring(2,temp.length()-1);
						LiteralTable ltobj = new LiteralTable(content , 0 , returnLength(temp));
						ltobj.ShowLiteralTable();
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
