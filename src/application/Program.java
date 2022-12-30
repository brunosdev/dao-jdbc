package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println(" ----- Test 1: seller findById -----");		
		Seller seller = sellerDao.findByid(4);
		System.out.println(seller);
		
		System.out.println("\n----- Test 2: seller findByDepartment -----");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		list.forEach(System.out::println);
		
		System.out.println("\n----- Test 3: seller findAll -----");
		list = sellerDao.findAll();
		list.forEach(System.out::println);
		
		System.out.println("\n----- Test 4: seller insert -----");
		Seller newSeller = new Seller(null, "Josh", "josh@gmail.com", new Date(), 5000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id is: " + newSeller.getId());
		
		System.out.println("\n----- Test 5: seller update -----");
		seller = sellerDao.findByid(1);
		seller.setName("Bruce Wayne");
		sellerDao.update(seller);
		System.out.println("Update complete!");
	}
}