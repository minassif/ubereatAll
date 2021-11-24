package ubereat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import ubereat.model.Adresse;
import ubereat.model.Client;
import ubereat.model.Restaurant;
import ubereat.model.Restaurateur;

@SpringBootTest
class UberBootApplicationTests {

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
		
		andreBabke.setRestaurant(kebab);
		
		Restaurant pizza = new Restaurant();
		pizza.setNom("pizzos deliros");
		pizza.setDescription("La pizza hmmm");
		pizza.setEmporter(true);
		pizza.setLivraison(true);
		pizza.setPricerange(9);
		pizza.setRate(4.0);
		pizza.setRestaurateur(jeanPizz);
		
		jeanPizz.setRestaurant(pizza);
	}

}
