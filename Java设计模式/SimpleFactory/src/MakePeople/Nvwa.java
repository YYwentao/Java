package MakePeople;
 
public class Nvwa {
 
	public static People getPeople(String arg) {
		People people=null;
		if(arg.equalsIgnoreCase("M")) {
			people=new Man();
			System.err.println("Ů�Ҫ����������");
		}
		else if(arg.equalsIgnoreCase("W"))
		{
			people=new Woman();
			System.err.println("Ů�Ҫ����Ů����");
		} else if(arg.equalsIgnoreCase("R")) 
		{
			people=new Robot();
			System.err.println("Ů�Ҫ�����������");
		} else {
			System.out.println("cuo");
		}
		return people;
	}
}