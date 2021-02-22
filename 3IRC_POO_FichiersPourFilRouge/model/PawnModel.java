package model;

import java.util.LinkedList;
import java.util.List;

import nutsAndBolts.PieceSquareColor;

public class PawnModel implements PieceModel {

	private Coord coord;
	private PieceSquareColor pieceColor;

	public PawnModel(Coord coord, PieceSquareColor pieceColor) {
		super();

		this.coord = coord;
		this.pieceColor = pieceColor;

	}

	@Override
	public char getColonne() {
		char colonne = this.coord.getColonne();
		return colonne;
	}

	@Override
	public int getLigne() {
		int ligne = this.coord.getLigne();
		return ligne;
	}

	@Override
	public boolean hasThisCoord(Coord coord) {
		boolean hasThisCoord = false;

		hasThisCoord = this.coord.equals(coord);

		return hasThisCoord;
	}

	@Override
	public PieceSquareColor getPieceColor() {
		PieceSquareColor color = null;

		color = this.pieceColor;

		return color;

	}

	@Override
	public String toString() {
		return "PawnModel [coord=" + coord + ", pieceColor=" + pieceColor + "]";
	}

	@Override
	public void move(Coord coord) {

		this.coord = coord;

	}

	@Override
	public boolean isMoveOk(Coord targetCoord, boolean isPieceToCapture) {
		boolean ret = false;

		if (!isPieceToCapture) {
			if (Math.abs(targetCoord.getColonne() - getColonne()) == 1
					&& Math.abs(targetCoord.getLigne() - getLigne()) == 1) {
				if (Math.signum(targetCoord.getLigne() - getLigne()) == 1 && pieceColor == PieceSquareColor.WHITE) {
					ret = true;
				} else if (Math.signum(targetCoord.getLigne() - getLigne()) == -1
						&& pieceColor == PieceSquareColor.BLACK) {
					ret = true;
				}
			}
		} else {
			if (Math.abs(targetCoord.getColonne() - getColonne()) == 2
					&& Math.abs(targetCoord.getLigne() - getLigne()) == 2) {
				if (Math.signum(targetCoord.getLigne() - getLigne()) == 1 && pieceColor == PieceSquareColor.WHITE) {
					ret = true;
				} else if (Math.signum(targetCoord.getLigne() - getLigne()) == -1
						&& pieceColor == PieceSquareColor.BLACK) {
					ret = true;
				}
			}
		}
		return ret;
	}

	@Override
	public List<Coord> getCoordsOnItinerary(Coord targetCoord) {

		List<Coord> coordsOnItinery = new LinkedList<Coord>();

		// TODO Atelier 2

		return coordsOnItinery;
	}

}
