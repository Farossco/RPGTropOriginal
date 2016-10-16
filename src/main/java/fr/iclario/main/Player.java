package fr.iclario.main;

import java.util.Scanner;

public class Player
{
	private int classe; // Player classe
	private int gender; // Player gender // 0 = male / 1 = female
	private int capitalPoints; // Player capital points
	private String name;

	/**
	 * classeName[2][0][0] = "archer"
	 * classeName[2][1][0] = "archère"
	 * classeName[2][0][1] = "un"
	 * classeName[2][1][1] = "une"
	 * 1st dimension: Classe type
	 * 2nd dimension: Classe sexe
	 * 3rd dimension: Classe or pronoum
	 */
	private static String[][][] classesName =
		{
				{
						{"mage", "un"},
						{"mage", "une"}},
				{
						{"paladin", "un"},
						{"paladin", "une"}},
				{
						{"archer", "un"},
						{"archère", "une"}},
				{
						{"bla", "un"},
						{"blaette", "une"}},
				{
						{"blabla", "un"},
						{"blablaette", "une"}},
				{
						{"blablabla", "un"},
						{"blablablaette", "une"}},
				{
						{"blablablabla", "un"},
						{"blablablablaette", "une"}}};

	private static String[] caracName =
		{"intelligence", "force", "bla", "blabla", "blablabla", "blablablabla"};

	private int[] carac = new int[caracName.length];

	public Player ()
	{
		classe = 0;
		gender = 0;
		capitalPoints = 1; // TODO Changer la valeur à 20
		name = "NoName";
		for(int i : carac)
			carac[i] = 0;
	}

	public int getClasse ()
	{
		return classe;
	}

	public void setClasse (int classe)
	{
		this.classe = classe;
	}

	public boolean isMale ()
	{
		return gender == 0;
	}

	public boolean isFemale ()
	{
		return gender == 1;
	}

	public int getGender ()
	{
		return gender;
	}

	public void setGender (int gender)
	{
		this.gender = gender;
	}

	public String classeName (boolean uppercase)
	{
		return id2name(this.classe, this.gender, uppercase);
	}

	public String classePronoun (boolean uppercase)
	{
		return id2pronoun(this.classe, this.gender, uppercase);
	}

	public static String id2name (int classe, int gender, boolean uppercase)
	{
		return uppercase ? Resources.firstLetterToUpper(classesName[classe][gender][0]) : classesName[classe][gender][0];
	}

	public static String id2pronoun (int classe, int gender, boolean uppercase)
	{
		return uppercase ? Resources.firstLetterToUpper(classesName[classe][gender][1]) : classesName[classe][gender][1];
	}

	public static int getClassesNumber ()
	{
		return classesName.length;
	}

	public static int getCaracNumber ()
	{
		return caracName.length;
	}

	public void testCapital ()
	{
		Scanner reader = new Scanner(System.in);
		do
		{
			int value;

			Resources.clear();
			Resources.display("Il te reste actuellement " + capitalPoints + " point" + (capitalPoints > 1 ? "s" : "") + " de capital");
			if (capitalPoints == 0)
			{
				reader.close();
				return;
			}

			Resources.display("Que souhaitez vous augmenter ?\n");

			for(int i = 0; i < getCaracNumber(); i++)
				Resources.display(i + 1 + ". " + getCaracName(i, true) + " (" + carac[i] + " point" + (carac[i] > 1 ? "s)" : ")"));

			value = Resources.readInt(reader);

			if (value >= 1 && value <= Player.getCaracNumber()) addCarac(value - 1, 1, true);
		}
		while (capitalPoints > 0);
	}

	private void addCarac (int type, int amount, boolean decreaseCapital)
	{
		carac[type] += amount;

		if (decreaseCapital)
		{
			if (capitalPoints <= 0)
			{
				Resources.display("ERREUR ! Situation impossible ! Capital < 0 après réduction !");
				return;
			}
			capitalPoints--;
		}
	}

	public static String getCaracName (int index, boolean uppercase)
	{
		return uppercase ? Resources.firstLetterToUpper(caracName[index]) : caracName[index];
	}

	public int getCarac (int index)
	{
		return carac[index];
	}

	public void setCarac (int[] carac)
	{
		this.carac = carac;
	}

	public String getName ()
	{
		return name;
	}

	public void setName (String name)
	{
		this.name = name;
	}
}
