package tech_primers;

//import java.util.Arrays;

public class Main {
	


    public static void main(String[] args) {

        /*
        BlockChain -
        Block - Hash of Previous Block + Transactions
        Chained together.
         */
    	
    	//Definition des transactions

        Transaction transaction1 = new Transaction("Manu", "IMT BS", 2019L);
        Transaction transaction2 = new Transaction("Rudy", "Ingénieur IPParis", 2022L);
        Transaction transaction3 = new Transaction("Victor", "Ingénieur TSP", 2020L);
        Transaction transaction4 = new Transaction("Lyticia", "Ingénieur IMT Lille Douai", 2022L);
        Transaction transaction5 = new Transaction("Rudy", "50 mètres brasse", 2010L);
        Transaction transaction6 = new Transaction("Pierre", "Ingénieur IPParis", 2022L);
        Transaction transaction7 = new Transaction("Valentin", "100 mètres brasse", 2010L);
        Transaction transaction8 = new Transaction("Raph", "Ingénieur IPParis", 2022L);
        Transaction transaction9 = new Transaction("Lamia", "Ingénieur IPParis", 2022L);
        Transaction transaction10 = new Transaction("Gougou", "Ingénieur ECEParis", 2022L);
        Transaction transaction11 = new Transaction("Karolina", "Responsable Kryptosphère Paris", 2019L);
        Transaction transaction12 = new Transaction("Louis", "VP Kryptosphère Paris", 2019L);
        
        //On regroupe les transactions dans des tableaux
        
        Transaction transactionsBlock1[] = {transaction1,transaction2,transaction3};
        Transaction transactionsBlock2[] = {transaction4,transaction5,transaction6};
        Transaction transactionsBlock3[] = {transaction7,transaction8,transaction9};
        Transaction transactionsBlock4[] = {transaction10,transaction11,transaction12};
        
        /*
        Création d'une "liste chainée" (Ce n'est pas la Blockchain elle ne sert qu'a l"affichage des transactions)
        Pour comprendre son rôle aller voir dans le fichier Chain.java
        */
        
        Chain Degree = new Chain();
        
        //Création des différents blocks
         
        Block firstBlock = new Block(0, transactionsBlock1) ;        
        Block secondBlock = new Block(firstBlock.hashCode(), transactionsBlock2);      
        Block thirdBlock = new Block(secondBlock.hashCode(),transactionsBlock3);       
        Block fourthBlock = new Block(thirdBlock.hashCode(), transactionsBlock4);
        
        
        //Intégration des blocks dans la "liste chainée"
        
        Degree.add( firstBlock);
        Degree.add(secondBlock);
        Degree.add(thirdBlock);
        Degree.add(fourthBlock);
        
        //Affichage des Hash des différents blocks (Facultatif)
        
        System.out.println("first " + firstBlock.hashCode());
        System.out.println("second " + secondBlock.hashCode());
        System.out.println("third " + thirdBlock.hashCode());
        System.out.println("fourth " + fourthBlock.hashCode());
    
        
        //Recherche de personnes dans la Blockchain

        Degree.findStudent("Manu");
        Degree.findDegree("Ingénieur ECEParis");
        Degree.findYear(2019L);
        
    }
    
}