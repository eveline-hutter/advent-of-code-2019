package advent;

public class Puzzle2 {
	
	private final int[] INPUTSAVE = {1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,9,1,19,1,19,5,23,1,23,6,27,2,9,27,31,1,5,31,35,1,35,10,39,1,39,10,43,2,43,9,47,1,6,47,51,2,51,6,55,1,5,55,59,2,59,10,63,1,9,63,67,1,9,67,71,2,71,6,75,1,5,75,79,1,5,79,83,1,9,83,87,2,87,10,91,2,10,91,95,1,95,9,99,2,99,9,103,2,10,103,107,2,9,107,111,1,111,5,115,1,115,2,119,1,119,6,0,99,2,0,14,0};
	private int[] input = new int[INPUTSAVE.length];
	
	public Puzzle2(int noun, int verb)
	{
		initialise();
		input[1] = noun;
		input[2] = verb;
	}
	
	public void initialise()
	{
		for(int i = 0; i < input.length; i++) {
			input[i] = INPUTSAVE[i];
		}
	}
	
	//method for the first part of the puzzle
	public void intcode(int commandPos)
	{
		/** block of four digits = one opcode
		 *	1 = add values of the next two array slots and save it in the third
		 *  2 = multiply values of the next two array slots and save it in the third
		 *  99 = halt the program
		 */
		if(input[commandPos] == 99) {
			System.out.println(Integer.valueOf(input[0]));
		}
		else if(input[commandPos] == 1) {
			int pos1 = input[commandPos + 1];
			int pos2 = input[commandPos + 2];
			int pos3 = input[commandPos + 3];
			input[pos3] = input[pos1] + input[pos2];
			commandPos += 4;
			intcode(commandPos);
		}
		else if(input[commandPos] == 2) {
			int pos1 = input[commandPos + 1];
			int pos2 = input[commandPos + 2];
			int pos3 = input[commandPos + 3];
			input[pos3] = input[pos1] * input[pos2];
			commandPos += 4;
			intcode(commandPos);
		}
	}
	
	// method for the second part of the puzzle
	public void intcode2() 
	{
		boolean sumFound = false;
		int requiredSum = 19690720;
		int noun = 0;
		
		while (!sumFound && noun<=99){
			int verb = 0;
			while(!sumFound && verb<=99) {
				Puzzle2 puzzle = new Puzzle2(noun, verb);
				puzzle.intcode(0);
				if (puzzle.input[0] == requiredSum) {
					sumFound = true;
					System.out.print(Integer.valueOf(noun)+","+Integer.valueOf(verb));
				}
				else {
					verb++;
				}
			}
			noun++;
		}
	}
}
