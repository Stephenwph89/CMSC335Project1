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
    private javax.swing.JFileChooser jFileChooser2;
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
        this.JButton1 = new JButton1("Read Out");
        this.JButton2 = new JButton2("Search");

	/**I was not sure how to work with a combo box (never used it before)
	*  I searched for jcombobox and found informaiton on the Oracle Website
	*  How to Use Combo Boxes. (n.d.). Retrieved October 28, 2018, 
	*  from https://docs.oracle.com/javase/tutorial/uiswing/components/combobox.html
	*
	*/ 
	
	this.searchComboBoxValues = new String[] {"By name", "By index", "By skill"};
        this.searchComboBox = new JComboBox<>(this.searchComboBoxValues);
         // Add UI options to top panel
        this.optionsPanel.add(this.readButton);         // Read button first
        this.optionsPanel.add(this.searchTextLabel);    // Search text label "Search entries:"
        this.optionsPanel.add(this.searchTextField);    // Search bar itself
        this.optionsPanel.add(this.searchComboBox);     // Sorting options combo box
        this.optionsPanel.add(this.searchButton);       // Search button itself
                           




     