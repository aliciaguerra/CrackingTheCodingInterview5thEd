/*
A child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or 3 steps at a time.
Implement a method to count how many possible ways the child can go up the stairs.
*/
//The total number of ways of reaching the last step is therefore the sum of the
//number of ways of reaching each of the last three steps.
public int countWays(int n) {
if(n<0){
return 0;
} else if(n==0){
return 1; 
}else{
  return countWays(n-1) + countWays(n-2) + countWays(n-3);
}
}
