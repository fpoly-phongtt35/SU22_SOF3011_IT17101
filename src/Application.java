import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Product;
import utility.HibernateUtil;

public class Application {
	
	public static void main(String[] args) {
		Product pp = new Product();
		pp.setId(5008); pp.setName("New IT17101");
		pp.setPrice(BigDecimal.valueOf(650000));
		pp.setQuantity(6324572);
		
//		add(pp);
		deleteById(5008);
		readAll();
//		Product p = readById(4953);
//		System.out.println(p);
	}
	
	private static void deleteById(Integer id) {
		// Tìm đối tượng cần xoá theo id
		Product doiTuongCanXoa = readById(id);
		// Xoá đối tượng
		delete(doiTuongCanXoa);
	}
	
	private static void add(Product product) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(product);
		trans.commit(); // lưu kết quả
		session.close();
	}
	
	private static void delete(Product product) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		session.delete(product);
		trans.commit(); // lưu kết quả
		session.close();
	}
	
	private static void update(Product product) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		session.update(product);
		trans.commit(); // lưu kết quả
		session.close();
	}
	
	private static Product readById(Integer id) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		Product product = session.find(Product.class, id);
		session.close();
		return product;
	}
	
	private static void readAll() {
		SessionFactory factory = HibernateUtil.getFactory();
		// SQL Server -> New Query
		Session session = factory.openSession();
		Query<Product> query = session.createQuery(
				"FROM Product p", Product.class);
		
		List<Product> products = query.getResultList();
		for(Product product : products) {
			System.out.println(product);
		}
		session.close();
	}
	
}
