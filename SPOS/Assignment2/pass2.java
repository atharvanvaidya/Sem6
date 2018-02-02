import java.io.*;
import java.util.*;

class pass2
{
	public static void main(String[] args)
	{
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader("intermediate.txt"));
			BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
			String line,lineMot;
			while((line = reader.readLine()) != null)
			{
				String[] arr = line.split(" ");
				String mnemonic = arr[1];
				BufferedReader readerMot = new BufferedReader(new FileReader("mot.txt"));
				while((lineMot= readerMot.readLine()) != null)
				{
					String[] MotLine = lineMot.split(" ");
					if(MotLine[0].equals(mnemonic))
					{
						arr[1] = MotLine[1];
					}
				}
				readerMot.close();
				for(String obj:arr)
				{
					writer.write(obj);
					writer.write(" ");
				}
				writer.write("\n");
			}
			writer.close();
		}catch(FileNotFoundException f)
		{
			f.printStackTrace();
		}catch(IOException i)
		{
			i.printStackTrace();
		}
	}
}
