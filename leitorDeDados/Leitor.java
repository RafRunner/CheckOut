package leitorDeDados;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import backEnd.Produto;

public class Leitor {

	public static ArrayList<String> regexSearchList(String texto, String regex)
	{
		ArrayList<String> resultado = new ArrayList<String>();
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(texto);
		
		while(matcher.find()) {
			String match = matcher.group();
			
			resultado.add(match);
		}
		
		return resultado;
	}
	
	public static String regexSearch(String texto, String regex)
	{
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(texto);
		
		if(matcher.find()) {
			return matcher.group();
		}
		else {
			return "";
		}
	}
	
	public static boolean regexCheck(String texto, String regex)
	{
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(texto);
		
		return matcher.find();
	}
	
	public static ArrayList<String> lerArquivo(String fileName)
	{
		ArrayList<String> linhas = new ArrayList<String>();
		File file = new File(fileName);

		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNextLine()) {
				String linha = scanner.nextLine();
				linhas.add(linha);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		return linhas;
	}
	
	public static void printArray(ArrayList<String> list)
	{
		for(String linha : list) {
			System.out.println(linha);
		}
	}
	
	public static String arrayToString(ArrayList<String> array)
	{
		StringBuilder string = new StringBuilder();
		
		for(String linha : array) {
			string.append(linha);
			string.append("\n");
		}
		return string.toString();
	}
}
