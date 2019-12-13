package tech_primers;

public class Transaction {

	//On définit ce qu'il y a dans une Transaction

	private String student;
	private String degree;
	private Long year;

	//Constructeur de Transaction: C'est ce qui est utilisé quand on fait un "new Transaction"


	public Transaction(String student, String degree, Long year) {
		this.student = student;
		this.degree = degree;
		this.year = year;
	}

	/*
		On a définit les composants d'une Transaction comme private (Lignes 7 à 9)
		Ils ne sont donc pas consultables ou modifiables en dehors de la classe 
		Classe = Ce qu'il y a entre le crochet de la ligne 3 et celui de fin
		Les 6 fonctions suivantes servent à les consulter ou les modifier 
	 */

	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}


	//Fonction servant à verifier si deux transactions sont identiques

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Transaction that = (Transaction) o;

		if (student != null ? !student.equals(that.student) : that.student != null) return false;
		if (degree != null ? !degree.equals(that.degree) : that.degree != null)
			return false;
		return year != null ? year.equals(that.year) : that.year == null;
	}

	//Calcul du Hash d'une transaction

	@Override
	public int hashCode() {
		int result = student != null ? student.hashCode() : 0;
		result = 31 * result + (degree != null ? degree.hashCode() : 0);
		result = 31 * result + (year != null ? year.hashCode() : 0);
		return result;
	}

	//Affichage d'une transaction 

	public void display() {
		System.out.println(this.student + " s'est vu decerner le diplôme " + this.degree + " en " + this.year);
	}


}


