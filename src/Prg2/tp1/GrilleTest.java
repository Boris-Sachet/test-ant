package Prg2.tp1;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GrilleTest
{

	private Grille g1, g2 ;
	private int hauteur, largeur ;

	@Before
	public void setUp() throws Exception
	{
		hauteur = 10 ;
		largeur = 10 ;
		g1 = new Grille(hauteur, largeur) ;
		g2 = new Grille(hauteur+1, largeur+1) ;
		System.out.println("Test de " + g1.getClass().getName()) ;
	}

	@Test
	public void testHauteurLargeur()
	{
		assertEquals ("La hauteur est égale au 1er paramètre du constructeur",
				hauteur, g1.getHauteur()) ;
		assertEquals ("La largeur est égale au 2e paramètre du constructeur",
				largeur, g1.getLargeur()) ;
	}

	@Test
	public void testCellule()
	{
		try
		{for (int l=1; l<=g1.getHauteur(); l++)
			{
				String ch1 = Integer.toString(l);
				for (int c=1; c<=g1.getLargeur(); c++)
				{
					String ch2 = ch1 + ',' + Integer.toString(c) ;
					g1.setCellule(l, c, ch2) ;
					g2.setCellule(l, c, ch2 + "x");
					assertEquals("La valeur restituée doit être la valeur enregistrée",
										ch2, g1.getCellule(l, c)) ;
				}
			}
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			fail("L'indice de tableau ne doit pas dépasser hauteur-1 (resp. largeur-1");
		}
	}

	@Test
	public void testPreconditions()
	{
		boolean testOK = false ;
		// Précondition de hauteur
		try
		{
			System.out.println("test    1");
			new Grille(-4, 5) ;
			testOK = false ;
			System.out.println("testNOK 1");
		}
		catch (AssertionError e){ testOK = true ; }
		assertTrue("Une hauteur négative doit déclencher une AssertionError", testOK) ;

		// Précondition de largeur
		try
		{
			System.out.println("test    2");
			new Grille(4, -5) ;
			testOK = false ;
			System.out.println("testNOK 2");
		}
		catch (AssertionError e){ testOK = true ; }
		assertTrue("Une largeur négative doit déclencher une AssertionError", testOK) ;

		// Précondition de 1ère coordonnée de cellule
		try
		{
			System.out.println("test    3");
			g1.setCellule(hauteur+1, 1, "hgjhgjhg");
			testOK = false ;
			System.out.println("testNOK 3");
		}
		catch (AssertionError e){ testOK = true ; }
		assertTrue("Tout non-respect des bornes doit causer une AssertionError", testOK) ;

		// Précondition de 2ème coordonnée de cellule
		try
		{
			System.out.println("test    4");
			g1.setCellule(1, -1, "hgjhgjhg");
			testOK = false ;
			System.out.println("testNOK 4");
		}
		catch (AssertionError e){ testOK = true ; }
		assertTrue("Tout non-respect des bornes doit causer une AssertionError", testOK) ;
	}
}
