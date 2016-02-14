
import myconfig.connection;
import org.hibernate.SessionFactory;

public class Test {
    public static void main(String[] args) {
        SessionFactory sf = connection.getSessionFactory();
        //to insert items in table
        //Additem.insert(sf);
        
        //For HQL queries
        //HQLqueries.showAll();
        //HQLqueries.showSingleCol();
        //HQLqueries.showManyCol();
        //HQLqueries.showWhere();
        //HQLqueries.sumPrice();
        HQLqueries.groupBy();
}
}
