

export class Utilisateur {
    id: number;
    version: number;
    email: string;
    passsord: string;
    nom: string;
    prenom: string;
    tel: string;
    iban: string;

    constructor(id?: number, version?: number, email?: string, password?: string, nom?: string, prenom?: string, tel?: string, iban?: string) {
        this.id = id;
        this.version = version;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.iban = iban;
    }
}

export class Client extends Utilisateur {
    cb: string;
    adresse: Adresse;
    constructor(cb?: string, adresse?: Adresse) {
        super();
        this.cb = cb;
        this.adresse = adresse;

    }
}

export class Restaurateur extends Utilisateur {
    restaurant: Restaurant;
    constructor(restaurant?: Restaurant) {
        super();
        this.restaurant = restaurant;
    }
}

export class Livreur extends Utilisateur {
    transport: string;
    rate: number;

    constructor(transport?: string, rate?: number) {
        super();
        this.transport = transport;
        this.rate = rate;
    }
}
export class Admin extends Utilisateur{
    constructor(){
        super();
    }
}

export class Adresse {
    voie: string;
    complement: string;
    codePostal: string;
    ville: string;

    constructor(voie?: string, complement?: string, codePostal?: string, ville?: string) {
        this.voie = voie;
        this.complement = complement;
        this.codePostal = codePostal;
        this.ville = ville;
    }
}

export class Restaurant {
    id: number;
    version: number;
    nom: string;
    livraison: boolean;
    emporter: boolean;
    open: boolean;
    img: string;
    description: string;
    rate: number;
    pricerange: number;

    constructor(id?: number, version?: number, nom?: string, livraison?: boolean, emporter?: boolean, open?: boolean, img?: string, description?: string, rate?: number, pricerange?: number) {
        this.id = id;
        this.version = version;
        this.nom = nom;
        this.livraison = livraison;
        this.emporter = emporter;
        this.open = open;
        this.img = img;
        this.description = description;
        this.rate = rate;
        this.pricerange = pricerange;
    }
}


export class Commande{
    id: number;
    version: number;
    prix: number; 
    status: string;
    tempsPrep: number;
    rateResto: number;
    ratelivreur: number;
  

    constructor(id?:number, version?:number, prix?:number, status?:string, tempsPrep?:number, rateResto?:number, ratelivreur?:number){
        this.id=id;
        this.version=version;
        this.prix=prix;
        this.status=status;
        this.tempsPrep=tempsPrep;
        this.rateResto=rateResto;
        this.ratelivreur=ratelivreur;
    }


}

export class ConnectDTO{
    username: string;
    password: string;

    constructor(username?: string, password?: string) {
        this.username = username;
        this.password = password;
    }
}

