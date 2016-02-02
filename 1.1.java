//Implement an algorithm to determine if a string has all unique characters. 
//What if you cannot use additional data structures?
public boolean isUniqueChars2(String str){
  if(str.length()>128) return false; 
  //There are 128 unique ASCII characters. 
  //If the string has more than 128 characters, then some of the characters are not unique.
boolean[] char_set = new boolean[256];
for(int i=0; i<str.length(); i++) {
int val = str.charAt(i);
  //The charAt() method returns the character located at a string's specific index.
