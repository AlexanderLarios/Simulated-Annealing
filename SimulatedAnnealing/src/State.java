// Alex Larios CS 461
import java.io.*;
import java.util.*;


public class State
{
	public ArrayList<LabSection> labSections = new ArrayList<LabSection>(5);
	public State() {
		//initialize lab sections
		labSections.add(0, new LabSection('A'));
		labSections.add(1, new LabSection('B'));
		labSections.add(2, new LabSection('C'));
		labSections.add(3, new LabSection('D'));
		labSections.add(4, new LabSection('E'));
	}
// create the initial state for the algorithm
	public void startState(FileInputStream fstream_) {
		try{
			DataInputStream in = new DataInputStream(fstream_);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			int i=0;
			int k=0;
			//Read in file line by line
			while ((strLine = br.readLine()) != null){
				if(i==20){
					k++;
					i=0;
				}		
				String[] tokens = strLine.split(" +");
				int ID = Integer.parseInt(tokens[0]);
				ArrayList<Character> prefs = new ArrayList<>(Arrays.asList(tokens[1].charAt(0),tokens[2].charAt(0),
						tokens[3].charAt(0), tokens[4].charAt(0), tokens[5].charAt(0)));
				StudentPrefs tempStudent = new StudentPrefs(ID,prefs);
				// Assign a set of 20 students to each of the 5 labs
				labSections.get(k).addStudent(tempStudent);
				i++;
				}
			in.close();
		   }catch (Exception e){
		     System.err.println("Error:Reading file " + e.getMessage());
		   }
		
	}
	// Create a randomly mutated child
	public State mutate() {
		  State newState = this;
		  Random rand = new Random(System.currentTimeMillis());
		    int randomSection = rand.nextInt(4);
		    int randomSection2 = rand.nextInt(4);
		    while (randomSection2 == randomSection){
		    	randomSection2 = rand.nextInt(4);
		    }
		    StudentPrefs tempStudent1 = new StudentPrefs();
		    StudentPrefs tempStudent2 = new StudentPrefs();
		    tempStudent1 = newState.labSections.get(randomSection).popStudent();
		    tempStudent2 = newState.labSections.get(randomSection2).popStudent();
		    
		    newState.labSections.get(randomSection).addStudent(tempStudent2);
		    newState.labSections.get(randomSection2).addStudent(tempStudent1);
		    return newState;
	}
	// return summation of all the labs fitness scores
	public int getFitness() {
		 int tempFitness = 0;
		    for(int i = 0; i < 5; i++){
		        tempFitness += labSections.get(i).fitness;
		    }
		    return tempFitness;
	}
	//Print out the fitness score and the class rosters of each of the labs 
	public void print() {
		for(int i = 0; i < 5; i++){
			labSections.get(i).print();
		}
	}
}


