package it.polito.tdp.quadrato;

import java.util.ArrayList;
import java.util.List;

public class CercaQuadrato {

	public CercaQuadrato() {
	}

	List<Quadrato> soluzioni;
	
	public void genera(int size) {
		Quadrato parziale = new Quadrato(size) ;
		this.soluzioni= new ArrayList<Quadrato>() ;
		this.cerca(parziale, 0);
		
	}
	
	private void cerca(Quadrato parziale, int L) {
		
		if(L == parziale.getSize()*parziale.getSize()) { //il quadrato è completo se il livello è uguale alla dimensione del quadrato
			
			if (parziale.isMagic()) {
				System.out.println(parziale) ;
				soluzioni.add(parziale.clone());
			}
			return;
		}
		
		//altri casi
			
		for (int i = 1; i <= parziale.getSize() * parziale.getSize(); i++) {
			// provo a mettere il valore 'i' nella casella 'L'

			if (!parziale.contains(i)) {
				parziale.add(i);

				cerca(parziale, L + 1);

				parziale.remove(i);
			}
		}
	}
	
}
