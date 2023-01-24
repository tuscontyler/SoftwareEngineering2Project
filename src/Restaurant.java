public class Restaurant {

	private boolean applebees;
	private boolean arbys;
	private boolean burgerking;
	private boolean kfc;
	private boolean mcdonalds;
	private boolean pizzahut;
	private boolean popeyes;
	private boolean subway;
	private boolean tacobell;
	private boolean wendys;
	private DatabaseQueries db;



	public Restaurant(DatabaseQueries db) {
	
	applebees = false;
	arbys = false;
	burgerking = false;
	kfc = false;
	mcdonalds = false;
	pizzahut = false;
	popeyes = false;
	subway = false;
	tacobell = false;
	wendys = false;
	this.db = db;
	}
	
	public void setApplebees(boolean applebees)
	{
		this.applebees = applebees;
	}
	
	public boolean isApplebees()
	{
		return applebees;
	}
	
	public void setArbys(boolean arbys)
	{
		this.arbys = arbys;
	}
	
	public boolean isArbys()
	{
		return arbys;
	}
	
	public void setBurgerKing(boolean burgerking)
	{
		this.burgerking = burgerking;
	}
	
	public boolean isBurgerKing()
	{
		return burgerking;
	}
	
	public void setKFC(boolean kfc)
	{
		this.kfc = kfc;
	}
	
	public boolean isKFC()
	{
		return kfc;
	}
	
	public void setMcDonalds(boolean mcdonalds)
	{
		this.mcdonalds = mcdonalds;
	}
	
	public boolean isMcDonalds()
	{
		return mcdonalds;
	}
	
	public void setPizzahut(boolean pizzahut)
	{
		this.pizzahut = pizzahut;
	}
	
	public boolean isPizzahut()
	{
		return pizzahut;
	}
	
	public void setPopeyes(boolean popeyes)
	{
		this.popeyes = popeyes;
	}
	
	public boolean isPopeyes()
	{
		return popeyes;
	}
	
	public void setSubway(boolean subway)
	{
		this.subway = subway;
	}
	
	public boolean isSubway()
	{
		return subway;
	}
	
	public void setTacoBell(boolean tacobell)
	{
		this.tacobell = tacobell;
	}
	
	public boolean isTacoBell()
	{
		return tacobell;
	}
	
	public void setWendys(boolean wendys)
	{
		this.wendys = wendys;
	}
	
	public boolean isWendys()
	{
		return wendys;
	}
	
	
}


