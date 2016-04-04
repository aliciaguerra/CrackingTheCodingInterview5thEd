/*1.5 Implement a method to perform basic string compression using
the counts of repeated characters. For example, the string 
aabcccccaaa would become a2b1c5a3. If the "compressed" string would
not become smaller than the original string, your method should return
the original string. You can assume the string has only upper and lower
case letters (a-z). */

/*At first glance, implementing this method seems fairly straightforwrd,
but perhaps a bit tedious. We iterate through the string, copying
characters to a new string and counting the repeats. How hard could
it be? */

public String compressBad(String str) {
	String mystr = "";
	char last = str.charAt(0);
	int count = 1;
	for(int i=1; i<str.length(); i++) {
		if(str.charAt(i) == last) { //found repeat char
			count++;
		} else { //insert char count, and update last char
		mystr += last + "" + count;
		last=str.charAt(i);
		count=1;
		   }
		  }
		return my str+last+count;
    }
    
/*This code doesn't handle the case when the computed string is longer than the original string, but it otherwise
works. Is it efficient though? Take a look at the runtime of this code. The runtime is O(p+k^2), where p is the
size of the original string and k is the number of character sequences. It's slow because the string concatenation
operates in O(n^2) time.*/

/*We can make this somewhat better by using a string buffer.*/

String compressBetter(String str) {
 /*Check if compression would create a longer string.*/
 int size = countCompression(str);
 if(size>=str.length()) {
 return str;
 }
 
 StringBuffer mystr = new StringBuffer();
 char last = str.charAt(0);
 int count = 1;
 for(int i=1; i< str.length(); i++) {
 if(str.charAt(i) == last) { //Found repeated char
 count++;
 } else { //Update char count, and update last one
 mystr.append(last);
 mystr.append(count);
 last = str.charAt(i);
 count = 1;
  }
 }
 
 /*In lines 15-16 above, characters are inserted when the repeated character chanches. We need to update
 the string at the end of the method as well, since the very last set of repeated characters wouldn't be
 set in the compressed string of characters yet.*/
 mystr.append(last);
 mystr.append(count);
 return mystr.toString();
}

int countCompression(String str) {
 if(str==null || str.isEmpty()) return 0;
 char last = str.charAt(0);
 int size = 0;
 int count =1;
 for(int i=1; i<str.length(); i++) {
 	if(tr.charAt(i)==last){
 		count++;
 	} else {
 		last = str.charAt(i);
 		size += 1 +String.valueOf(count).length();
 		count = 1;
 	}
 	}
 	size += 1 + String.valueOf(count).length();
 	return size;
 }
}

/*If we don't want to (or aren't allowed to) use a StringBuffer, we can still solve this problem efficiently.
In line 2, we compute the end size of the string. This allows us to create a char array of the correct size,
so we can implement the code as follows: */ 

String compressAlternate(String str) {
	/*Check if compression would create a longer string*/
	int size = countCompression(str);
	if(size>= str.length()) {
		return str;
	}
	
	char[] array = new char[size];
	int index = 0;
	char last = str.charAt(0);
	int count = 1;
	for(int i=1; i<str.length(), i++) {
		if(str.charAt(i) == last) { //Found repeated characters
		count++;
	} else {
		/*Update the requested character count.*/
		index = setChar(array, last, index, count);
		last = str.charAt(i);
		count = 1;
	}
	}
	
	/*Update the string with the last set of repeated characters.*/
	index = setChar(array, last, index, count);
	//Returns the string representation of character array
	return String.valueOf(array);
}

int setChar(char[] array, char c, int index, int count) {
	array[index] = c;
	index++;
	
	/*Convert the count to a string, then to an array to chars*/
	char cnt = String.valueOf(count).toCharArray();
	
	/*Copy characters from biggest digit to smallest.*/
	for(char x: cnt) {
		array[index] = x;
		index++;
	}
	return index;
}

int countCompression(String str) {/*same as earlier*/}
