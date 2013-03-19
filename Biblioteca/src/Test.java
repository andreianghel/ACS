import java.util.Scanner;


public class Test{
	public static void main(String[] args){
		Carte verif1 = new Carte("titlu", "autor", "editura", 100);
		Carte verif2 = new Carte("titlu", "autor", "editura", 100);
		Carte verif3 = new Carte("titlu1", "autor1", "editura1", 150);
		
		System.out.println("Testari1:  ");
		if(Verificari.dubluExemplar(verif1, verif2))
			 System.out.println("Dublu exemplar");
		else System.out.println("Cartile sunt diferite");
		
		System.out.println("Testari2:  ");
		System.out.println("Cartea mai groasa dintre verif1 si verif3 este: " + Verificari.maiGroasa(verif1, verif3).titlu);
		
		
		Carte obiect1 = new Carte();
		System.out.println("introduceti datele cartii: ");
		System.out.println("+introduceti titlul cartii: ");
		Scanner scan = new Scanner(System.in);
        obiect1.titlu = scan.nextLine();
        System.out.println("+introduceti autorul cartii: ");
		obiect1.autor = scan.nextLine();
        System.out.println("+introduceti editura cartii: ");
		obiect1.editura = scan.nextLine();
        System.out.println("+introduceti numarul de pagini ale cartii: ");
        obiect1.numarPagini = scan.nextInt();
        
        for(;;){
        	if(obiect1.numarPagini <= 0){
        		System.out.println("cartea nu poate avea ca numar de pagini un numar mai mic sau egal decat 0");
        		System.out.println("+reintroduceti numarul de pagini ale cartii: ");
        		obiect1.numarPagini = scan.nextInt();
        	}
        	else break;
        }
		
        System.out.println("\nCartea are urm. informatii: ");
        System.out.print("Tilul: " +obiect1.titlu.toUpperCase() + " ,Autorul: " + obiect1.autor + " ,Editura: " + obiect1.editura.toLowerCase() + " ,Numar de pagini: " + obiect1.numarPagini);
    }
}
