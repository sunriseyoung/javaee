package test.edu.javaee.spring.ioc;

public class Dishes {
	private String dishName;
	private Integer dishPrice;
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	
	public Integer getDishPrice() {
		return dishPrice;
	}
	public void setDishPrice(Integer dishPrice) {
		this.dishPrice = dishPrice;
	}
	public String printDishes()
	{
		return String.format("Dish Name: %s. Dish Price: %d." ,getDishName(),getDishPrice());
	}
}
