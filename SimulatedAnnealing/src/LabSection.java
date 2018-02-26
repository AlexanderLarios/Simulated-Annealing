// Alex Larios CS 461
import java.util.*;


public class LabSection
{
	// Array List that holds the students information ( id / preferences) for those students enrolled in this Lab section
	public ArrayList<StudentPrefs> students = new ArrayList<StudentPrefs>();
	public int fitness;
	public char sectionName;
	
	// Constructor
	public LabSection(char sectionName_){
	    sectionName = sectionName_;
	    fitness = 0;
	}

	// add a StudentPrefs to the Labsection and update the section fitness to represent the student taking up a seat in the lab
	public void addStudent(StudentPrefs student_){
	    
	    students.add(student_);
	    int studentFitness = 36;
	    for(int i = 0; i < 5; i++){
	        if (student_.getPrefs().get(i) == sectionName)
	            studentFitness = (i + 1)*(i + 1);
	    }
	    fitness += studentFitness;
	}

//Pop a student off the lab section
	public StudentPrefs popStudent() {
		//Pick a random seat from the lab section's 20 seats
		Random rand = new Random(System.currentTimeMillis());
		int randomSeat = rand.nextInt(20);
	    StudentPrefs tempStudent = new StudentPrefs();
	    tempStudent = students.get(randomSeat);
	    int studentFitness = 36;
	    for(int i = 0; i < 5; i++){
	        if (students.get(randomSeat).getPrefs().get(i) == sectionName) { 
	            studentFitness = (i + 1)*(i + 1);
	        }
	    }   
	    fitness -= studentFitness;
	    students.remove(randomSeat);
	    return tempStudent;
	    
	    
	}
	//print fitness and lab roster
	public void print() {
		System.out.println("Lab Section" + sectionName + "  Fitness: " + fitness);
	    for(int i = 0; i < 20; i++){
	    	System.out.println(students.get(i).getID());
	    }          
	}

	
}
