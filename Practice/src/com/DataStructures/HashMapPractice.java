package com.DataStructures;

import java.util.HashMap;

/**
 * @author Tovar
 *
 */

public class HashMapPractice {
	
	public class Human{
		private String name;
		private int age;
		
		public Human(String name) {
			super();
			this.name = name;
			age = 0;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

		
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "Human [name=" + name + ", age=" + age + "]";
		}
		
		
	}
	
	public class Mexican extends Human{
		private String curp;
		
		public Mexican(String p_curp, String p_name){
			super(p_name);
			curp = p_curp;
		}

		public String getCurp() {
			return curp;
		}
		public void setCurp(String curp) {
			this.curp = curp;
		}

		@Override
		public String toString() {
			return super.toString() + "\n\tMexican [curp=" + curp + "]";
		}

		
		
	}
	
	//HashMap implementation using a String Key
	public class BirthRegistry{
		HashMap<String, Human> registry;
		
		public BirthRegistry() {
			registry = new HashMap<String, Human>();
		}

		public HashMap<String, Human> getRegistry() {
			return registry;
		}

		public void setRegistry(HashMap<String, Human> registry) {
			this.registry = registry;
		}	
		
		public boolean addNewBorn(Human p_human){
			if(p_human instanceof Mexican){
				if(getRegistry().containsKey( ((Mexican)p_human).getCurp()) )
					return false;
				else{
					getRegistry().put(((Mexican)p_human).getCurp(), p_human);
					System.out.println("Added mexican: " + ((Mexican)p_human));
					return true;
				}
			}
			return false;
		}
		
	}
	
	public static void main(String [] args){
		HashMapPractice newPractice = new HashMapPractice();
		BirthRegistry bRegistry = newPractice.new BirthRegistry();
		bRegistry.addNewBorn(newPractice.new Mexican("TOME12345678", "Erick"));
	}
	
	//TODO: DeathRegistry
	
}
