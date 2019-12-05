package advent;

import java.util.Arrays;	//System.out.print(Arrays.toString(this.password));

public class Puzzle3 {

	private final int MIN = 353096;
	private final int MAX = 843212;
	private int[] password = new int[6];
	private int counter = 0;
	
	public Puzzle3()
	{
		
	}
	
	public void generateArray(int password)
	{
		String s = Integer.toString(password);
		for(int i = 0; i < this.password.length; i++) {
			this.password[i] = Character.getNumericValue(s.charAt(i)); //
		}
	}
	
	public void checkPasswords()
	{
		for(int i = MIN; i <= MAX; i++) {
			generateArray(i);
			if(sorted(password) && adjacentDigitsSame(password)){
				counter++;
			}
		}
		System.out.println(counter);
	}
	
	public boolean sorted(int[] password)
	{
		boolean sorted = true;
		
		for(int i = 0; i < password.length-1; i++) {
			if(password[i] > password[i + 1]) {
				return false;
			}
		}
		return sorted;
	}
	
	public boolean adjacentDigitsSame(int[] password)
	{
		boolean same = false;
		
		for(int i = 0; i < password.length-1; i++) {
			if(password[i] == password[i+1]) {
				boolean moreThanOne = moreThanOne(password[i]);
				if(!moreThanOne) {
					return true;
				}
			}
		}
		
		return same;
	}
	
	public boolean moreThanOne(int n)
	{
		boolean moreThanOne = false;
		
		for(int i = 1; i < password.length-1; i++) {
			if((password[i-1] == password[i]) && (password[i] == password[i+1])) {
				if(password[i] == n) {
					return true;
				}
			}
		}
		
		return moreThanOne;
	}
}
