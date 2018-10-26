import java.util.ArrayList;
import java.util.Scanner;

//this is the main logic for finding prime numbers 
public class PrimeLogic {

	//the main call for prime looking through static array 
	public void findPrime() {
		//test array
		int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		String result = "";
		Scanner Keyboard = new Scanner(System.in);
		System.out.println("use static array type num or enter numebr? enter");
		result = Keyboard.nextLine();
		int input = 0;
		if(result.equals("enter")) {
			input = Keyboard.nextInt();
			isPrime(input);
		} else { 
			for(int i = 0; i < arr.length; i++) {
			isPrime(arr[i]);
			}
		}
	}
	public String checkIfListOfNumbers(String incomingStr) {
		String value = "";
		String[] holdArr;
		int numberSendToIsPrime = 0;
		if(incomingStr.contains("-")) {
			holdArr = incomingStr.split("");
			value = runLoopForPrimes(holdArr);
			//value = "running listLoop";
		} else {
			value = isPrime(numberSendToIsPrime);
		}
		return value;
	}
	//check if it is prime 
	public String isPrime(int num) {
		boolean hold = false;
		String value = "";
		for(int i = 2; i < num/2; i++) {
			if((num % i) == 0 || num == 4) {
				hold = true;
				break;
			} 
		}
		if(hold) {
			value = "Not prime";
		} else {
			value = "Is prime";
		}
		return value;
	}
	//returns all number in the list that are not prime
	public String runLoopForPrimes(String[] incomingArr) {
		String value = "";
		String returnValue = "";
		int check = Integer.parseInt(incomingArr[0]);
		//function toget the last intengers 
		int checkLoop = getCheckLoop(incomingArr);
		ArrayList<Integer> intList= new ArrayList<Integer>();
		int sendValue = 0;
		
		for(int i = check; i <= checkLoop; ++i) {
			sendValue = i;
			value = isPrime(sendValue).toLowerCase();
			if(value.equals("not prime")) {
				intList.add(sendValue);
			}
		}
		returnValue = "not prime: " + intList.toString();
		return returnValue;
	}
	//run threw array backwards to get the last number entered 
	public int getCheckLoop(String[] arr) {
		ArrayList<String> arrList = new ArrayList<String>();
		String sumValue = "";
		String finalString = "";
		int returnValue = 0;
		for(int i = arr.length - 1; i > 0; i--) {
			if(isInteger(arr[i]) == true) {
				arrList.add(arr[i]);
			} else {
				break;
			}
		}
		//concat arrList to a string
		for(String d : arrList) {
			sumValue += d;
		}
		//reverse the string 
        for(int i = sumValue.length() - 1; i >= 0; i--) {
            finalString = finalString + sumValue.charAt(i);
        }
		returnValue = Integer.parseInt(finalString);
		return returnValue;
	}
	//check is string is integer used for for loop through front end input  
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
