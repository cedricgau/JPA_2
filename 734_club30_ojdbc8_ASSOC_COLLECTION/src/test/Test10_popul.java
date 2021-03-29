package test;
import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.*;
import java.text.*;
import metier.*;
public class Test10_popul
{
	public static void main(String[] args) {
		
	try {

		//Création d'un registre
	   final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
	           .configure() // configures settings from hibernate.cfg.xml
	           .build();
	   
		//Creation d'une fabrique de session
	   SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
	   	       
		//Creation d'une session= unité de travail = le contexte Hibernate
	   Session session = sessionFactory.openSession();

		session.beginTransaction();

		Entraineur e1 = new Entraineur("Dupont","Jean",
					new SimpleDateFormat("dd/MM/yyyy").parse("15/10/2005"));
		Entraineur e2 = new Entraineur("Dubois","Marie",
					new SimpleDateFormat("dd/mm/yyyy").parse("16/12/1995"));
		Entraineur e3 = new Entraineur("Durant","Patrick",
					new SimpleDateFormat("dd/mm/yyyy").parse("04/05/2000"));
		session.persist(e1);// e1 est persistant
		session.persist(e2);// e2 est persistant
		session.persist(e3);// e3 est persistant

		
		//DIFFERENTS OBJETS SONT A ENREGISTRE DANS LA BD
		Sport s1 = new Sport("Equitation");
		Sport s2= new Sport("Natation");
		Sport s3= new Sport("Boxe");
		session.persist(s1);//s1 est persistant
		session.persist(s2);//s2 est persistant
		session.persist(s3);//s3 est persistant

		s1.setEntraineur(e1);
		s2.setEntraineur(e2);
		s3.setEntraineur(e3);

		
		Adherent a1 = new Adherent("Bichon","Simone",
						new SimpleDateFormat("dd/mm/yyyy").parse("04/03/1981"));
		Adherent a2 = new Adherent("Abicol","Nicole",
						new SimpleDateFormat("dd/mm/yyyy").parse("15/12/1951"));
		Adherent a3 = new Adherent("Dupuis","Gary",
						new SimpleDateFormat("dd/mm/yyyy").parse("17/10/2000"));
		session.persist(a1);//a1 est persistant
		session.persist(a2);//a2 est persistant
		session.persist(a3);//a3 est persistant
		
		
		a1.addSport(s1);
		a1.addSport(s3);
		a2.addSport(s2);
		//a3.addSport(s3);

		
		
		
		session.getTransaction().commit();
		//Est-ce que le commit ferme la session Hibernate??????????
		//session.close();
		System.out.println("Terminé");

	}
	catch(ParseException ex)
	{
		System.err.println("La création de la SessionFactory a échoué." + ex);
	}
	catch(HibernateException ex){
		System.err.println("La création de la SessionFactory a échoué." + ex);
	}
//	finally{
//		session.close();
//	
//	}
	}

}
