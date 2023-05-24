
package application.program;

import Entities.Department;
import Entities.Seller;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Program {

    public static void main(String[] args) {
        
        Department dpto = new Department(null,"Eletronicos");
        Seller seller = new Seller(null,"José da Silva", "jose@email.com", new Date(), 2000.0f, dpto);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceJPA");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(dpto);
        em.persist(seller);
        em.getTransaction().commit();
        System.out.println("Registros incluídos com sucesso!");
       
       
        //recupera dados do banco como objeto
        Seller seller1 = em.find(Seller.class, seller.getId());
        System.out.println(seller1);
        
        emf.close();
        em.close();
    }
}
