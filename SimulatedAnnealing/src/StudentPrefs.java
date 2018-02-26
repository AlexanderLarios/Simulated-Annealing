// Alex Larios CS 461
import java.util.*;

public class StudentPrefs{
	  private int ID; //int ID for student
	  private ArrayList<Character> prefs = new ArrayList<Character>(5); // Student Lab section priority from high to low
	  public  StudentPrefs() {
		  ID = 0;
	  }

	    public StudentPrefs(int ID_, ArrayList<Character> prefs_) {
	        this.ID = ID_;
	        this.prefs = prefs_;
	    }

	    public void setID(int ID_) {
	        this.ID = ID_;
	    }

	    public void setPrefs(ArrayList<Character> prefs_) {
	        this.prefs = prefs_;
	    }

	    public int getID() {
	        return ID;
	    }

	    public ArrayList<Character> getPrefs() {
	        return prefs;
	    }
	    
	    public StudentPrefs(StudentPrefs another) {
	        this.ID = another.ID;
	        this.prefs = another.prefs;
	    }
}
