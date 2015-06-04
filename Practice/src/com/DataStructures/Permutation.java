/**
 * 
 */
package com.DataStructures;

import java.util.HashMap;

/**
 * @author Tovar
 *
 */

//Verify if a String is a permutation of another String
public class Permutation {
	private HashMap<Character, Integer> map;
	
	public Permutation(){
		map = new HashMap<Character, Integer>();
	}
	
	private void addString2Map(String p_cadena){
		for(char cha: p_cadena.toCharArray()){
			if(!map.containsKey(cha))
				map.put(cha, 1);
			else
				map.put(cha, map.get(cha)+1);
		}
	}
	
	private void removeString2Map(String p_cadena){
		for(char cha: p_cadena.toCharArray()){
			if(map.containsKey(cha)){
				if(map.get(cha)>1)
					map.put(cha, map.get(cha)-1);
				else
					map.remove(cha);
			}
		}
	}
	
	private boolean isMapEmpty(){
		return map.isEmpty();
	}
	
	public static void main(String[] args){
		Permutation permut = new Permutation();
		permut.addString2Map("Erick");
		permut.removeString2Map("kirEc");
		if(permut.isMapEmpty())
			System.out.println("Im a permutation!");
		else
			System.out.println("Im not a prmutation...");
	}
}
