/* Implement a method to perform basic string compression using the counts of repeated characters. 
 * For example, the string aabcccccaaa would become a2blc5a3. If the "compressed" string would 
 * not become smaller than the original string, your method should return the original string */

package com.DataStructures;
//imports…

public class Compressor{
	StringBuffer compressedString;
	String string2Compress;

	class CompressedChar{
		char l_char;
		short repetitions;
		public CompressedChar(char p_char){
	l_char = p_char;
	repetitions = 1;
}

public String toString(){
	return (String)(l_char + "" + repetitions);
}

public void addRepetition(){
	repetitions++;
}

public int getRepetitions(){
	return repetitions;
}

public boolean isTheSameChar(char p_char){
	return l_char == p_char;
}

public void recycleChar(char p_char){
	l_char = p_char;
	repetitions = 1;
}
}

public String compress(){
	CompressedChar compChar = null;
for(char i_char: string2Compress.toCharArray()){
		if(compChar == null)
	compChar = new CompressedChar(i_char);
else if(compChar.isTheSameChar(i_char))
			compChar.addRepetition();
		else{
			compressedString.append(compChar);
			compChar.recycleChar(i_char);
		}
}
compressedString.append(compChar);

if(compressedString.length() < string2Compress.length())
return compressedString.toString();
else 
	return string2Compress;
}

	public Compressor(String p_string2Compress){
		string2Compress = p_string2Compress;
		compressedString = new StringBuffer("");
	}

public static void main(String[] args){
	Compressor comp = new Compressor("yiiiid77rrrrr777");
	System.out.println(comp.compress());
}
}