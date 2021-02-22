package model;



/**
 * @author francoiseperrin
 *
 * Coordonnées des PieceModel
 */
public class Coord implements Comparable<Coord>{
	
	private char colonne; 	// ['a'..'j']
	private int ligne;		// [10..1]
	static final int MAX = ModelConfig.LENGTH;	// 10
	static final char[] COLS = {'a','b','c','d','e','f','g','h','i','j'};

	public Coord(char colonne, int ligne) {
		super();
		this.colonne = colonne;
		this.ligne = ligne;
	}

	public char getColonne() {
		return colonne;
	}

	public int getLigne() {
		return ligne;
	}


	@Override
	public String toString() {
		return "["+ligne + "," + colonne + "]";
	}


	/**
	 * @param coord
	 * @return true si 'a' <= col < 'a'+MAX et 1 < lig <= MAX
	 */
	public static boolean coordonnees_valides(Coord coord){

		boolean ret = false;

		if(coord.ligne < Coord.MAX) {
			ret = true;
		} 
		
		for(int i = 0; i < Coord.COLS.length && ret == true; i++) {
			if(coord.colonne != Coord.COLS[i]) {
				ret = false;
			} else {
				break;
			}
		}
		
		return ret;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + colonne;
		result = prime * result + ligne;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coord other = (Coord) obj;
		if (colonne != other.colonne)
			return false;
		if (ligne != other.ligne)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 * 
	 * La méthode compareTo() indique comment comparer un objet à l'objet courant
	 * selon l'ordre dit naturel
	 * Dans cet application, nous décidons que l'ordre naturel est celui 
	 * correspondant au N° de la case d'un tableau 2D représenté par la Coord
	 * ainsi le N° 1 correspond à la Coord ['a', 10], le N° 100 correspond à la Coord ['j', 1]  
	 */
	@Override
	public int compareTo(Coord o) {
		if (o.getColonne() == this.getColonne() && o.getLigne() == this.getLigne()) {
			return 0;
		} else if (this.getColonne() > o.getColonne()) {
			return 1;
		} else if (this.getColonne() == o.getColonne() && this.getLigne()  > o.getLigne()) {
			return 1;
		} else {
			return -1; 
		}
		
	}

}
