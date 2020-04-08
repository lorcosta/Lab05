package it.polito.tdp.anagrammi.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		RicercaAnagrammi ricerca= new RicercaAnagrammi();
		List<String> risultato=ricerca.trovaAnagrammi("tre");
		for(String s:risultato) {
			System.out.println(s+" ");
		}
	}

}
