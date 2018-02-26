// Alex Larios CS 461
import java.io.*;
import java.util.*;

public class SimulatedAnnealing
{
	

	public static void main(String[] args)
	{
		State currentState = new State();
		// Try to open file
		 try{
			    FileInputStream fstream = new FileInputStream("Spr18Pr2LabAssign.txt");
			    //Create initial state
			    currentState.startState(fstream);
			         
			   }
		 catch (Exception e){ 
			     System.err.println("Error:Opening File " + e.getMessage());
			     System.exit(1);
			   }
		 
		 
		    
		    
		   System.out.println("Random Starting State Fitness: " + currentState.getFitness());
		   System.out.println("Starting the simulated annealing process!");
		    //Begin Simulated Annealing Algorithm
		   simAnnealing(currentState, 10000);
		   System.out.println("Simulated Annealing Completed...");
		    //Print Out results
		   currentState.print();
	}

	// Simulated Annealing Algo
	public static void simAnnealing(State currentState, double temp) {
		int attempts = 0;
		int swaps = 0;
		while(true){
			 if(temp <= 0.01){
				 break;
			 }
		           
			System.out.println("Temp: " + temp +"   Attempts: " + attempts + "  Swaps: " + swaps+ "  Fitness: " + currentState.getFitness());
			 
			 if(attempts == 10000 || swaps == 1000){
		            temp = temp * .95;
		            attempts = 0;
		            swaps = 0;
		        }
			 State newState = currentState.mutate();
		        if(newState.getFitness() < currentState.getFitness()){
		        	currentState = newState;
		            swaps++;
		        }
		        // P(Change)=e^(−(S2−S1)/T)
		        else {
		            double probability = Math.pow(Math.E, -( (newState.getFitness() - currentState.getFitness() ) / temp ) );
		            double exponential = ((Math.random() % 100) + 1) * .01;
		            if(exponential <= probability){
		            	currentState = newState;
		                swaps++;
		            }
		        }
		        attempts++;
		}
	
			
			
	}
}
