package application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;
import util.ControlDate;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> list = new ArrayList<>();
		
		System.out.print("How many items will be registred? ");
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			System.out.println("Product #"+(i+1)+" data:");
			System.out.print("Common, used or imported (c / u / i)?");
			char type = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();//Consume line break
			String name = sc.nextLine();			
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if(type == 'c')
			{
				list.add(new Product(name, price));
			}
			else if(type== 'u') 
			{
				System.out.print("Manufacture date: ");
				LocalDate date = LocalDate.parse(sc.next(), ControlDate.fmt);
				list.add(new UsedProduct(name, price,date));
			}
			else if(type == 'i')
			{
				System.out.print("Custom fee: ");
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			}			
		}
		
		System.out.println();
		System.out.println("PRICE TAGS: ");
		for(Product prod : list) {
			
			System.out.println(prod.priceTag());
		}
		
		sc.close();
	}

}
