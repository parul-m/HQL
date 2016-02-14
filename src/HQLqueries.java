
import dto.Product;
import java.util.List;
import myconfig.connection;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HQLqueries {
    static SessionFactory sf;
    public static void showAll() {
        sf = connection.getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        Query q = s.createQuery("from Product");
        List<Product> l = q.list();
        for (Product p1: l) {
            System.out.println(p1);
        }
        t.commit();
        s.close();
        sf.close();
    }
    
    public static void showSingleCol() {
        sf = connection.getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        Query q = s.createQuery("select name from Product");
        List<String> l = q.list();
        for (String p1: l) {
            System.out.println(p1);
        }
        t.commit();
        s.close();
        sf.close();
    }
    
    public static void showManyCol() {
        sf = connection.getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        Query q = s.createQuery("select id, name, price from Product");
        List<Object[]> l = q.list();
        for (Object p1[]: l) {
            System.out.println(p1[0]);
            System.out.println(p1[1]);
            System.out.println(p1[2]);
            System.out.println("-------");
        }
        t.commit();
        s.close();
        sf.close();
    }
   
    public static void showWhere() {
        sf = connection.getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        Query q = s.createQuery("select name from Product where price>=?");
        q.setFloat(0, 4000);
        List<String> l = q.list();
        for (String p1: l) {
            System.out.println(p1);
        }
        t.commit();
        s.close();
        sf.close();
    }
    
    public static void sumPrice() {
        sf = connection.getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        Query q = s.createQuery("select sum(price) from Product");
        List<Double> l = q.list();
        for (Double p1: l) {
            System.out.println(p1);
        }
        t.commit();
        s.close();
        sf.close();
    }
    
    public static void groupBy() {
        sf = connection.getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        Query q = s.createQuery("select count, sum(price) from Product group by count");
        List<Object[]> l = q.list();
        for(Object x[]: l)
        {
            System.out.println(x[0]+" : "+x[1]);
        }
        t.commit();
        s.close();
        sf.close();
    }
}
