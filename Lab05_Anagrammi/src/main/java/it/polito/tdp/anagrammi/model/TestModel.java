package it.polito.tdp.anagrammi.model;

import java.util.List;
import java.util.Map;

public class TestModel {

	public static void main(String[] args) {
		RicercaAnagrammi ricerca= new RicercaAnagrammi();
		Map<String,String> risultato=ricerca.trovaAnagrammi("tre");
		for(String s:risultato.keySet()) {
			System.out.println(s+" ");
		}
	}

}
