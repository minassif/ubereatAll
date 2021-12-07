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
	private IUtilisateur utilisateurRepo;
	
	@Test
	void contextLoads() {
		
		
		
		Adresse adresseMichel = new Adresse();
		adresseMichel.setCodepostale("75000");
		adresseMichel.setVille("Paris");
		adresseMichel.setVoie("4, allée des embrumes");
		
		Adresse adresseDaniel = new Adresse();
		adresseDaniel.setCodepostale("75000");
		adresseDaniel.setVille("Paris");
		adresseDaniel.setVoie("12, avenue de l'auto");
		
		Adresse adresseJustine = new Adresse();
		adresseJustine.setCodepostale("75000");
		adresseJustine.setVille("Paris");
		adresseJustine.setVoie("4, allée des embrumes");
		
		Adresse adresseRico = new Adresse();
		adresseRico.setCodepostale("75000");
		adresseRico.setVille("Paris");
		adresseRico.setVoie("45, rue de l'alcool");
		
		Client michel = new Client();
		michel.setEmail("michel@nassif.fr");
		michel.setPassword("michouzizou");
		michel.setNom("nassif");
		michel.setPrenom("michel");
		michel.setTel("0669696969");
		michel.setCb("black");
		michel.setAdresse(adresseMichel);
		michel.setIban("FR76PLUSDETUNES");
		michel.setStatut("client");

		Client daniel = new Client();
		daniel.setEmail("daniel@nassif.fr");
		daniel.setPassword("vroumvroum");
		daniel.setNom("bilal");
		daniel.setPrenom("daniel");
		daniel.setTel("0669696954");
		daniel.setCb("invisible");
		daniel.setAdresse(adresseDaniel);
		daniel.setIban("FR76PMAXDEBIF");
		daniel.setStatut("client");
		
		Client justine = new Client();
		justine.setEmail("justine@nassif.fr");
		justine.setPassword("jaimichel");
		justine.setNom("champagne");
		justine.setPrenom("justine");
		justine.setTel("0669696912");
		justine.setCb("black");
		justine.setAdresse(adresseJustine);
		justine.setIban("FR76PMICHELJTM");
		justine.setStatut("client");
		
		Client rico = new Client();
		rico.setEmail("rico@nassif.fr");
		rico.setPassword("jaimelalcool");
		rico.setNom("sanchez");
		rico.setPrenom("rico");
		rico.setTel("0669696988");
		rico.setCb("black");
		rico.setAdresse(adresseRico);
		rico.setIban("FR76PARICILESSOUS");
		rico.setStatut("client");
		
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
		jeanPizz.setStatut("restaurateur");	
		
		Restaurateur andreBabke = new Restaurateur();
		andreBabke.setEmail("andre@kebaboui.fr");
		andreBabke.setPassword("jadorkebAB");
		andreBabke.setNom("Kebabier");
		andreBabke.setPrenom("andre");
		andreBabke.setIban("FR76LEMBROCHEUR");
		andreBabke.setTel("KEBABKEBAB");
		andreBabke.setStatut("restaurateur");
		
		Restaurant kebab = new Restaurant();
		kebab.setNom("kebab andre");
		kebab.setDescription("Des bons kebabs");
		kebab.setEmporter(true);
		kebab.setLivraison(true);
		kebab.setPricerange(5);
		kebab.setRate(3.4);
		kebab.setRestaurateur(andreBabke);
		kebab.setOpen(true);
		kebab.setImg("../../assets/img/Restaurants/kebab/kebab.jpg");
		
		
		
		
		Restaurant pizzeria = new Restaurant();
		pizzeria.setNom("pizzos deliros");
		pizzeria.setDescription("La pizza hmmm");
		pizzeria.setEmporter(true);
		pizzeria.setLivraison(true);
		pizzeria.setPricerange(9);
		pizzeria.setRate(4.0);
		pizzeria.setRestaurateur(jeanPizz);
		pizzeria.setOpen(false);
		pizzeria.setImg("../../assets/img/Restaurants/pizzeria/pizza.jpg");
		

		
		Livreur benji = new Livreur();
		benji.setEmail("benjamin@lachivier.fr");
		benji.setPassword("ben10");
		benji.setNom("lachivier");
		benji.setPrenom("benjamin");
		benji.setTel("06000000");
		benji.setIban("FR00MASSETUNES");
		benji.setStatut("livreur");
		
		Article coca =new Article();
		coca.setNom("coca");
		coca.setVegetarien(true);
		coca.setDescription("Soda de type coca");
		coca.setPrix(2);
		coca.setRestaurant(pizzeria);
		coca.setTypePlat(TypePlat.Boisson);
		
		Article gressin =new Article();
		gressin.setNom("gressin");
		gressin.setVegetarien(true);
		gressin.setDescription("Des petits gressins à l'huile d'olive");
		gressin.setPrix(3);
		gressin.setRestaurant(pizzeria);
		gressin.setImg("../assets/img/Restaurants/pizzeria/");
		gressin.setTypePlat(TypePlat.Entree);
		
		Article burata =new Article();
		burata.setNom("burata");
		burata.setVegetarien(true);
		burata.setDescription("Une bonne buratata au bon lait de bufflon");
		burata.setPrix(4);
		burata.setRestaurant(pizzeria);
		burata.setImg("../assets/img/Restaurants/pizzeria/");
		burata.setTypePlat(TypePlat.Entree);
		
		Article pancontomate =new Article();
		pancontomate.setNom("Pan con tomate");
		pancontomate.setVegetarien(true);
		pancontomate.setDescription("Plait-il ? Ce n'est pas Italien ? Coup de boule rien à foutre.");
		pancontomate.setPrix(4);
		pancontomate.setRestaurant(pizzeria);
		pancontomate.setImg("../assets/img/Restaurants/pizzeria/");
		pancontomate.setTypePlat(TypePlat.Entree);
		
		Article marherita =new Article();
		marherita.setNom("marherita");
		marherita.setVegetarien(true);
		marherita.setDescription("Pizza: marherita");
		marherita.setPrix(8);
		marherita.setRestaurant(pizzeria);
		marherita.setImg("../assets/img/Restaurants/pizzeria/pizza.jpg");
		marherita.setTypePlat(TypePlat.Plat);
		
		Article regina =new Article();
		regina.setNom("regina");
		regina.setVegetarien(true);
		regina.setDescription("Pizza: regina");
		regina.setPrix(9);
		regina.setRestaurant(pizzeria);
		regina.setImg("../assets/img/Restaurants/pizzeria/pizza.jpg");
		regina.setTypePlat(TypePlat.Plat);
		
		Article calzone =new Article();
		calzone.setNom("calzone");
		calzone.setVegetarien(false);
		calzone.setDescription("Pizza: calzone");
		calzone.setPrix(12);
		calzone.setRestaurant(pizzeria);
		calzone.setImg("../assets/img/Restaurants/pizzeria/pizza.jpg");
		calzone.setTypePlat(TypePlat.Plat);
		
		
		
		List<Article> macom= new ArrayList<Article>();
		macom.add(marherita);
		macom.add(coca);
		
		Commande macommande = new Commande();
		macommande.setArticles(macom);
		macommande.setClient(michel);
		macommande.setLivreur(benji);
		
		clientRepo.save(michel);
		clientRepo.save(daniel);
		clientRepo.save(justine);
		clientRepo.save(rico);
		livreurRepo.save(benji);
		restaurateurRepo.save(jeanPizz);
		restaurateurRepo.save(andreBabke);
		restaurantRepo.save(kebab);
		restaurantRepo.save(pizzeria);
		articleRepo.save(marherita);
		articleRepo.save(regina);
		articleRepo.save(calzone);
		articleRepo.save(gressin);
		articleRepo.save(burata);
		articleRepo.save(pancontomate);
		articleRepo.save(coca);
		commandeRepo.save(macommande);
		
	}
	
}
