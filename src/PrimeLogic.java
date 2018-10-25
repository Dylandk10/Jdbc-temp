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
	//check if it is prime 
	public String isPrime(int num) {
		boolean hold = false;
		String value = "";
		for(int i = 2; i < num/2; i++) {
			if((num % i) == 0) {
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
	
}
