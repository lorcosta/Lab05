package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class RicercaAnagrammi {
	private AnagrammaDAO dao= new AnagrammaDAO();
	private Map<String,String> anagrammi;
	
	/**
	 * Genera tutti gli anagrammi di una parola data in input
	 * @param parola da anagrammare
	 * @return {@link Map} che contiene nel keySet() un elenco di angrammi 
	 * corretti (attenzione che gli anagrammi sono intervallati da valori di null
	 * dove in corrispondenza è presente un values() che corrisponde ad un anagramma errato. 
	 * Es. Key:tre-->Value:null; Key:null-->Value:ert
	 */
	public Map<String,String> trovaAnagrammi(String parola){
		this.anagrammi=new HashMap<String,String>();
		parola=parola.toUpperCase();
		List<Character> caratteri= new ArrayList<Character>();
		for(int i=0;i<parola.length();i++) {
			caratteri.add(parola.charAt(i));
		}
		this.ricerca("", caratteri);
		
		return anagrammi;
	}
	/**
	 * Procedura privata ricorsiva per trovare gli anagrammi di una parola,
	 * richiama se stessa e ad ogni richiamo aggiunge un carattere e quando 
	 * ha finito i tentativi per un determinato ramo ovvero ha usato tutti i 
	 * caratteri torna indietro ed esplora un'altra soluzione data dall'uso di 
	 * altri caratteri
	 * @param parziale è la soluzione al quale mi trovo
	 * @param caratteri è l'insieme di caratteri che ho attualmente disponibili
	 * @return il metodo non ritorna nulla ma quando si trova all'ultimo livello, ovvero 
	 * quando caratteri.size()==0 aggiunge l'anagramma trovato all'insieme di quelli da ritornare
	 */
	private void ricerca(String parziale,List<Character> caratteri ) {
		if(caratteri.size()==0) {
			if(dao.isCorrect(parziale)) {
				this.anagrammi.put(parziale,null);
				return;
			}else this.anagrammi.put(null,parziale);
		}
		for(Character c:caratteri) {
			String tentativo=parziale+c;
			List<Character> caratteriAggiornati= new ArrayList<>(caratteri);
			caratteriAggiornati.remove(c);
			ricerca(tentativo,caratteriAggiornati);
		}
	}
}
