public class Test {
	int zawartosc = 0;	// przechowywane na stercie
	
	/* Podczas gdy "zmienna" jest referencja do obiektu przekazywanego do metody
	 * i nie może zacząć wskazywac na inny obiekt, to zawartość tego obiektu może
	 * ulec zmianie. Tyczy sę to obiektów finalnych jak i zwykłych. */
	static void argNiemodyfikowalny(final Test zmienna) {
		zmienna.zawartosc = 1;
		// zmienna = null;	// Nie można zmienić referencji obiektu final
	}
	
	/* Argument przekazany jest przez referencję co oznacza że "zmienna" jest
	 * tylko referencją do obiektu i przypisywanie jest wartości null spowoduje,
	 * że nie będzie wskazywała już na ten obiekt, natiomiast sam obiekt w tym
	 * momencie pozostanie w pamięci */
	static void argModyfikowalny(Test zmienna) {
		zmienna.zawartosc = 1;
		zmienna = null;
	}
	
	public static void main(String[] args) {
		// przechowywane na stosie są referencje (nie)modyfikowalna
		// przechowywane na stercie są obiekty Test()
		Test modyfikowalna = new Test();
		final Test niemodyfikowalna = new Test();
		
		argNiemodyfikowalny(modyfikowalna);
		System.out.println(modyfikowalna.zawartosc);	// 1
		
		argNiemodyfikowalny(niemodyfikowalna);
		System.out.println(niemodyfikowalna.zawartosc);	// 1
		
		argModyfikowalny(modyfikowalna);
		System.out.println(modyfikowalna.zawartosc);	// 1
		
		argModyfikowalny(niemodyfikowalna);
		System.out.println(niemodyfikowalna.zawartosc);	// 1
	}
}
