package metier;
import javax.persistence.*;

@Entity
public class Sport
{
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int idS;
	
	@Column(unique=true)
	private String libelle;
	
	@OneToOne @JoinColumn(nullable=true,unique=true)
	private Entraineur entraineur;
	
	//CONSTRUCTEURS

	public Sport(String libelle, Entraineur entraineur) {
		setLibelle(libelle);
		setEntraineur(entraineur);
	}
	public Sport(String libelle){
		this(libelle, null);
	}

	public Sport(){}
	
	//REDEFINITION DE toString()
//	public String toString()
//	{
//		return "id :" + idS + " libelle :<" + libelle + ">";
//	}
	public String toString()
	{//objet persistant
		return "[Sport idS:"+idS+ " libelle :" + libelle + "  entraineur:[entité]]";
	}
/*	public String toString()
	{
		return "id :" + idS + " libelle :<" + libelle + ">  entraineur :" + ((entraineur==null)? "null" : entraineur.getNom());
	}*/

	
	// GETTEURs ET SETTEURs
	public int getIdS() {
		return idS;
	}
	private void setIdS(int idS) {
		this.idS = idS;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelleS) {
		this.libelle = libelleS;
	}
	public Entraineur getEntraineur() {
		return entraineur;
	}
	public void setEntraineur(Entraineur entraineur) {
		this.entraineur = entraineur;
	}
	
}
