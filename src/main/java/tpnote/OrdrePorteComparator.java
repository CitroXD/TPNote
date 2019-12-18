package tpnote;

import java.util.Comparator;

public class OrdrePorteComparator implements Comparator<Porte>{

	public int compare(Porte P1, Porte P2) {
		return(P1.getNumero()-P2.getNumero());
	}

}
