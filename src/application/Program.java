package application;

import model.entities.Department;
import model.entities.Seller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Program {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/yyyy");

	public static void main(String[] args) {
		
		Department dep = new Department(1, "Books");
		System.out.println(dep);
		
		Seller sel = new Seller(1, "Bob", "bob@email.com", new Date(), 3000.0, dep);
		System.out.println(sel);
		
	}

}
