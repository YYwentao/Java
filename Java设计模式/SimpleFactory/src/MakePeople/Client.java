package MakePeople;
 
class Client {
 
	
 
	public static void main(String[] args) {
		
		People p ;
		p=Nvwa.getPeople("M");
		p.makePeople();
		System.out.println();
		p=Nvwa.getPeople("W");
		p.makePeople();
		System.out.println();
		p=Nvwa.getPeople("R");
		p.makePeople();
		
	}
 
}