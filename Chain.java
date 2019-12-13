package tech_primers;

/*
Pour faire des recherches dans la blockchain on utilise une "liste chainée"
Le principe est que la chaine contient un seul Node
Pour ajouter un nouvel élement ( du type Node ) à la chaine on fait en sort que le nouveau
Node fasse référence au Node de la chaine
Ensuite on remplace le Node de la chaine par le nouveau qui lui fait référence

Ainsi à la fin on à le dernier noeud (Node) ajouté qui fait référence à l'avant dernier qui fait référence au précedent 
et ainsi de suite

 */

public class Chain {

	// On définit ce qu'il y a dans une chaine

	Node first;

	//Constructeur de Chaine : C'est ce qui est utilisé quand on fait un "new Chaine"

	public  Chain () {
		this.first = null;
	}

	/*
	On a définit les composants d'un Block comme private (Ligne 19)
	Ils ne sont donc pas consultables ou modifiables en dehors de la classe 
	Classe = Ce qu'il y a entre le crochet de la ligne 15 et celui de fin
	Les 2 fonctions suivantes servent à les consulter ou les modifier 
	 */

	public Node getFirst() {
		return first;
	}



	public void setFirst(Node first) {
		this.first = first;
	}



	//Permet d'ajouter un block à la chaine
	public void add (Block block) {

		//Le premier Node de la chaine deviens un Node contenant le Block que l'on veux rajouter et faisant référence
		// à l'ancien premier Node
		this.first = new Node(block, this.first);
	}

	//Permet d'afficher le contenu de la chaine

	public  void display() {
		Node cur=this.first;
		while (cur != null) {
			cur.getBlock().display();
			cur=cur.getNext();
		}


	}

	//Permet de rechercher une personne dans la chaine

	public void findStudent(String student) {
		Node cur=this.first;
		int a = 0;
		while (cur != null) {
			a = a + cur.getBlock().findStudent(student);
			cur=cur.getNext();
		}
		if (a == 0) {
			System.out.println("Je n'ai aucune réference à " + student + " dans mes données ");
		}
	}

	//Permet de rechercher les titulaires d'un diplome dans la chaine

	public void findDegree(String degree) {
		Node cur=this.first;
		int a = 0;
		while (cur != null) {
			a = a + cur.getBlock().findDegree(degree);
			cur=cur.getNext();
		}
		if (a == 0) {
			System.out.println("Je n'ai aucun titulaire de " + degree + " dans mes données ");
		}
	}

	//Permet de rechercher les diplomes d'une année dans la chaine

	public void findYear(Long year) {
		Node cur=this.first;
		int a = 0;
		while (cur != null) {
			a = a + cur.getBlock().findYear(year);
			cur=cur.getNext();
		}
		if (a == 0) {
			System.out.println("Je n'ai aucun diplome de " + year + " dans mes données");
		}
	}

}