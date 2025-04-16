//package hashingAndDocumentation; // Uncomment if using a package

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The SongProgram class manages SongRecord objects by reading from a CSV file,
 * storing songs in a HashMap, and allowing users to search for songs either via the console or a simple GUI.
 *
 * Precondition: The CSV file must exist, have a header as its first line, and subsequent lines in the proper CSV format.
 * Postcondition: The internal song map is populated, and song lookup/display functions become available.
 *
 * There are two main execution modes:
 * 1. Console mode (prints song details to the console).
 * 2. GUI mode (allows song lookup via a simple window).
 * 
 * @author  
 * @since   2025-04-15
 */
public class SongProgram {

    // A HashMap to store SongRecord objects with the song's unique ID as the key.
    private HashMap<String, SongRecord> songMap;

    /**
     * Constructor that initializes the SongProgram by creating an empty song map.
     *
     * Precondition: None.
     * Postcondition: songMap is initialized as an empty HashMap.
     */
    public SongProgram() {
        songMap = new HashMap<>();
    }

    /**
     * Loads songs from a CSV file located at the given file path and stores them in the song map.
     * The first line (header) is skipped.
     *
     * Precondition: The file at filePath exists and is in the expected CSV format.
     * Postcondition: songMap is populated with SongRecord objects created from the CSV file's data.
     *
     * @param filePath the path to the CSV file containing song information.
     */
    public void loadSongsFromCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            
            // Skip the header line.
            br.readLine();
            
            // Read each remaining line, create a SongRecord, and add it to the map.
            while ((line = br.readLine()) != null) {
                SongRecord song = new SongRecord(line);
                songMap.put(song.getId(), song);
            }
            System.out.println("Songs successfully loaded from CSV.");
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }

    /**
     * Retrieves a SongRecord from the map using its unique ID.
     *
     * Precondition: The song map must have been populated with SongRecord objects.
     * Postcondition: Returns the SongRecord corresponding to the given ID, or null if not found.
     *
     * @param id the unique ID of the song.
     * @return the SongRecord associated with the provided ID, or null.
     */
    public SongRecord getSongById(String id) {
        return songMap.get(id);
    }

    /**
     * Prints all SongRecord objects in the song map to the console.
     *
     * Precondition: The song map is populated with SongRecord objects.
     * Postcondition: Each song's details are printed to standard output.
     */
    public void printAllSongs() {
        for (SongRecord song : songMap.values()) {
            System.out.println(song);
        }
    }
    
    /**
     * Opens a simple graphical user interface (GUI) that allows the user to search for a song by its ID.
     * The GUI includes a text field for input, a search button, and an area to display the results.
     *
     * Precondition: The song map is populated with SongRecord objects.
     * Postcondition: A GUI window appears, enabling the user to enter a song ID and view the song's details.
     */
    public void openSearchGui() {
        // Create the main GUI window.
        JFrame frame = new JFrame("Song Lookup");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold the user interface components.
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Create and add a label, text field, and search button.
        JLabel label = new JLabel("Enter Song ID:");
        JTextField idField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        panel.add(label);
        panel.add(idField);
        panel.add(searchButton);

        // Create a text area (inside a scroll pane) for displaying search results.
        JTextArea resultArea = new JTextArea(5, 30);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        panel.add(scrollPane);

        // Add an action listener for the search button.
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                SongRecord song = getSongById(id);
                if (song != null) {
                    resultArea.setText("Song Found:\n" + song.toString());
                } else {
                    resultArea.setText("Song with ID " + id + " not found.");
                }
            }
        });

        // Add the panel to the main window and display it.
        frame.add(panel);
        frame.setVisible(true);
    }

    /**
     * Alternative entry point to demonstrate the GUI mode.
     *
     * Precondition: A valid CSV file exists at the specified path.
     * Postcondition: The song map is populated and the GUI for searching songs is launched.
     *
     * @param args command-line arguments (not used).
     */
    public static void main2(String[] args) {
        SongProgram program = new SongProgram();

        // Specify the CSV file path.
        String filePath = "data.csv";  // Update the path if needed.
        program.loadSongsFromCSV(filePath);

        // Open the song search GUI.
        program.openSearchGui();
    }

    /**
     * The main method demonstrates the basic functionality in console mode.
     * It loads songs from a CSV file, attempts a song lookup by ID, and prints all songs.
     *
     * Precondition: The CSV file exists at the specified path and is correctly formatted.
     * Postcondition: The song map is populated, song lookup is demonstrated, and song details are printed.
     *
     * @param args command-line arguments (not used).
     */
    public static void main(String[] args) {
        SongProgram program = new SongProgram();

        // Specify the CSV file path.
        String filePath = "data.csv";  // Update the path if needed.
        program.loadSongsFromCSV(filePath);

        // Demonstrate retrieval of a song by a known ID.
        String testId = "4BJqT0PrAfrxzMOxytFOIz";  // Replace with an actual ID from your file.
        SongRecord song = program.getSongById(testId);
        if (song != null) {
            System.out.println("Retrieved song: " + song);
        } else {
            System.out.println("Song with ID " + testId + " not found.");
        }

        // Print out all loaded songs.
        program.printAllSongs();
    }
}
