package application;

import java.text.SimpleDateFormat;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/yyyy");

	public static void main(String[] args) {
		
		SellerDao  sd = DaoFactory.createSellerDao();
		System.out.println("=== TEST 1: Seller FindById ===");
		Seller seller = sd.findById(3);
		
		System.out.println(seller);
		
		System.out.println("=== TEST 2: Seller FindByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sd.findByDepartment(department);
		
		for (Seller s : list) {
			System.out.println(s);
		}
	}

}
