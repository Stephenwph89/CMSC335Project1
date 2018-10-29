/**
*Stephen Hamilton
*Class: CMSC 335
*Section: 7981
*Instructor: Dinsoreanu, Mihaela
*Assignment: Project 1 Sea Port
*Date Started: 10/27/2018
*Due Date: 11/04/2018
*/


// imported packages


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


// Start of SeaPortProgram Class

public class SeaPortProgram extends javax.swing.JFrame {

    //Here I have created an instance for the World class.

	private World world;

   // These fields are for the main window for the program

	private String banner;
	private int width;
	private int height;

   // These fields are for creating the GUI itself

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;

   // These are fields for inputs into the program

    private JFileChooser chooser;
    private Scanner objects;

    // This is a default constructor for the Sea Port Program Window
    public SeaPortProgram() {
        
	this.setBanner("SeaPortProgram");
        this.setWidth(800);
        this.setHeight(500);

	}

    //This constructor is accepting size of window and banner
    public SeaPortProgram(String banner, int width, int height) {
        
        this.setBanner(banner);
        this.setWidth(width);
        this.setHeight(height);
    }

        //Setter for banner code
	private void setBanner(String banner) {
        this.banner = banner;
    }
	//Setter for the width of the window
	private void setWidth(int width) {
        
	this.Width = 1432;
    }
	//Setter for the height of the window
	  private void setHeight(int height) {
        
	this.Height = 507;
    }
	//Getter for the window banner
	protected String getBanner() {

        return this.banner;
    }    
	//Getter for window width
	 protected int getWidth() {

        return this.width;
    }
	//Getter for window height
	protected int getHeight() {

        return this.height;
    }

	//COMMENTS ARE NEEDED HERE

	private void SeaPortProgramGUI() {

         // Definitions to the GUI of the program
         // These are the definitions and setters for the text area of the program window
        this.JTextArea1 = new JTextArea1();                    
        this.JTextArea.setFont(new Font("Time New Roman", 0, 14)); 

	// Here, I'm adding the text area to the scroll pane
        this.JScrollPane1 = new JScrollPane1(this.JTextArea1);  
	
	//Here, I'm creating buttons for the menu in the window
        this.JButton1 = new JButton1("Read In");
        this.JButton2 = new JButton2("Search");
	
	/**
	*Combo Box created via String array so user can select to find information on thing and person as per rubric
	*find information on thing and person as per rubric
	*/
	
	this.search= new String[] {"Skill", "Index", "Name"};
        this.search= new JComboBox<>(this.search);


         // These are the UI features I have added for the program window

	//Read Button fo rthe user to read in files
        this.JFrame1.add(this.JButton1);  
	//Text Area for text to appear from files       
        this.JFrame1.add(this.JTextArea1);  
	//Text field for user to enter text to search for files  
        this.JFrame1.add(this.JTextField1);    
	//Combo Box for item selection for the user
        this.JFrame1.add(this.JComboBox1);  
	// Search button so the user can search files  
        this.JFrame1.add(this.JButton2);   

	this.JFrame1.add(this.JFrame1, BorderLayout.NORTH);    

	// This is the action listener I created to the read button                           
 	this.JButton1.addActionListener((ActionEvent e) -> {
            this.readFileContents();
        });
         // This is the action listener I created for the search button
        this.JButton2.addActionListener((ActionEvent e) -> {
            this.searchWorldContents();
        });
	
	// These are the setters and getters for the size and where the the JFrame elements go
	// Method for getting banner in JFrame
        this.JFrame = new JFrame(this.getbanner());
	// Method for setting and getting width, height
        this.JFrame.setSize(this.getWidth(), this.getHeight());
	// Method for setting window visible on screen
        this.JFrame.setVisible(true);
	// Methos for clpsing window
        this.JFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

	public  readFile() {

         // These are variables for the creation of the file chooser
        int choose;
        Reader fileReader;
        File filter;
         // This is the main folder from the grading rubric
        this.chooser = new JFileChooser1(".");

 	// I have added code here for the instance of World to scan the contents of information in the class
        this.world = new World(this.scannerContents);
         // This code makes it to where users will not be able to search if empty "Checks if Vector is Empty"
        if (this.world.getThings().isEmpty()) {
            // This code clears previous results via setting text to " "
            this.JTextArea1.setText("");
            this.world = null;
            this.displayMessage("Message: The file entered is incorrect.");
        } else {
	   //This code clears the text area by setting the text toString " "		
            this.JTextArea1.setText(" " + this.world.toString()); 
        }
     }

 	private void searchWorld() {

	// Variables used for searching the "world"
        String resultingInformation, searchInformation;
        int item;
         // Getting text from JTextField1
        resultingInformation = "";
        searchInformation = this.searchJTextField1.getText();
	// This code returns the first item in the list that is a match for any given item
        item = this.searchJComboBox1.getSelectedIndex();
         // Code for if user adds no information in search field
        if (searchText.equals("")) {
	 // Displays mesage to users for no information entered into search field	
            this.displayMessage("Message: No informaiton in search field");
            return;
        }

          // NEED COMMENTS HERE TO EXPLAIN CODE....This is a switch case for the drop down 
        switch(item) {
	    // for the name
            case 0: 
	    // for the index	
            case 1:
                resultsString = this.assembleResults(item, searchInformation);
                this.displayStatus(resultsString, searchInformation);
                break;
	    // for the skill	
            case 2: 
                for (SeaPort Entry Port: this.world.getPorts()) {
                    for (Person person : port.getPersons()) {
                        if (person.getSkill().equals(searchInformation)) {
                            resultsString += person.getName() + " (id " + person.getIndex()
                                + ")\n";
                        }
                    }
                }
                this.displayStatus(resultsString, searchInformation);
                break;
            default:
                break;
        }
    }
 public String assembleResults(int index, String paramInfo) {
         // Variable Declarations
         //Obtaining parameters from search results
        Method getparamInfo;
        String parameter, name;
        String paramResults;
            paramResults = " ";

  name = (index == 0) ? "getName" : "getIndex";
	// Try Catch for exception handling
         try {
            // Code will choose Thing.class.getName or Thing.class.getIndex
            getparamInfo = Thing.class.getDeclaredMethod(name);
             for (Thing item : this.world.getAllThings()) {
                 // Converts Integers to Strings
                parameter = "" + getparamInfo.invoke(item);
                 if (parameter.equals(paramInfo)) {
                    resultsString += item.getName() + " " + item.getIndex() + " ("
                        + item.getClass() ")\n";
                }
            }
        } catch (
            NoSuchMethodException |
            SecurityException |
            IllegalAccessException |
            IllegalArgumentException |
            InvocationTargetException ex
        ) {
            System.out.println("Error: " + ex);
        }
        return resultsString;
    }
     

    private void displayStatus(String resultsString, String paramInfo) {
        if (resultsString.equals("")) {
            JOptionPane.showMessageDialog(
                null,
                "Message: '" + paramInfo + "' is not found.",
                "Message",
                JOptionPane.WARNING_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                null,
                resultsString,
                "Search results for '" + paramInfo + "'",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
     // This method Simply Displays an error pop up
    private void displayErrorPopup(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
     
	// This is the main method that init new code, object, invokes method in the program
    public static void main(String[] args) {
        SeaPortProgram newCollection = new SeaPortProgram();
        newCollection.constructGUI();
    }
    )

    



     
