package application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/yyyy");

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sd = DaoFactory.createSellerDao();
		System.out.println("\n=== TEST 1: Seller FindById ===");
		Seller seller = sd.findById(3);

		System.out.println(seller);

		System.out.println("\n=== TEST 2: Seller FindByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sd.findByDepartment(department);

		for (Seller s : list) {
			System.out.println(s);
		}

		System.out.println("\n=== TEST 3: Seller FindAll ===");
		list = sd.findAll();

		for (Seller s : list) {
			System.out.println(s);
		}

		System.out.println("\n=== TEST 4: Seller Insert ===");

		Seller newSeller = new Seller(null, "Nomad", "nomad@gmail.com", new Date(), 3500.0, department);

		sd.insert(newSeller);
		System.out.println("Inserted! New id " + newSeller.getId());

		System.out.println("\n=== TEST 5: Seller Update ===");

		seller = sd.findById(1);
		seller.setName("Marta Waine");
		sd.update(seller);

		list = sd.findAll();

		for (Seller s : list) {
			System.out.println(s);
		}
		
		System.out.println("\n=== TEST 6: Seller Delete ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		
		sd.deleteById(id);
		System.out.println("Delete completed.");
		sc.close();

	}

}
