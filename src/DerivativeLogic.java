import java.util.ArrayList;
import java.util.Arrays;

public class DerivativeLogic {
	/*	
	take the derivative of the input from user @@implement@@ it for analysis section
	this is just for testing layout for second degree polys in quadratic form ax^b+cx+d
	!!Alert!! don't need to turn on MySql for testing derivatives 
	takeDerivative -> formatDerivString -> formatFinalDeriv
	*/
	public String takeDerivative(String formula) {
		int a = 0,b = 0,c = 0,d = 0;
		int firstDeriv, exponentDeriv;
		String firstStringDeriv, secondStringDeriv;
		String[] middleArr;
		String[] formulaArr = formula.split("x");
		
		if(isInteger(Integer.toString(a)) == true && a == 0) {
			a = Integer.parseInt(formulaArr[0]);
		} else {
			a=1;
		}
		middleArr = formulaArr[1].split("");
		//return the value to b 
		System.out.println(Arrays.toString(middleArr));
		for(int i = 0; i < middleArr.length; i++) {
			if(isInteger(middleArr[i]) == true) {
				b = Integer.parseInt(middleArr[i]);
				System.out.println("this is b" + b);
				//break after first int is found and assign to b 
				break;
			} else {
				b = 1;
			}
		}
		//assigns the left over ints to vars
		if(isInteger(middleArr[middleArr.length-1]) == true && c == 0) {
			System.out.println(middleArr[middleArr.length-1] + " ");
			c = Integer.parseInt(middleArr[middleArr.length-1]);
		} else {
			c = 1;
		}
		
		d = formulaArr.length;
		firstDeriv = a*b;
		exponentDeriv = b-1;
		firstStringDeriv = Integer.toString(firstDeriv) + "x";
		//connects the pieces and returns the string to forntend 
		secondStringDeriv = firstStringDeriv + "^" + exponentDeriv + "+" + Integer.toString(c);
		return secondStringDeriv;
		//formatDerivString(secondStringDeriv);
	}
	//takes derivative and formats the string neatly 
	//need more polynumeralsthat are non quadratic 
	public void formatDerivString(String str) {
		String[] derivArr = str.split("");
		int[] finalDerivArr = null;
		ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.println(Arrays.toString(derivArr));
		for(int i = 0; i < derivArr.length; i++) {
			if(isInteger(derivArr[i])) {
				list.add(Integer.parseInt(derivArr[i]));
			}
		}
		formatFinalDeriv(list);
	}
	/*	Need replace stringlist[i] with its self or x if it is one
	 * Do this first */
	public void formatFinalDeriv(ArrayList<Integer> list) {
		ArrayList <String> stringList = new ArrayList<String>();
		int i = 0;
		while(i < list.size()) {
			if(list.get(i) == 1) {
				stringList.add("x");
			} else {
				
			}
			i++;
		}
		System.out.println(stringList);
	}
	//return value for take derivative 
	public boolean isInteger( String input ) { //Pass in string
	    try { //Try to make the input into an integer
	        Integer.parseInt( input );
	        return true; //Return true if it works
	    }
	    catch( Exception e ) { 
	        return false; //If it doesn't work return false
	    }
	}
}
