

export class Utilisateur {
    id: number;
    version: number;
    email: string;
    password: string;
    nom: string;
    prenom: string;
    tel: string;
    iban: string;
    statut: string;

    constructor(id?: number, version?: number, email?: string, password?: string, nom?: string, prenom?: string, tel?: string, iban?: string, statut?: string) {
        this.id = id;
        this.version = version;
        this.email = email;
        this.password=password;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.iban = iban;
        this.statut= statut;
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
export class Admin extends Utilisateur {
    constructor() {
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
    typeResto:string;
    

    constructor(id?: number, version?: number, nom?: string, livraison?: boolean, emporter?: boolean, open?: boolean, img?: string, description?: string, rate?: number, pricerange?: number,typeResto?:string) {
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
        this.typeResto = typeResto;
    }
}


export class Commande {
    id: number;
    version: number;
    prix: number;
    status: string;
    tempsPrep: number;
    rateResto: number;
    ratelivreur: number;


    constructor(id?: number, version?: number, prix?: number, status?: string, tempsPrep?: number, rateResto?: number, ratelivreur?: number) {
        this.id = id;
        this.version = version;
        this.prix = prix;
        this.status = status;
        this.tempsPrep = tempsPrep;
        this.rateResto = rateResto;
        this.ratelivreur = ratelivreur;
    }


}

export class ConnectDTO {
    email: string;
    password: string;

    constructor(email?: string, password?: string) {
        this.email = email;
        this.password = password;
    }
}


export class Article {
    id: number;
    version: number;
    vegetarien: boolean;
    nom: string;
    prix: number;
    description: string;
    img: string;
    typePlat: string;

    constructor(id?: number, version?: number,vegetarien?:boolean, nom?: string, prix?: number, description?: string, img?: string, typePlat?:string) {
        this.id = id;
        this.version = version;
        this.vegetarien = vegetarien;
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.img = img;
        this.typePlat=typePlat;
    }

}

