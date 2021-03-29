package test;
import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.*;
import metier.*;
import java.util.*;
public class Test20_requetage
{
	public static void main(String[] args)
	{
		//Création d'un registre
		   final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
		           .configure() // configures settings from hibernate.cfg.xml
		           .build();
		   
			//Creation d'une fabrique de session
		   SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		   	       
			//Creation d'une session= unité de travail = le contexte Hibernate
		   Session session = sessionFactory.openSession();

		session.beginTransaction();
		
		System.out.println("\n\n");

		//Affichez tous les Adherents
		List<Adherent> adherents = (List<Adherent>)(session
				.createQuery("from metier.Adherent").list());//REQUETE HQL

		System.out.println("LISTE DES adherentS :");
		System.out.println("------------------");
		for (Adherent a : adherents) {
			System.out.println(a);
		}
		System.out.println();
		
		//Affichez tous les Sports
		List<Sport> sports = (List<Sport>)(session.
					createQuery("from metier.Sport").list());
		System.out.println("LISTE DES SPORTS :");
		System.out.println("------------------:");
		for (Sport s : sports) {
			System.out.println(s);
		}
		System.out.println();

		//Affichez tous les Entraineurs
		List<Entraineur> entraineurs = (List<Entraineur>)session
				.createQuery("from metier.Entraineur").list();//REQUETE HQL
		System.out.println("\nLISTE DES ENTRAINEURS :");
		System.out.println("-----------------------");
		for (Entraineur e : entraineurs){
			System.out.println(e);
		}
		System.out.println("\n\n");
		
		///////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////
		//TRAVAIL A REALISER :
		//TRAVAIL A REALISER :
		// Matérialisez un adhérent particulier
		// Affichez ses sports et leurs entraineurs
		///////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////

		////////////////////////////////////////////////////
		//         Recherche d'un adhérent particulier
		////////////////////////////////////////////////////
		//Affichez un Adherent, son sport et l'entraîneur du sport
		//
		// On est en Lazy-loading
		//
		Adherent a1 = (Adherent )session.get(Adherent.class, 7);
		System.out.println(" Adherent ID=7 :  " + a1);

		if( a1 != null){
			if( a1.getSports() != null ) {
				System.out.println("nb de sports :  " + a1.getSports().size());
				for(Sport o : a1.getSports()) {
					System.out.println("Liste des sports pratiqués :  " + o+"\n");
					System.out.println("Entraineur concerné :  " + o.getEntraineur()+"\n");
				}
				
				

			}
			
		}
		else
			System.out.println("aucun Adherent avec cet ID");

		System.out.println();
		
////////////////////////////////////////////////////////////////////////////
// SOLUTION
//
//  D:\abc_45_HIBERNATE_ORM_JPA\00_coursDocPoly\00_voir_JTIPS_ALEXIS_HASSLER_Hibernate\Hibernate-Filter - JTips_IMPORTANT_ToMany
//
//
//////////////////////////////////////////////////////////////////////////////
//		List<Sport> sports2 = (List<Sport>)(session.createQuery("from metier.Sport S where S.idS =" + a1.getIdA()).list());
//
//
//		System.out.println("LISTE DES SPORTS de l'Adherent:");
//		System.out.println("-------------------------------:");
//		for (Sport s : sports2) {
//			System.out.println(s);
//		}
		System.out.println();		
		
		System.out.println("\n\n");

		
		session.close();
		System.out.println("Terminé");
	}
}
