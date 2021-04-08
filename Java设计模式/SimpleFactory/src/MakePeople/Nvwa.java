package MakePeople;
 
public class Nvwa {
 
	public static People getPeople(String arg) {
		People people=null;
		if(arg.equalsIgnoreCase("M")) {
			people=new Man();
			System.err.println("女娲要制造男人了");
		}
		else if(arg.equalsIgnoreCase("W"))
		{
			people=new Woman();
			System.err.println("女娲要制造女人了");
		} else if(arg.equalsIgnoreCase("R")) 
		{
			people=new Robot();
			System.err.println("女娲要制造机器人了");
		} else {
			System.out.println("cuo");
		}
		return people;
	}
}