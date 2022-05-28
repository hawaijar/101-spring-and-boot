package demo;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
	public void checkout(String status) {
		System.out.println("Status is " + status);
	}
	public void addItems() {
		System.out.println("Adding items...");
	}
	public void logout() {
		System.out.println("Logging out...");
	}
	public double calculateAmount(double total, double tax) {
		return total + tax/100;
	}
}
