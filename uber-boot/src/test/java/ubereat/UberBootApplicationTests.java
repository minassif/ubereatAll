package ubereat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ubereat.model.Adresse;
import ubereat.model.Article;
import ubereat.model.Client;
import ubereat.model.Commande;
import ubereat.model.Livreur;
import ubereat.model.Restaurant;
import ubereat.model.Restaurateur;
import ubereat.model.TypePlat;
import ubereat.model.TypeResto;
import ubereat.repository.IArticle;
import ubereat.repository.IClient;
import ubereat.repository.ICommande;
import ubereat.repository.ILivreur;
import ubereat.repository.IRestaurant;
import ubereat.repository.IRestaurateur;
import ubereat.repository.ITypePlat;
import ubereat.repository.ITypeResto;
import ubereat.repository.IUtilisateur;

@SpringBootTest
class UberBootApplicationTests {

	@Autowired
	private IArticle articleRepo;
	@Autowired
	private IClient clientRepo;
	@Autowired
	private ICommande commandeRepo;
	@Autowired
	private ILivreur livreurRepo;
	@Autowired
	private IRestaurant restaurantRepo;
	@Autowired
	private IRestaurateur restaurateurRepo;
	@Autowired
	private ITypePlat typePlatRepo;
	@Autowired
	private ITypeResto typeRestoRepo;
	@Autowired
	private IUtilisateur utilisateurRepo;
	
	@Test
	void contextLoads() {
		
		
		
		Adresse adresseMichel = new Adresse();
		adresseMichel.setCodepostale("75000");
		adresseMichel.setVille("Paris");
		adresseMichel.setVoie("4, allée des embrumes");
		
		Client michel = new Client();
		michel.setEmail("michel@nassif.fr");
		michel.setPassword("michouzizou");
		michel.setNom("nassif");
		michel.setPrenom("michel");
		michel.setTel("0669696969");
		michel.setCb("black");
		michel.setAdresse(adresseMichel);
		michel.setIban("FR76PLUSDETUNES");
		
		

		Adresse adresseKebab = new Adresse();
		adresseKebab.setCodepostale("75000");
		adresseKebab.setVille("Paris");
		adresseKebab.setVoie("3, allée des embrumes");
		
		Adresse adressePizza = new Adresse();
		adressePizza.setCodepostale("75000");
		adressePizza.setVille("Paris");
		adressePizza.setVoie("5, rue des Bilal");
		
		
		
		Restaurateur jeanPizz = new Restaurateur();
		jeanPizz.setEmail("jano@pizzaBON.fr");
		jeanPizz.setPassword("pizzalover");
		jeanPizz.setNom("Pizza");
		jeanPizz.setPrenom("jean");
		jeanPizz.setIban("FR76PLEINSDETUNES");
		jeanPizz.setTel("Double117");
		jeanPizz.setRestaurant(null);
		
		Restaurateur andreBabke = new Restaurateur();
		andreBabke.setEmail("andre@kebaboui.fr");
		andreBabke.setPassword("jadorkebAB");
		andreBabke.setNom("Kebabier");
		andreBabke.setPrenom("andre");
		andreBabke.setIban("FR76LEMBROCHEUR");
		andreBabke.setTel("KEBABKEBAB");
		
		Restaurant kebab = new Restaurant();
		kebab.setNom("kebab andre");
		kebab.setDescription("Des bons kebabs");
		kebab.setEmporter(true);
		kebab.setLivraison(true);
		kebab.setPricerange(5);
		kebab.setRate(3.4);
		kebab.setRestaurateur(andreBabke);
		
		
		
	
		TypeResto pizzeriaa = new TypeResto();
		pizzeriaa.setNom("pizzeria");
		
		TypeResto rapide = new TypeResto();
		rapide.setNom("rapide");
		
		
		
		Restaurant pizzeria = new Restaurant();
		pizzeria.setNom("pizzos deliros");
		pizzeria.setDescription("La pizza hmmm");
		pizzeria.setEmporter(true);
		pizzeria.setLivraison(true);
		pizzeria.setPricerange(9);
		pizzeria.setRate(4.0);
		pizzeria.setRestaurateur(jeanPizz);
		
		pizzeriaa.setRestaurant(pizzeria);
		rapide.setRestaurant(pizzeria);

		
		TypePlat boisson=new TypePlat();
		boisson.setNom("boisson");
		

		
		TypePlat pizza=new TypePlat();
		pizza.setNom("pizza");
		
		TypePlat plat=new TypePlat();
		plat.setNom("plat");
		
				
		Livreur benji = new Livreur();
		benji.setEmail("benjamin@lachivier.fr");
		benji.setPassword("ben10");
		benji.setNom("lachivier");
		benji.setPrenom("benjamin");
		benji.setTel("06000000");
		benji.setIban("FR00MASSETUNES");
		
		
		Article coca =new Article();
		coca.setNom("coca");
		coca.setVegetarien(true);
		coca.setDescription("Soda de type coca");
		coca.setPrix(2);
		coca.setRestaurant(pizzeria);
		
		boisson.setArticles(coca);
		
		Article marherita =new Article();
		marherita.setNom("marherita");
		marherita.setVegetarien(true);
		marherita.setDescription("Pizza: marherita");
		marherita.setPrix(8);
		marherita.setRestaurant(pizzeria);
		
		pizza.setArticles(marherita);
		plat.setArticles(marherita);
		
		List<Article> macom= new ArrayList<Article>();
		macom.add(marherita);
		macom.add(coca);
		
		Commande macommande = new Commande();
		macommande.setArticles(macom);
		macommande.setClient(michel);
		macommande.setLivreur(benji);
		
		clientRepo.save(michel);
		livreurRepo.save(benji);
		restaurateurRepo.save(jeanPizz);
		restaurateurRepo.save(andreBabke);
		restaurantRepo.save(kebab);
		restaurantRepo.save(pizzeria);
		typeRestoRepo.save(rapide);
		typeRestoRepo.save(pizzeriaa);
		articleRepo.save(marherita);
		articleRepo.save(coca);
		typePlatRepo.save(boisson);
		typePlatRepo.save(plat);
		typePlatRepo.save(pizza);
		commandeRepo.save(macommande);
		
	}
	
	 

}
