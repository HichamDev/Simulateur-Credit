package metier;

public class TestMetier {

	public static void main(String[] args) {
		CreditMetir metier=new CreditMetir();
		double m=metier.calculMensualite(200000, 240, 4.5);
		System.out.println(m);

	}

}
