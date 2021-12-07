package ubereat.model;



public class Views {

	public static class ViewCommon {
	}
	
	public static class ViewArticle extends ViewCommon {
	}
	
	public static class ViewArticlePrixAsc extends ViewArticle {
	}
	
	public static class ViewArticlePrixDesc extends ViewArticle {
	}
	
	public static class ViewClient extends ViewCommon {
	}
	
	public static class ViewCommande extends ViewCommon {
	}
	
	
	public static class ViewLivreur extends ViewCommon {
	}
	
	public static class ViewRestaurant extends ViewCommon {
	}
	public static class ViewRestaurantWithCommande extends ViewRestaurant {
	}
	
	public static class ViewRestaurantWithArticle extends ViewRestaurant {
	}
	
	public static class ViewRestaurantWithRestaurateur extends ViewRestaurant {
	}
	
	public static class ViewRestaurateur extends ViewCommon {
	}
	
	public static class ViewTypePlat extends ViewCommon {
	}
	
	public static class ViewTypeResto extends ViewCommon {
	}
	
	public static class ViewUtilisateur extends ViewCommon {
	}
	public static class ViewRestaurantWithPrix extends ViewRestaurant{	
	}
	
	public static class ViewCommandeDetail extends ViewCommande {
	}
}
