Anghel Andrei, 325CB


pt parseTree:
	-am fragmentat in cat mai multe metode, pentru a-mi usura testarea si descoperirea de 
	 eventuale erori: 
	-am implementat algoritmul pus pe site, cu diferente la verificarea prioritatii 
	 operatorului din capul stivei, pt a evita redundanta am preferat sa fac pushOp la final;
	-am folosit LineNumberReader (la cursul de I/O, doamna prof., cand ne enumera streamuri
	 si readeri, ne-a spus ca se foloseste rar, la compilatoare mai ales...): unul pentru a 
	 verifica daca fisierul are o linie (pt a determina daca am sau nu radacina generica), 
	 iar celalalt l-am folosit pt a citi din fisier si pt a obtine in orice moment linia;
	-ce nu era in algoritm si l-am determinat din fisiere de ref din tester: la prioritate 
	 se aplica si situatia "*, *", "+, +", in sensul ca expresia trebuia calculata, si op 
	 nu se adauga direct in stiva;

pt semanticVisitor: 
	-am plecat de la: +"type-checker can be implemented by a visitor that visits nodes in a 
	 MiniJava syntaxtree and builds a symbol table. For instance, the visit method handles 
	 variable declarations. It will add the variable name and type to a data structure for 
	 the current class..."; (Modern Compiler Interpretation In Java)
			  		  +"The two main tasks for the semantic analysis phase are to (a) create 
	 the name-toobject bindings for the input program, checking for declaration errors, and 
	 to (b) check the static type correctness. Both of these are implemented using the 
	 Visitor Pattern...; (http://crblp.bracu.ac.bd/papers/Compiler-Teaching-camera.pdf)
	
	-toata proiectarea si analiza am facut-o urmarind parseTree;
	-scurta descriere: +in orice program o variabila trebuie mai intai declarata ->din
	 parseTree, "=" este primul de analizat: verific daca in stanga este o variabila, si 
	 in functie de ce tip am in dreapta ii asociez un tip partii din stanga;
			   		   +daca o variabila apare in dreapta atribuirii si nu are un tip declarat 
	 in dataStruct, semnalez eroare; intrucat o variabila se poate redefini, daca deja exista 
	 in struct, i se actualizeaza tipul;
 			   		   +in cazul valorilor doar se setez tipul, numar sau bool, necesar pt 
 	 determinarea tipului la variabile;
			   		   +in program vor aparea +, respectiv *, unde trebuie sa verific ca
	 tipurile sa nu fie incompatibile, sau daca unul din ele este "null" inseamna ca eroarea
	 a fost deja semnalata;
			   		   +intrucat HashMap permite existenta unei singure chei null, daca se 
	 intalneste o eroare in program, se adauga in dataStruct o cheie null;

pt resultVisitor:
	-ca la semantic, varianta mult mai simpla;
	-am plecat de la atribuire, unde pur si simplu fac accept pe dreapta si trebuie sa imi 
	returneze o valoare, pe care o atribui variabilei din stanga, pe care o retin intr-un TreeMap;
	-adunarea si inmultirea, se trateaza identic, verific doar daca sunt int sau bool, si le
	calculez;
	-pt printare am facut o metoda care inverseaza treeMap si copiaza intr-un alt treeMap doar
	prima aparitie a fiecarei variabile;
	-se printeaza elementele al doilea treeMap;

pt printare in fisiere: 
	-in metode am facut System.out.println, afisare la consola..., iar in main am setat out pe 
	streamul de printare necesar pt fiecare exercitiu in parte (mi s-a parut mai simplu);
