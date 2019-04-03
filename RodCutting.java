/**
 * Rod cutting problem described in Chapter 15 of textbook
 */
public class RodCutting {
   
	
	public int Compare(int maximize1, int maximize2) {
	if (maximize1 > maximize2) return maximize1;
	else return maximize2;
	}
		
  // Do not change the parameters!
  public int rodCuttingRecur(int rodLength, int[] lengthPrices) {
      //if there is no remaining rod, return 0, base case
	  if (rodLength <= 0) {
    	  return 0; 
      }
      
	  int MaximumValue = 0;
     //for loop start with i= 0, up to rodLength-1 which is the index of last value in lengthPrice
	  // all possibilities of first cut from 1 to maximum, then second cut, etc.
	  for (int i = 0; i < rodLength; i++) {
      int tempMax = lengthPrices[i]+ rodCuttingRecur(rodLength-i-1, lengthPrices); 
      //rodLength-1 for lengthPrices at index i = 0
      //Compare tempMax to the value that was stored before, choose biggest maximum Value
      MaximumValue = Compare(MaximumValue, tempMax);
      }
      
      return MaximumValue;
  }  

  // Do not change the parameters!
  public int rodCuttingBottomUp(int rodLength, int[] lengthPrices) {
	 
	  int TempMax[] = new int [rodLength+1];
	 //base case 
	  TempMax[0] = 0;
	  // first store the price of each length to new array
	  for (int k=0; k <= rodLength; k++) {
		  if (k==0) TempMax[k] = 0;
		  else TempMax[k] = lengthPrices[k-1];
	  }
      // compare the stored price value in TempMax array to price value by separating the rod
	  //the length of rod from 1 to rodLength, each value stored in previous index of array is
	  // maximum earning from selling rod at length 1,2,3...to its total length.
	  for (int i=1; i <rodLength +1; i++) {
		 for (int j=0; j<=i ; j++) {
			TempMax[i] = Compare(TempMax[i],TempMax[i-j]+ TempMax[j]);
			
		 }
			
	  }
	  return TempMax[rodLength];
  }


  public static void main(String args[]){
      RodCutting rc = new RodCutting();

      // In your turned in copy, do not touch the below lines of code.
      // Make sure below is your only output.
      int length1 = 7;
      int[] prices1 = {1, 4, 7, 3, 19, 5, 12};
      int length2 = 14;
      int[] prices2 = {2, 5, 1, 6, 11, 15, 17, 12, 13, 9, 10, 22, 18, 26};
      int maxSell1Recur = rc.rodCuttingRecur(length1, prices1);
      int maxSell1Bottom = rc.rodCuttingBottomUp(length1, prices1);
      int maxSell2Recur = rc.rodCuttingRecur(length2, prices2);
      int maxSell2Bottom = rc.rodCuttingBottomUp(length2, prices2);
      System.out.println(maxSell1Recur + " " + maxSell1Bottom);
      System.out.println(maxSell2Recur + " " + maxSell2Bottom);
  }
}
