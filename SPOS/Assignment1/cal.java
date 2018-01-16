import java.util.*;
public class cal
{
	static
	{
		System.loadLibrary("calc");//load native library at run time
	} 
	//Declare methods
	private native int add(int a,int b);
	private native int sub(int a,int b);
	private native int mul(int a,int b);
	private native int div(int a,int b);
	private native double s(int a);
	private native double c(int a);
	private native String conc(String x, String y);

	public static void main(String arg[]) throws Exception
	{
		//cal c=new cal();
		Scanner s = new Scanner(System.in);
		Scanner s1 = new Scanner(System.in);
		System.out.println("Welcome to Calculator Programme!");
		int a,b;
		System.out.println("1.Add.\n2.Subtract.\n3.Multiply.\n4.Divide.\n5.Sine.\n6.Cosine.\n7.Concantenate two Strings.\n8.Exit.");
		System.out.println("Enter Your Choice:");
		int choice = s.nextInt();
		switch(choice)
		{
			case 1:
				System.out.print("Enter First Number:");
				a = s.nextInt();
				System.out.print("Enter Second Number:");
				b = s.nextInt();
				System.out.println("Addition="+new cal().add(a,b));
		 		break;
			case 2:
				System.out.print("Enter First Number:");
				a = s.nextInt();
				System.out.print("Enter Second Number:");
				b = s.nextInt();
				System.out.println("Subtraction="+new cal().sub(a,b));
				break;
			case 3:
				System.out.print("Enter First Number:");
				a = s.nextInt();
				System.out.print("Enter Second Number:");
				b = s.nextInt();
				System.out.println("Multiplication="+new cal().mul(a,b));
				break;
			case 4:
				System.out.print("Enter First Number:");
				a = s.nextInt();
				System.out.print("Enter Second Number:");
				b = s.nextInt();
				System.out.println("Division:"+new cal().div(a,b));
				break;
			case 5:
				System.out.print("Enter the Angle in Degrees:");
				a = s.nextInt();
				System.out.println("Sine"+new cal().s(a));
				break;
			case 6:
				System.out.print("Enter the Angle in Degrees:");
				a = s.nextInt();
				System.out.println("Cosine"+new cal().s(a));
				break;
			case 7:
				System.out.print("Enter String x:");
				String x = s1.nextLine();
				System.out.print("Enter String y:");
				String y = s1.nextLine();
				System.out.println("Concantenation:"+new cal().conc(x,y));
				break;
			case 8:
				System.out.println("Goodbye!");
				break;
			default:
				System.out.println("Enter a Valid Value!");
		}
	}

}
