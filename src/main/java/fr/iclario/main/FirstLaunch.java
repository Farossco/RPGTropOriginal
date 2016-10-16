package fr.iclario.main;

import java.util.Scanner;

public class FirstLaunch
{
	public static Player firstLaunch ()
	{
		int value;

		Scanner reader = new Scanner(System.in); // Déclaration du scanner pour la lecture des entrées de l'utilisateur
		Player player = new Player(); // Inititialisation du joueur

		do
		{
			Resources.clear();
			Resources.display("Bienvenue soldat !");
			Resources.display("Bon, tout d'abord, j'ai beau te regarder mais c'est pas très clair, t'es un garçon ou une fille ?\n"); // Du texte...

			Resources.display("1. Je suis un garçon bien virile !");
			Resources.display("2. Je suis une gentille petite fille");
			value = Resources.readInt(reader);
		}
		while (value < 1 || value > 2);  // On recommence tant que la valeur est incorrect

		player.setGender(value - 1); // Définition du sexe du joueur (0 = Male // 1 = Female)

		do
		{
			Resources.clear();
			Resources.display((player.isMale() ? "Un garçon hein..." : "Une fille hein...") + " Très bien, je le savais...");
			Resources.display("Hmm... une dernière question, t'appartiens à quelle classe au juste ?\n"); // Du texte...

			for(int i = 0; i < Player.getClassesNumber(); i++)
				Resources.display(i + 1 + ". Je suis " + Player.id2pronoun(i, player.getGender(), false) + " " + Player.id2name(i, player.getGender(), false));

			value = Resources.readInt(reader);
		}
		while (value < 1 || value > Player.getClassesNumber()); // On recommence tant que la valeur est incorrect

		player.setClasse(value - 1); // Définition de la classe du joueur (cf. Player.classesName)

		Resources.clear();
		Resources.display("Très bien, jeune " + player.classeName(false) + ", tu est donc " + (player.isMale() ? "prêt" : "prète") + " à partir à l'aventure\n");
		Resources.display("1. Oui !");
		Resources.pause(reader);
		Resources.clear();
		Resources.display("Parfait ! Nous allons donc procéder à la répartition de tes points de capital\n");
		Resources.display("1. Ok chef !");
		Resources.pause(reader);
		Resources.clear();
		// Du texte...

		player.testCapital(); // Utilisation des points de capital

		Resources.clear();
		Resources.display("Très bien soldat" + (player.isMale() ? "" : "e") + " ! Tu est fin " + (player.isMale() ? "prêt" : "prète") + " pour l'aventure !\n");
		Resources.display("1. C'est partit !");
		Resources.pause(reader);
		Resources.clear();
		Resources.display("Attend !\n");
		Resources.display("1. Oui ?");
		Resources.pause(reader);

		do
		{
			int i;
			Resources.clear();
			Resources.display("Avec toute cette exitation, j'en ai oublié de te demander ton nom !");
			Resources.display("Bon, tu t'appeles comment ?\n");

			for(i = 0; i < Resources.nomsPourris.length; i++)
				Resources.display(i + 1 + ". " + Resources.nomsPourris[i][player.getGender()]);

			Resources.display(i + 1 + ". C'est quoi ces noms tout pourris ?");

			value = Resources.readInt(reader);
		}
		while (value < 1 || value > Resources.nomsPourris.length + 1);

		if (value == Resources.nomsPourris.length + 1)
		{

		}
		else
		{
			player.setName(Resources.nomsPourris[value - 1][player.getGender()]);
		}
		
		Resources.display(player.getName());
  
		reader.close();

		return player;
	}
}
