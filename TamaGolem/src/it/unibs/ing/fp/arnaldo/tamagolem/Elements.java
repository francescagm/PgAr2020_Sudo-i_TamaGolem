package it.unibs.ing.fp.arnaldo.tamagolem;

public enum Elements {

	ROCCIA(0),
	FUOCO(1),
	ARIA(2),
	ACQUA(3),
	ERBA(4),
	MONTAGNA(5),
	TENEBRA(6),
	SPETTRO(7),
	SCINTILLA(8),
	ACCIAIO(9);
	
	private int id;
	
	private Elements(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
