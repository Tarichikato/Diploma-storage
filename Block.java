package tech_primers;

//import java.util.List;

public class Block {

	//On définit ce qu'il y a dans un Block

	private int previousHash;
	private Transaction[] transactions;


	//Constructeur de Block: C'est ce qui est utilisé quand on fait un "new Block"

	public Block(int previousHash, Transaction[] transactions) {
		this.previousHash = previousHash;
		this.transactions = transactions;
	}

	/*
	On a définit les composants d'un Block comme private (Lignes 9 et 10)
	Ils ne sont donc pas consultables ou modifiables en dehors de la classe 
	Classe = Ce qu'il y a entre le crochet de la ligne 5 et celui de fin
	Les 4 fonctions suivantes servent à les consulter ou les modifier 
	 */
	public int getPreviousHash() {
		return previousHash;
	}

	public void setPreviousHash(int previousHash) {
		this.previousHash = previousHash;
	}

	public Transaction[] getTransactions() {
		return transactions;
	}

	public void setTransactions(Transaction[] transactions) {
		this.transactions = transactions;
	}


	//Fonction servant à afficher les transactions d'un block
	//En gros elle appelle la fonction display de la classe Transaction sur chaque transaction du block

	public void display() {
		for ( int i = 0; i< this.transactions.length ;i++) {
			transactions[i].display();
		}
	}

	//Fonction servant à verifier si deux blocks sont identiques

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Block block = (Block) o;

		if (previousHash != block.previousHash) return false;
		return transactions != null ? transactions.equals(block.transactions) : block.transactions == null;
	}

	//Calcul du Hash du block avec le Hash du block précedent

	@Override
	public int hashCode() {
		int result = previousHash;
		result = 31 * result + (transactions != null ? transactions.hashCode() : 0);
		return result;
	}

	// Recherche d'une personne dans le block

	public int findStudent(String student) {
		int a = 0;
		for ( int i = 0; i< this.transactions.length ;i++) {
			if (transactions[i].getStudent() == student) {
				transactions[i].display();
				a++;

			}
		}
		return a;
	}

	// Recherche d'un diplome dans le block
	
	public int findDegree(String degree) {
		int a = 0;
		for ( int i = 0; i< this.transactions.length ;i++) {
			if (transactions[i].getDegree() == degree) {
				transactions[i].display();
				a++;

			}
		}
		return a;
	}
	
	//Recherche d'une année dans le block
	
	public int findYear(Long year) {
		int a = 0;
		for ( int i = 0; i< this.transactions.length ;i++) {
			if ( transactions[i].getYear().intValue() ==  year.intValue()) {
				transactions[i].display();
				a++;

			}
		}
		return a;
	}
}