package fr.iclario.main;

import java.util.Scanner;

public class Resources
{
	public static String[][] nomsPourris =
		{
				{"Paolo", "Paola"},
				{"Michelin", "Micheline"},
				{"Naralin", "Naraline"},
				{"Cloportin", "Cloportine"}};

	public static void display (String string)
	{
		System.out.println(string);
	}

	public static int readInt (Scanner reader)
	{
		String string = reader.next();
		int integer;
		try
		{
			integer = Integer.parseInt(string);
		}
		catch (Exception e)
		{
			integer = -1;
		}

		return integer;
	}

	public static String firstLetterToUpper (String str)
	{
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	public static void clear ()
	{
		for (int i = 0; i<20; i++)
			display("\n");
	}

	public static void pause (Scanner reader)
	{
		reader.next();
	}
}
