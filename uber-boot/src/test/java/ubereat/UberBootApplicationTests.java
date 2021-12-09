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
import ubereat.model.Status;
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
		
		Restaurateur MichMuchPizz = new Restaurateur();
		MichMuchPizz.setEmail("michmuch@pizzaBON.fr");
		MichMuchPizz.setPassword("pizzalolo");
		MichMuchPizz.setNom("Pizza");
		MichMuchPizz.setPrenom("michmuch");
		MichMuchPizz.setIban("FR76PLEINSDETUNES");
		MichMuchPizz.setTel("Double118");
		MichMuchPizz.setRestaurant(null);
		MichMuchPizz.setStatut("restaurateur");	
		
		Restaurateur andreBabke = new Restaurateur();
		andreBabke.setEmail("andre@kebaboui.fr");
		andreBabke.setPassword("jadorkebAB");
		andreBabke.setNom("Kebabier");
		andreBabke.setPrenom("andre");
		andreBabke.setIban("FR76LEMBROCHEUR");
		andreBabke.setTel("KEBABKEBAB");
		andreBabke.setStatut("restaurateur");
		
		Restaurateur JeanKebs = new Restaurateur();
		JeanKebs.setEmail("Jean@kebaboui.fr");
		JeanKebs.setPassword("jadorkebs");
		JeanKebs.setNom("Kebabier");
		JeanKebs.setPrenom("Jean");
		JeanKebs.setIban("FR76LEMBROCHEUR");
		JeanKebs.setTel("KEBABKEBAB");
		JeanKebs.setStatut("restaurateur");
		
		Restaurateur WagonLit = new Restaurateur();
		WagonLit.setEmail("wagon@lit.fr");
		WagonLit.setPassword("debeauxdraps");
		WagonLit.setNom("lit");
		WagonLit.setPrenom("wagon");
		WagonLit.setIban("FR76VROUM");
		WagonLit.setTel("KEBABKEBAB");
		WagonLit.setStatut("restaurateur");
		
		Restaurateur MarlonBrando = new Restaurateur();
		MarlonBrando.setEmail("Marlon@lit.fr");
		MarlonBrando.setPassword("Brando");
		MarlonBrando.setNom("Brando");
		MarlonBrando.setPrenom("Marlon");
		MarlonBrando.setIban("FR76VUCHE");
		MarlonBrando.setTel("OUI");
		MarlonBrando.setStatut("restaurateur");
		
		Restaurateur JeanBurger = new Restaurateur();
		JeanBurger.setEmail("Jean@Burger.fr");
		JeanBurger.setPassword("legrascestbon");
		JeanBurger.setNom("Burger");
		JeanBurger.setPrenom("Jean");
		JeanBurger.setIban("FR76BIGMAC");
		JeanBurger.setTel("OUI");
		JeanBurger.setStatut("restaurateur");
		
		Restaurateur MonsieurCroc = new Restaurateur();
		MonsieurCroc.setEmail("Croc@monsieru.fr");
		MonsieurCroc.setPassword("ouilejambon");
		MonsieurCroc.setNom("Monsieur");
		MonsieurCroc.setPrenom("Croc");
		MonsieurCroc.setIban("FR76BECHAMEL");
		MonsieurCroc.setTel("OUI");
		MonsieurCroc.setStatut("restaurateur");
		
		Restaurateur Christina = new Restaurateur();
		Christina.setEmail("Croc@monsieru.fr");
		Christina.setPassword("ouilejambon");
		Christina.setNom("Monsieur");
		Christina.setPrenom("Croc");
		Christina.setIban("FR76BECHAMEL");
		Christina.setTel("OUI");
		Christina.setStatut("restaurateur");
		
		Restaurateur Christino = new Restaurateur();
		Christino.setEmail("Croc@monsieru.fr");
		Christino.setPassword("ouilejambon");
		Christino.setNom("Monsieur");
		Christino.setPrenom("Croc");
		Christino.setIban("FR76BECHAMEL");
		Christino.setTel("OUI");
		Christino.setStatut("restaurateur");
		
		
		
		Restaurant kebab = new Restaurant();
		kebab.setNom("kebab andré");
		kebab.setDescription("Des bons kebabs");
		kebab.setEmporter(true);
		kebab.setLivraison(true);
		kebab.setPricerange(5);
		kebab.setRate(3.4);
		kebab.setRestaurateur(andreBabke);
		kebab.setOpen(true);
		kebab.setTypeResto(TypeResto.Halal);
		kebab.setImg("../../assets/img/Restaurants/kebab/kebab.jpg");
		
		Restaurant kebaba = new Restaurant();
		kebaba.setNom("kebab ouche");
		kebaba.setDescription("Des kebabs meilleurs que chez andré");
		kebaba.setEmporter(true);
		kebaba.setLivraison(true);
		kebaba.setPricerange(5);
		kebaba.setRate(3.5);
		kebaba.setRestaurateur(JeanKebs);
		kebaba.setOpen(true);
		kebaba.setTypeResto(TypeResto.Halal);
		kebaba.setImg("../../assets/img/Restaurants/kebab/kebaba.jpeg");
		
		Restaurant pizzeria = new Restaurant();
		pizzeria.setNom("pizzos deliros");
		pizzeria.setDescription("La pizza hmmm");
		pizzeria.setEmporter(true);
		pizzeria.setLivraison(true);
		pizzeria.setPricerange(26);
		pizzeria.setRate(4.0);
		pizzeria.setRestaurateur(jeanPizz);
		pizzeria.setOpen(true);
		pizzeria.setTypeResto(TypeResto.Italienne);
		pizzeria.setImg("../../assets/img/Restaurants/pizzeria/pizza.jpg");
		
		Restaurant pizzeriaa = new Restaurant();
		pizzeriaa.setNom("MichMuch Pizza");
		pizzeriaa.setDescription("La pizza aaaaaaah !");
		pizzeriaa.setEmporter(true);
		pizzeriaa.setLivraison(true);
		pizzeriaa.setPricerange(51);
		pizzeriaa.setRate(4.2);
		pizzeriaa.setRestaurateur(MichMuchPizz);
		pizzeriaa.setOpen(true);
		pizzeriaa.setTypeResto(TypeResto.Italienne);
		pizzeriaa.setImg("../../assets/img/Restaurants/pizzeria/pizzeriaa.jpeg");
		
		Restaurant asiatique = new Restaurant();
		asiatique.setNom("Chez monsieur lee");
		asiatique.setDescription("Pour ne pas être dans de beaux draps");
		asiatique.setEmporter(true);
		asiatique.setLivraison(true);
		asiatique.setPricerange(51);
		asiatique.setRate(4.8);
		asiatique.setRestaurateur(WagonLit);
		asiatique.setOpen(true);
		asiatique.setTypeResto(TypeResto.Asiatique);
		asiatique.setImg("../../assets/img/Restaurants/asiat/asiatique.jpg");
		
		Restaurant asiatiquea = new Restaurant();
		asiatiquea.setNom("A pieds par la Chine");
		asiatiquea.setDescription("En vous laissant le choix dans la date");
		asiatiquea.setEmporter(true);
		asiatiquea.setLivraison(true);
		asiatiquea.setPricerange(40);
		asiatiquea.setRate(2.9);
		asiatiquea.setRestaurateur(MarlonBrando);
		asiatiquea.setOpen(true);
		asiatiquea.setTypeResto(TypeResto.Asiatique);
		asiatiquea.setImg("../../assets/img/Restaurants/asiat/asiatiquea.jpg");
		
		Restaurant Burger = new Restaurant();
		Burger.setNom("Chez Jean Burger");
		Burger.setDescription("Pour ceux qui n'ont pas peur du cholestérol");
		Burger.setEmporter(true);
		Burger.setLivraison(true);
		Burger.setPricerange(26);
		Burger.setRate(3.9);
		Burger.setRestaurateur(JeanBurger);
		Burger.setOpen(true);
		Burger.setTypeResto(TypeResto.FastFood);
		Burger.setImg("../../assets/img/Restaurants/burger/burger.jpg");
		
		Restaurant Burgera = new Restaurant();
		Burgera.setNom("Michel Burger");
		Burgera.setDescription("Des sandwichs pour ceux qui sont loin de chez eux");
		Burgera.setEmporter(true);
		Burgera.setLivraison(true);
		Burgera.setPricerange(26);
		Burgera.setRate(0.9);
		Burgera.setRestaurateur(MonsieurCroc);
		Burgera.setOpen(false);
		Burgera.setTypeResto(TypeResto.FastFood);
		Burgera.setImg("../../assets/img/Restaurants/burger/burgera.jpeg");
		
		Restaurant Espana = new Restaurant();
		Espana.setNom("La andalousia");
		Espana.setDescription("Ici on ne vend pas que de la sauce");
		Espana.setEmporter(true);
		Espana.setLivraison(true);
		Espana.setPricerange(51);
		Espana.setRate(2.4);
		Espana.setRestaurateur(Christina);
		Espana.setOpen(true);
		Espana.setTypeResto(TypeResto.Latino);
		Espana.setImg("../../assets/img/Restaurants/latino/espana.jpeg");
		
		Restaurant Espannaa = new Restaurant();
		Espannaa.setNom("El peru");
		Espannaa.setDescription("Si vous vous demandez c'est peru, c'est par ici");
		Espannaa.setEmporter(true);
		Espannaa.setLivraison(true);
		Espannaa.setPricerange(51);
		Espannaa.setRate(1.9);
		Espannaa.setRestaurateur(Christino);
		Espannaa.setOpen(false);
		Espannaa.setTypeResto(TypeResto.Latino);
		Espannaa.setImg("../../assets/img/Restaurants/latino/espannaa.jpg");
		
		
		
		Livreur benji = new Livreur();
		benji.setEmail("benjamin@lachivier.fr");
		benji.setPassword("ben10");
		benji.setNom("lachivier");
		benji.setPrenom("benjamin");
		benji.setTel("06000000");
		benji.setIban("FR00MASSETUNES");
		benji.setStatut("livreur");
		
		
		//CARTE PIZZERIA PIZZOS DELIROS
		
		Article gressin =new Article();
		gressin.setNom("gressin");
		gressin.setVegetarien(true);
		gressin.setDescription("Des petits gressins à l'huile d'olive");
		gressin.setPrix(3);
		gressin.setRestaurant(pizzeria);
		gressin.setImg("../assets/img/Restaurants/pizzeria/gressin.jpg");
		gressin.setTypePlat(TypePlat.Entree);
		
		Article burata =new Article();
		burata.setNom("burata");
		burata.setVegetarien(true);
		burata.setDescription("Une bonne buratata au bon lait de bufflon");
		burata.setPrix(4);
		burata.setRestaurant(pizzeria);
		burata.setImg("../assets/img/Restaurants/pizzeria/burata.jpg");
		burata.setTypePlat(TypePlat.Entree);
		
		Article pancontomate =new Article();
		pancontomate.setNom("Pan con tomate");
		pancontomate.setVegetarien(true);
		pancontomate.setDescription("Plait-il ? Ce n'est pas Italien ? Coup de boule rien à foutre.");
		pancontomate.setPrix(4);
		pancontomate.setRestaurant(pizzeria);
		pancontomate.setImg("../assets/img/Restaurants/pizzeria/pancontomate.jpg");
		pancontomate.setTypePlat(TypePlat.Entree);
		
		Article marherita =new Article();
		marherita.setNom("margherita");
		marherita.setVegetarien(true);
		marherita.setDescription("Pizza: margherita");
		marherita.setPrix(8);
		marherita.setRestaurant(pizzeria);
		marherita.setImg("../assets/img/Restaurants/pizzeria/marherita.jpg");
		marherita.setTypePlat(TypePlat.Plat);
		
		Article regina =new Article();
		regina.setNom("regina");
		regina.setVegetarien(true);
		regina.setDescription("Pizza: regina");
		regina.setPrix(9);
		regina.setRestaurant(pizzeria);
		regina.setImg("../assets/img/Restaurants/pizzeria/regina.jpg");
		regina.setTypePlat(TypePlat.Plat);
		
		Article calzone =new Article();
		calzone.setNom("calzone");
		calzone.setVegetarien(false);
		calzone.setDescription("Pizza: calzone");
		calzone.setPrix(12);
		calzone.setRestaurant(pizzeria);
		calzone.setImg("../assets/img/Restaurants/pizzeria/calzone.jpg");
		calzone.setTypePlat(TypePlat.Plat);
		
		Article tiramisu =new Article();
		tiramisu.setNom("tiramisu");
		tiramisu.setVegetarien(false);
		tiramisu.setDescription("Une petite douceur à la crême et au café");
		tiramisu.setPrix(5);
		tiramisu.setRestaurant(pizzeria);
		tiramisu.setImg("../assets/img/Restaurants/pizzeria/tiramisu.jpg");
		tiramisu.setTypePlat(TypePlat.Dessert);
		
		Article fondant =new Article();
		fondant.setNom("fondant");
		fondant.setVegetarien(false);
		fondant.setDescription("Un gateau au chocolat avec son coeur fondant");
		fondant.setPrix(6);
		fondant.setRestaurant(pizzeria);
		fondant.setImg("../assets/img/Restaurants/pizzeria/fondant.jpg");
		fondant.setTypePlat(TypePlat.Dessert);
		
		Article cookie =new Article();
		cookie.setNom("cookie");
		cookie.setVegetarien(false);
		cookie.setDescription("Bah c'est un cookie quoi");
		cookie.setPrix(4);
		cookie.setRestaurant(pizzeria);
		cookie.setImg("../assets/img/Restaurants/pizzeria/cookie.jpg");
		cookie.setTypePlat(TypePlat.Dessert);
		
		Article sprite =new Article();
		sprite.setNom("sprite");
		sprite.setVegetarien(true);
		sprite.setDescription("Soda de type sprite");
		sprite.setPrix(2);
		sprite.setRestaurant(pizzeria);
		sprite.setImg("../assets/img/Restaurants/pizzeria/sprite.jpg");
		sprite.setTypePlat(TypePlat.Boisson);
		
		Article coca =new Article();
		coca.setNom("coca");
		coca.setVegetarien(true);
		coca.setDescription("Soda de type coca");
		coca.setPrix(2);
		coca.setRestaurant(pizzeria);
		coca.setImg("../assets/img/Restaurants/pizzeria/coca.jpg");
		coca.setTypePlat(TypePlat.Boisson);
		
		//CARTE MICHMUCH PIZZA
		
		Article gressina =new Article();
		gressina.setNom("gressin");
		gressina.setVegetarien(true);
		gressina.setDescription("Des petits gressins à l'huile d'olive");
		gressina.setPrix(3);
		gressina.setRestaurant(pizzeriaa);
		gressina.setImg("../assets/img/Restaurants/pizzeria/gressin.jpg");
		gressina.setTypePlat(TypePlat.Entree);
		
		Article burataa =new Article();
		burataa.setNom("burata");
		burataa.setVegetarien(true);
		burataa.setDescription("Une bonne buratata au bon lait de bufflon");
		burataa.setPrix(4);
		burataa.setRestaurant(pizzeriaa);
		burataa.setImg("../assets/img/Restaurants/pizzeria/burata.jpg");
		burataa.setTypePlat(TypePlat.Entree);
		
		Article pancontomatea =new Article();
		pancontomatea.setNom("Pan con tomate");
		pancontomatea.setVegetarien(true);
		pancontomatea.setDescription("Plait-il ? Ce n'est pas Italien ? Coup de boule rien à foutre.");
		pancontomatea.setPrix(4);
		pancontomatea.setRestaurant(pizzeriaa);
		pancontomatea.setImg("../assets/img/Restaurants/pizzeria/pancontomate.jpg");
		pancontomatea.setTypePlat(TypePlat.Entree);
		
		Article marheritaa =new Article();
		marheritaa.setNom("margherita");
		marheritaa.setVegetarien(true);
		marheritaa.setDescription("Pizza: margherita");
		marheritaa.setPrix(8);
		marheritaa.setRestaurant(pizzeriaa);
		marheritaa.setImg("../assets/img/Restaurants/pizzeria/marherita.jpg");
		marheritaa.setTypePlat(TypePlat.Plat);
		
		Article reginaa =new Article();
		reginaa.setNom("regina");
		reginaa.setVegetarien(true);
		reginaa.setDescription("Pizza: regina");
		reginaa.setPrix(9);
		reginaa.setRestaurant(pizzeriaa);
		reginaa.setImg("../assets/img/Restaurants/pizzeria/regina.jpg");
		reginaa.setTypePlat(TypePlat.Plat);
		
		Article calzonea =new Article();
		calzonea.setNom("calzone");
		calzonea.setVegetarien(false);
		calzonea.setDescription("Pizza: calzone");
		calzonea.setPrix(12);
		calzonea.setRestaurant(pizzeriaa);
		calzonea.setImg("../assets/img/Restaurants/pizzeria/calzone.jpg");
		calzonea.setTypePlat(TypePlat.Plat);
		
		Article tiramisua =new Article();
		tiramisua.setNom("tiramisu");
		tiramisua.setVegetarien(false);
		tiramisua.setDescription("Une petite douceur à la crême et au café");
		tiramisua.setPrix(5);
		tiramisua.setRestaurant(pizzeriaa);
		tiramisua.setImg("../assets/img/Restaurants/pizzeria/tiramisu.jpg");
		tiramisua.setTypePlat(TypePlat.Dessert);
		
		Article fondanta =new Article();
		fondanta.setNom("fondant");
		fondanta.setVegetarien(false);
		fondanta.setDescription("Un gateau au chocolat avec son coeur fondant");
		fondanta.setPrix(6);
		fondanta.setRestaurant(pizzeriaa);
		fondanta.setImg("../assets/img/Restaurants/pizzeria/fondant.jpg");
		fondanta.setTypePlat(TypePlat.Dessert);
		
		Article cookiea =new Article();
		cookiea.setNom("cookie");
		cookiea.setVegetarien(false);
		cookiea.setDescription("Bah c'est un cookie quoi");
		cookiea.setPrix(4);
		cookiea.setRestaurant(pizzeriaa);
		cookiea.setImg("../assets/img/Restaurants/pizzeria/cookie.jpg");
		cookiea.setTypePlat(TypePlat.Dessert);
		
		Article spritea =new Article();
		spritea.setNom("sprite");
		spritea.setVegetarien(true);
		spritea.setDescription("Soda de type sprite");
		spritea.setPrix(2);
		spritea.setRestaurant(pizzeriaa);
		spritea.setImg("../assets/img/Restaurants/pizzeria/sprite.jpg");
		spritea.setTypePlat(TypePlat.Boisson);
		
		Article cocaa =new Article();
		cocaa.setNom("coca");
		cocaa.setVegetarien(true);
		cocaa.setDescription("Soda de type coca");
		cocaa.setPrix(2);
		cocaa.setRestaurant(pizzeriaa);
		cocaa.setImg("../assets/img/Restaurants/pizzeria/coca.jpg");
		cocaa.setTypePlat(TypePlat.Boisson);
		
		
		//CARTE KEBAB
		
		Article frites =new Article();
		frites.setNom("frites");
		frites.setVegetarien(true);
		frites.setDescription("Des ptites frites bien sympathiques");
		frites.setPrix(3);
		frites.setRestaurant(kebab);
		frites.setImg("../assets/img/Restaurants/kebab/frites.jpg");
		frites.setTypePlat(TypePlat.Entree);
		
		Article empanada =new Article();
		empanada.setNom("empanada");
		empanada.setVegetarien(true);
		empanada.setDescription("Une brioche légère fourée à la viande");
		empanada.setPrix(4);
		empanada.setRestaurant(kebab);
		empanada.setImg("../assets/img/Restaurants/kebab/empanada.jpg");
		empanada.setTypePlat(TypePlat.Entree);
		
		Article taboulet =new Article();
		taboulet.setNom("taboulet");
		taboulet.setVegetarien(true);
		taboulet.setDescription("Parfois t'as pas boulet, parfois taboulet");
		taboulet.setPrix(4);
		taboulet.setRestaurant(kebab);
		taboulet.setImg("../assets/img/Restaurants/kebab/taboulet.jpg");
		taboulet.setTypePlat(TypePlat.Entree);
		
		Article doner =new Article();
		doner.setNom("doner Kebab");
		doner.setVegetarien(true);
		doner.setDescription("Le plus grand des classiques des fins de soirée");
		doner.setPrix(8);
		doner.setRestaurant(kebab);
		doner.setImg("../assets/img/Restaurants/kebab/doner.jpg");
		doner.setTypePlat(TypePlat.Plat);
		
		Article assiette =new Article();
		assiette.setNom("Assiette Kebab");
		assiette.setVegetarien(true);
		assiette.setDescription("Une bonne assiette pleine de viande et de gras");
		assiette.setPrix(9);
		assiette.setRestaurant(kebab);
		assiette.setImg("../assets/img/Restaurants/kebab/asiet.jpg");
		assiette.setTypePlat(TypePlat.Plat);
		
		Article durum =new Article();
		durum.setNom("Durum kebab");
		durum.setVegetarien(false);
		durum.setDescription("Une revisite du plus grand des classiques des fins de soirée (juste une galette à la place du pain)");
		durum.setPrix(12);
		durum.setRestaurant(kebab);
		durum.setImg("../assets/img/Restaurants/kebab/durum.jpg");
		durum.setTypePlat(TypePlat.Plat);
		
		Article tiramisuaa =new Article();
		tiramisuaa.setNom("tiramisu");
		tiramisuaa.setVegetarien(false);
		tiramisuaa.setDescription("Une petite douceur à la crême et au café");
		tiramisuaa.setPrix(5);
		tiramisuaa.setRestaurant(kebab);
		tiramisuaa.setImg("../assets/img/Restaurants/pizzeria/tiramisu.jpg");
		tiramisuaa.setTypePlat(TypePlat.Dessert);
		
		Article fondantaa =new Article();
		fondantaa.setNom("fondant");
		fondantaa.setVegetarien(false);
		fondantaa.setDescription("Un gateau au chocolat avec son coeur fondant");
		fondantaa.setPrix(6);
		fondantaa.setRestaurant(kebab);
		fondantaa.setImg("../assets/img/Restaurants/pizzeria/fondant.jpg");
		fondantaa.setTypePlat(TypePlat.Dessert);
		
		Article cookieaa =new Article();
		cookieaa.setNom("cookie");
		cookieaa.setVegetarien(false);
		cookieaa.setDescription("Bah c'est un cookie quoi");
		cookieaa.setPrix(4);
		cookieaa.setRestaurant(kebab);
		cookieaa.setImg("../assets/img/Restaurants/pizzeria/cookie.jpg");
		cookieaa.setTypePlat(TypePlat.Dessert);
		
		Article spriteaa =new Article();
		spriteaa.setNom("sprite");
		spriteaa.setVegetarien(true);
		spriteaa.setDescription("Soda de type sprite");
		spriteaa.setPrix(2);
		spriteaa.setRestaurant(kebab);
		spriteaa.setImg("../assets/img/Restaurants/pizzeria/sprite.jpg");
		spriteaa.setTypePlat(TypePlat.Boisson);
		
		Article cocaaa =new Article();
		cocaaa.setNom("coca");
		cocaaa.setVegetarien(true);
		cocaaa.setDescription("Soda de type coca");
		cocaaa.setPrix(2);
		cocaaa.setRestaurant(kebab);
		cocaaa.setImg("../assets/img/Restaurants/pizzeria/coca.jpg");
		cocaaa.setTypePlat(TypePlat.Boisson);
		
		
		//CARTE KEBABA
		
		
		Article fritesa =new Article();
		fritesa.setNom("Frites");
		fritesa.setVegetarien(true);
		fritesa.setDescription("Des ptites frites bien sympathiques");
		fritesa.setPrix(3);
		fritesa.setRestaurant(kebaba);
		fritesa.setImg("../assets/img/Restaurants/kebab/frites.jpg");
		fritesa.setTypePlat(TypePlat.Entree);
		
		Article empanadaa =new Article();
		empanadaa.setNom("Empanada");
		empanadaa.setVegetarien(true);
		empanadaa.setDescription("Une brioche légère fourée à la viande");
		empanadaa.setPrix(4);
		empanadaa.setRestaurant(kebaba);
		empanadaa.setImg("../assets/img/Restaurants/kebab/empanada.jpg");
		empanadaa.setTypePlat(TypePlat.Entree);
		
		Article tabouleta =new Article();
		tabouleta.setNom("Taboulet");
		tabouleta.setVegetarien(true);
		tabouleta.setDescription("Parfois t'as pas boulet, parfois taboulet");
		tabouleta.setPrix(4);
		tabouleta.setRestaurant(kebaba);
		tabouleta.setImg("../assets/img/Restaurants/kebab/taboulet.jpg");
		tabouleta.setTypePlat(TypePlat.Entree);
		
		Article donera =new Article();
		donera.setNom("Doner Kebab");
		donera.setVegetarien(true);
		donera.setDescription("Le plus grand des classiques des fins de soirée");
		donera.setPrix(8);
		donera.setRestaurant(kebaba);
		donera.setImg("../assets/img/Restaurants/kebab/doner.jpg");
		donera.setTypePlat(TypePlat.Plat);
		
		Article assiettea =new Article();
		assiettea.setNom("Assiette de Kebab");
		assiettea.setVegetarien(true);
		assiettea.setDescription("Une bonne assiette pleine de viande et de gras");
		assiettea.setPrix(9);
		assiettea.setRestaurant(kebaba);
		assiettea.setImg("../assets/img/Restaurants/kebab/asiet.jpg");
		assiettea.setTypePlat(TypePlat.Plat);
		
		Article duruma =new Article();
		duruma.setNom("Durum Kebab");
		duruma.setVegetarien(false);
		duruma.setDescription("Une revisite du plus grand des classiques des fins de soirée (juste une galette à la place du pain)");
		duruma.setPrix(12);
		duruma.setRestaurant(kebaba);
		duruma.setImg("../assets/img/Restaurants/kebab/durum.jpg");
		duruma.setTypePlat(TypePlat.Plat);
		
		Article tiramisuaaa =new Article();
		tiramisuaaa.setNom("Tiramisu");
		tiramisuaaa.setVegetarien(false);
		tiramisuaaa.setDescription("Une petite douceur à la crême et au café");
		tiramisuaaa.setPrix(5);
		tiramisuaaa.setRestaurant(kebaba);
		tiramisuaaa.setImg("../assets/img/Restaurants/pizzeria/tiramisu.jpg");
		tiramisuaaa.setTypePlat(TypePlat.Dessert);
		
		Article fondantaaa =new Article();
		fondantaaa.setNom("Fondant");
		fondantaaa.setVegetarien(false);
		fondantaaa.setDescription("Un gateau au chocolat avec son coeur fondant");
		fondantaaa.setPrix(6);
		fondantaaa.setRestaurant(kebaba);
		fondantaaa.setImg("../assets/img/Restaurants/pizzeria/fondant.jpg");
		fondantaaa.setTypePlat(TypePlat.Dessert);
		
		Article cookieaaa =new Article();
		cookieaaa.setNom("Cookie");
		cookieaaa.setVegetarien(false);
		cookieaaa.setDescription("Bah c'est un cookie quoi");
		cookieaaa.setPrix(4);
		cookieaaa.setRestaurant(kebaba);
		cookieaaa.setImg("../assets/img/Restaurants/pizzeria/cookie.jpg");
		cookieaaa.setTypePlat(TypePlat.Dessert);
		
		Article spriteaaa =new Article();
		spriteaaa.setNom("Sprite");
		spriteaaa.setVegetarien(true);
		spriteaaa.setDescription("Soda de type sprite");
		spriteaaa.setPrix(2);
		spriteaaa.setRestaurant(kebaba);
		spriteaaa.setImg("../assets/img/Restaurants/pizzeria/sprite.jpg");
		spriteaaa.setTypePlat(TypePlat.Boisson);
		
		Article cocaaaa =new Article();
		cocaaaa.setNom("Coca");
		cocaaaa.setVegetarien(true);
		cocaaaa.setDescription("Soda de type coca");
		cocaaaa.setPrix(2);
		cocaaaa.setRestaurant(kebaba);
		cocaaaa.setImg("../assets/img/Restaurants/pizzeria/coca.jpg");
		cocaaaa.setTypePlat(TypePlat.Boisson);
		
		
		//CARTE ASIATQUE
		
		
		//CARTE ASIATIQUEA
		
		
		
		List<Article> macom= new ArrayList<Article>();
		macom.add(marherita);
		macom.add(coca);
		
		Commande macommande = new Commande();
		macommande.setArticles(macom);
		macommande.setClient(michel);
		macommande.setLivreur(benji);
		macommande.setStatus(Status.Enregistre);
		macommande.setRestaurant(pizzeria);
		macommande.setPrix(10);
		
		clientRepo.save(michel);
		clientRepo.save(daniel);
		clientRepo.save(justine);
		clientRepo.save(rico);
		livreurRepo.save(benji);
		restaurateurRepo.save(jeanPizz);
		restaurateurRepo.save(andreBabke);
		restaurateurRepo.save(MichMuchPizz);
		restaurateurRepo.save(JeanKebs);
		restaurateurRepo.save(WagonLit);
		restaurateurRepo.save(MarlonBrando);
		restaurateurRepo.save(MonsieurCroc);
		restaurateurRepo.save(JeanBurger);
		restaurateurRepo.save(Christina);
		restaurateurRepo.save(Christino);
		restaurantRepo.save(kebab);
		restaurantRepo.save(pizzeria);
		restaurantRepo.save(pizzeriaa);
		restaurantRepo.save(kebaba);
		restaurantRepo.save(asiatique);
		restaurantRepo.save(asiatiquea);
		restaurantRepo.save(Burger);
		restaurantRepo.save(Burgera);
		restaurantRepo.save(Espana);
		restaurantRepo.save(Espannaa);
		articleRepo.save(marherita);
		articleRepo.save(regina);
		articleRepo.save(calzone);
		articleRepo.save(gressin);
		articleRepo.save(burata);
		articleRepo.save(pancontomate);
		articleRepo.save(tiramisu);
		articleRepo.save(fondant);
		articleRepo.save(cookie);
		articleRepo.save(coca);
		articleRepo.save(sprite);
		articleRepo.save(marheritaa);
		articleRepo.save(reginaa);
		articleRepo.save(calzonea);
		articleRepo.save(gressina);
		articleRepo.save(burataa);
		articleRepo.save(pancontomatea);
		articleRepo.save(tiramisua);
		articleRepo.save(fondanta);
		articleRepo.save(cookiea);
		articleRepo.save(cocaa);
		articleRepo.save(spritea);
		articleRepo.save(frites);
		articleRepo.save(empanada);
		articleRepo.save(taboulet);
		articleRepo.save(doner);
		articleRepo.save(assiette);
		articleRepo.save(durum);
		articleRepo.save(tiramisuaa);
		articleRepo.save(fondantaa);
		articleRepo.save(cookieaa);
		articleRepo.save(cocaaa);
		articleRepo.save(spriteaa);
		articleRepo.save(fritesa);
		articleRepo.save(empanadaa);
		articleRepo.save(tabouleta);
		articleRepo.save(donera);
		articleRepo.save(assiettea);
		articleRepo.save(duruma);
		articleRepo.save(tiramisuaaa);
		articleRepo.save(fondantaaa);
		articleRepo.save(cookieaaa);
		articleRepo.save(cocaaaa);
		articleRepo.save(spriteaaa);
		commandeRepo.save(macommande);
		
	}
	
}
