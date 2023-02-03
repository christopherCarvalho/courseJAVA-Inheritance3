package entities;

import java.time.LocalDate;

import util.ControlDate;

public class UsedProduct extends Product {
	private LocalDate manufactureDate;
	
	public UsedProduct() {	
		super();
	}

	public UsedProduct(String name, Double price, LocalDate manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	public LocalDate getManufactureDate() {
		return manufactureDate;
	}
	
	@Override
	public String priceTag() {
		return String.format("%-10s(used) $%.2f",getName(),getPrice()) + String.format(" (Manufacture date: %s)",ControlDate.fmt.format(manufactureDate));
	}
	
	
}
