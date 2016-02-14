
import dto.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Additem {
    public static void insert(SessionFactory sf) {
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        Product p1 = new Product(101, "mobile", 5000, "13MP HD camera");
        s.save(p1);
        Product p2 = new Product(102, "camera", 7000, "DSLR");
        s.save(p2);
        Product p3 = new Product(103, "printer", 10000, "HD");
        s.save(p3);
        Product p4 = new Product(104, "keyboard", 3000, "wireless");
        s.save(p4);
        t.commit();
        s.close();
    }
}
