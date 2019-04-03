/**
 * Glass Falling
 */
public class GlassFalling {

  // Do not change the parameters!
  public int glassFallingRecur(int floors, int sheets) {
    // Fill in here and change the return
    if(sheets == 0) 
    system.
	  
	  
	  return 0;
  }

  public class GlassFalling {

	  // Do not change the parameters!
	 
		//Compare function used in Recursive method and BottomUp method
		static int Compare(int maximize1, int maximize2) {
			if (maximize1 > maximize2) return maximize1;
			else return maximize2;
			}
		
		public int glassFallingRecur(int floors, int sheets) {

		 
		 
		 //Base case; 0 floors means that trial is done, and 1 floors means that 1 trial is needed
		 if (floors == 1 || floors == 0 ) return floors; 
		  
		 //if we only have 1 glass sheet, we can only consider the worst case(increment from 1 to highest floor that wont fail)
		 if (sheets == 1) return floors;
		 
		
		 int minimumTrial = Integer.MAX_VALUE; //set minimumTrial as a largest integer
		 int TempSolution;
		 
		 //Recursive Method(for loop, all possible ways from highest floor to first floor)
		 for (int i=1; i <= floors; i++) {
			
		//Compare two Possibilities: First one is glass sheets shatters, try shorter floor(all bottom floors by recursive)
			// second one is that glass sheets survives at that floor, try higher floor(remaining floor on top)
		    //return the smaller value between minimumTrial and TempSolution
			// *TempSolution is maximum step that will take in each circumstance)
			TempSolution = Compare(glassFallingRecur(i-1, sheets-1),  glassFallingRecur(floors-i, sheets)); 
			if (minimumTrial > TempSolution) minimumTrial = TempSolution;
			 }
		  
		 //plus one for the trial that we made in for loop
		 return minimumTrial+1;

	  }


	  // Do not change the parameters!
	 public int glassFallingBottomUp(int floors, int sheets) {
	    // Fill in here and change the return
		  int BottomUp[][] = new int [sheets+1][floors+1]; 
		    int TempSolution; 

		    // Same as recursive above, base case(0 floor no trial, 1 floor return 1)
		    
		    for (int i = 1; i <= sheets; i++) 
		    { 
		        BottomUp[i][1] = 1; 
		        BottomUp[i][0] = 0; 
		    } 
		  
		    // one glass sheet means worst case, returns floors(from first floor to highest)
		    for (int j = 1; j <= floors; j++) 
		        BottomUp[1][j] = j; 
		  
		    //for loop(without sheets =1 and floors=0 and 1)
		    for (int i = 2; i <= sheets; i++) 
		    { 
		        for (int j = 2; j <= floors; j++) 
		        { 
		           //set each array value as largest integer value for comparison later
		        	BottomUp[i][j] = Integer.MAX_VALUE; 
		           // start with only 2 floor with 2 glass sheets(two case: shatter or not shatter)
		        	//(two possibilities start at first floor or second floor)(worst case needed)
		        // build from bottom to top and compares adjacent array value(choose minimumTrial)
		        	for (int k = 1; k <= j; k++) 
		            { 
		                TempSolution = 1 + Compare(BottomUp[i-1][k-1], BottomUp[i][j-k]); 
		                if (TempSolution < BottomUp[i][j]) 
	                    BottomUp[i][j] = TempSolution;
		                
		            } 
		        } 
		    } 
		  
		    // the last array value stores the final minimumTrial times
		    return BottomUp[sheets][floors]; 

	  }


	 public static void main(String args[]){
	     GlassFalling gf = new GlassFalling();

	     // Do not touch the below lines of code, and make sure
	     // in your final turned-in copy, these are the only things printed
	     int minTrials1Recur = gf.glassFallingRecur(27, 2);
	     int minTrials1Bottom = gf.glassFallingBottomUp(27, 2);
	     // int minTrials2Recur = gf.glassFallingRecur(100, 3); 
	     //the console not gonna output anything when add this lane.. says endless for loop
	     
	     int minTrials2Bottom = gf.glassFallingBottomUp(100,3);
	     System.out.println(minTrials1Recur + " " + minTrials1Bottom);
	     System.out.println( " " + minTrials2Bottom);
	 }



	  }


  // Optional:
  // Pick whatever parameters you want to, just make sure to return an int.
  public int glassFallingMemoized() {
    // Fill in here and change the return
    return 0;
  }

