package tech_primers;



public class Node {
	
	//On définit ce qu'il y a dans un Node
	
	private Block block;
	private Node next;
	
	//Constructeur de Node: C'est ce qui est utilisé quand on fait un "new Node"
	
	public Node (Block block, Node next) {
		this.block = block;
		this.next = next;
	}
	
	/*
	On a définit les composants d'un Node comme private (Lignes 9 et 10)
	Ils ne sont donc pas consultables ou modifiables en dehors de la classe 
	Classe = Ce qu'il y a entre le crochet de la ligne 5 et celui de fin
	Les 4 fonctions suivantes servent à les consulter ou les modifier 
	*/

	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	
}
