import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;
public class Program {

	public static void main(String[] args) {
		
		System.out.println("=== Teste 1: seller findById ===");
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== Teste 2: seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list)
		System.out.println(obj);

		System.out.println("\n=== Teste 3: seller findAll ===");
		list = sellerDao.findAll();
		for(Seller obj : list)
		System.out.println(obj);
		
		System.out.println("\n=== Teste 4: seller insert ===");
		Seller newSeller = new Seller (null, "GregHowie", "gregh@gmail.com", new Date(), 4000.00, department);
		//sellerDao.insert(newSeller);
		System.out.println("Inserted! New ID = "+ newSeller.getId());
		
		System.out.println("\n=== Teste 5: seller update ===");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update Complete!");
		
		System.out.println("\n=== Teste 6: seller delete ===");
		//seller = sellerDao.findById(10);
		sellerDao.deleteById(9);
		System.out.println("Delete Complete!");
	}

}
