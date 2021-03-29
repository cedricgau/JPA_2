package test;
import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.*;
import java.text.*;
import metier.*;
public class Test00_create_INUTILE
{
	public static void main(String[] args) {
		//Session session = null;

		
		//Cr�ation d'un registre
	       final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
	               .configure() // configures settings from hibernate.cfg.xml
	               .build();
	       
			//Creation d'une fabrique de session
	       SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
	       
			//System.err.println("La cr�ation de la SessionFactory a �chou�" + ex);
	       
			//Creation d'une session = le contexte Hibernate
	       Session session = sessionFactory.openSession();

		
		//La structure des tables est cr��e conform�ment au mapping 
		// pas besoin d'ouvrir la transaction
		session.close();

		//System.err.println("La cr�ation de la SessionFactory a �chou�" + ex);
		
//	finally{
//		session.close();
//	
//	}
	}

}
