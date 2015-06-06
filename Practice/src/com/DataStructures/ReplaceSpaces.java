/* Write a method to replace all spaces in a string with '%20'.
You may assume that the string has sufficient space at the end of the string to hold the 
additional characters, and that you are given the "true" length of the string. 
(Note:if implementing in Java, please use a character array so that you can perform 
this operation in place.)
*/
package com.DataStructures;

//imports… ctrl + shift + i    =)

public class ReplaceSpaces{
int i_explorer;
int i_writter;
char[] phrase;

public ReplaceSpaces(String p_phrase, int p_trueLength){
	phrase = new char[p_phrase.length()];
	for(int i=0; i < p_phrase.length() ; i++)
		phrase[i] = p_phrase.charAt(i);
	i_explorer = p_trueLength - 1;
	i_writter = i_explorer + 2 * countSpaces();
}

private int countSpaces(){
	int spaces = 0;
	for(int i=0; i<=i_explorer; i++)
		if(isSpace(phrase[i])) spaces++;
	return spaces;
}

public String convertSpaces(){
	while(!isTheEnd()){
	if(!isSpace(phrase[i_explorer]))
		moveCharacter();
	else
		moveSpace();
	}
	return String.valueOf(phrase);
}

private void moveSpace(){
	i_explorer--;
	phrase[i_writter--] = '0';
	phrase[i_writter--] = '2';
	phrase[i_writter--] = '%';
}

private void moveCharacter(){
	phrase[i_writter --] = phrase[i_explorer--];
}

public boolean isTheEnd(){
	return i_explorer >= i_writter;
}

public boolean isSpace(char p_char){
	return p_char == ' ';
}

public static void main(String[] args){
		ReplaceSpaces rp = new ReplaceSpaces("Sr. Erick Tovar                  ", "Sr. Erick Tovar".length());
		System.out.println(rp.convertSpaces());
}
}


