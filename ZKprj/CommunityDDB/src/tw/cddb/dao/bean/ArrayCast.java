package tw.cddb.dao.bean;

import java.util.ArrayList;

public class ArrayCast<E extends Factor> {
	
	ArrayList<E> ary;
	
	public ArrayCast(ArrayList<E> ary){
		this.ary = ary;
	}
	
	public ArrayList<Factor> toFactorArray() {
		ArrayList<Factor> cast = new ArrayList<>();
		for(E d : ary){
			cast.add((Factor) d);
		}
		return cast;
	}

}
