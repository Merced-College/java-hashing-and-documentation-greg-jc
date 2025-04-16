//package hashingAndDocumentation;

import java.util.List;
import java.util.Arrays;
import java.util.Objects;

/**
 * The SongRecord class holds information about a song. It stores details such as the song's mood,
 * release year, artist names, and other musical attributes.
 *
 * Precondition: When using the CSV constructor, the input string must contain exactly 19 comma-separated
 *               values in the correct order.
 * Postcondition: A SongRecord object is created with all fields populated from default values or the parsed CSV.
 *
 * Example CSV input (19 values expected):
 *   "0.5,2020,0.1,[Artist1;Artist2],0.7,210000,0.8,0,abc123,0.0,5,0.1,-5.0,1,Song Name,50,2020-01-01,0.05,120.0"
 *
 * @author  
 * @since   2025-04-15
 */
public class SongRecord {
    // Instance variables to store song attributes
    private double valence;
    private int year;
    private double acousticness;
    private List<String> artists;
    private double danceability;
    private int durationMs;
    private double energy;
    private int explicit;
    private String id;
    private double instrumentalness;
    private int key;
    private double liveness;
    private double loudness;
    private int mode;
    private String name;
    private int popularity;
    private String releaseDate;
    private double speechiness;
    private double tempo;

    /**
     * Default constructor that sets default values for the SongRecord.
     *
     * Precondition: None.
     * Postcondition: All fields are set to default values (e.g., 0 for numbers, "Unknown Title" for name).
     */
    public SongRecord() {
        this.valence = 0.0;
        this.year = 0;
        this.acousticness = 0.0;
        this.artists = Arrays.asList("Unknown Artist");
        this.danceability = 0.0;
        this.durationMs = 0;
        this.energy = 0.0;
        this.explicit = 0;
        this.id = "";
        this.instrumentalness = 0.0;
        this.key = 0;
        this.liveness = 0.0;
        this.loudness = 0.0;
        this.mode = 0;
        this.name = "Unknown Title";
        this.popularity = 0;
        this.releaseDate = "0";
        this.speechiness = 0.0;
        this.tempo = 0.0;
    }

    /**
     * Constructs a SongRecord from a CSV-formatted string.
     *
     * Precondition: The 'data' parameter must be a properly formatted CSV string containing exactly 19 values.
     * Postcondition: The SongRecord object has its fields populated with the values parsed from the CSV string.
     *
     * @param data A CSV string with 19 comma-separated values representing song attributes.
     * @throws NumberFormatException if numeric conversion fails.
     */
    public SongRecord(String data) {
        // Split the CSV line into parts
        String[] fields = data.split(",");
        
        // Parse each field from the CSV string.
        this.valence = Double.parseDouble(fields[0]);
        this.year = Integer.parseInt(fields[1]);
        this.acousticness = Double.parseDouble(fields[2]);
        // Clean up the artists field and split on semicolons.
        this.artists = Arrays.asList(fields[3].replaceAll("[\\[\\]']", "").split(";"));
        this.danceability = Double.parseDouble(fields[4]);
        this.durationMs = Integer.parseInt(fields[5]);
        this.energy = Double.parseDouble(fields[6]);
        this.explicit = Integer.parseInt(fields[7]);
        this.id = fields[8];
        this.instrumentalness = Double.parseDouble(fields[9]);
        this.key = Integer.parseInt(fields[10]);
        this.liveness = Double.parseDouble(fields[11]);
        this.loudness = Double.parseDouble(fields[12]);
        this.mode = Integer.parseInt(fields[13]);
        this.name = fields[14];
        this.popularity = Integer.parseInt(fields[15]);
        this.releaseDate = fields[16];
        this.speechiness = Double.parseDouble(fields[17]);
        this.tempo = Double.parseDouble(fields[18]);
    }

    // -------------------------
    // Getters and Setters
    // -------------------------

    /**
     * Returns the valence (mood score) of the song.
     *
     * Precondition: The SongRecord object is properly initialized.
     * Postcondition: The current valence is returned.
     *
     * @return the song's valence.
     */
    public double getValence() { return valence; }

    /**
     * Sets the valence (mood score) of the song.
     *
     * Precondition: The provided valence must be a valid double value.
     * Postcondition: The song's valence is updated.
     *
     * @param valence the new mood score.
     */
    public void setValence(double valence) { this.valence = valence; }

    /**
     * Returns the release year of the song.
     *
     * Precondition: The SongRecord is initialized.
     * Postcondition: The release year is returned.
     *
     * @return the release year.
     */
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    /**
     * Returns the acousticness score.
     *
     * Precondition: The SongRecord is properly initialized.
     * Postcondition: The acousticness value is returned.
     *
     * @return the acousticness.
     */
    public double getAcousticness() { return acousticness; }
    public void setAcousticness(double acousticness) { this.acousticness = acousticness; }

    /**
     * Returns the list of artists.
     *
     * Precondition: The SongRecord is properly initialized.
     * Postcondition: The list of artists is returned.
     *
     * @return the artists.
     */
    public List<String> getArtists() { return artists; }
    public void setArtists(List<String> artists) { this.artists = artists; }

    /**
     * Returns the danceability score.
     *
     * Precondition: The SongRecord is initialized.
     * Postcondition: The danceability value is returned.
     *
     * @return the danceability.
     */
    public double getDanceability() { return danceability; }
    public void setDanceability(double danceability) { this.danceability = danceability; }

    /**
     * Returns the duration of the song in milliseconds.
     *
     * Precondition: The SongRecord is initialized.
     * Postcondition: The duration is returned.
     *
     * @return the duration in milliseconds.
     */
    public int getDurationMs() { return durationMs; }
    public void setDurationMs(int durationMs) { this.durationMs = durationMs; }

    /**
     * Returns the energy level of the song.
     *
     * Precondition: The SongRecord is initialized.
     * Postcondition: The energy value is returned.
     *
     * @return the energy.
     */
    public double getEnergy() { return energy; }
    public void setEnergy(double energy) { this.energy = energy; }

    /**
     * Returns the flag indicating explicit content.
     *
     * Precondition: The SongRecord is initialized.
     * Postcondition: Returns 1 if explicit, otherwise 0.
     *
     * @return the explicit flag.
     */
    public int getExplicit() { return explicit; }
    public void setExplicit(int explicit) { this.explicit = explicit; }

    /**
     * Returns the unique song ID.
     *
     * Precondition: The SongRecord is initialized.
     * Postcondition: The song ID is returned.
     *
     * @return the song's ID.
     */
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    /**
     * Returns the instrumentalness score.
     *
     * Precondition: The SongRecord is initialized.
     * Postcondition: The instrumentalness value is returned.
     *
     * @return the instrumentalness.
     */
    public double getInstrumentalness() { return instrumentalness; }
    public void setInstrumentalness(double instrumentalness) { this.instrumentalness = instrumentalness; }

    /**
     * Returns the musical key of the song.
     *
     * Precondition: The SongRecord is initialized.
     * Postcondition: The key is returned.
     *
     * @return the key.
     */
    public int getKey() { return key; }
    public void setKey(int key) { this.key = key; }

    /**
     * Returns the liveness score.
     *
     * Precondition: The SongRecord is initialized.
     * Postcondition: The liveness value is returned.
     *
     * @return the liveness.
     */
    public double getLiveness() { return liveness; }
    public void setLiveness(double liveness) { this.liveness = liveness; }

    /**
     * Returns the loudness level.
     *
     * Precondition: The SongRecord is initialized.
     * Postcondition: The loudness value is returned.
     *
     * @return the loudness.
     */
    public double getLoudness() { return loudness; }
    public void setLoudness(double loudness) { this.loudness = loudness; }

    /**
     * Returns the mode of the song (major or minor).
     *
     * Precondition: The SongRecord is initialized.
     * Postcondition: The mode is returned.
     *
     * @return the mode.
     */
    public int getMode() { return mode; }
    public void setMode(int mode) { this.mode = mode; }

    /**
     * Returns the title of the song.
     *
     * Precondition: The SongRecord is initialized.
     * Postcondition: The title is returned.
     *
     * @return the song's name.
     */
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    /**
     * Returns the popularity rating of the song.
     *
     * Precondition: The SongRecord is initialized.
     * Postcondition: The popularity value is returned.
     *
     * @return the popularity.
     */
    public int getPopularity() { return popularity; }
    public void setPopularity(int popularity) { this.popularity = popularity; }

    /**
     * Returns the release date as a string.
     *
     * Precondition: The SongRecord is initialized.
     * Postcondition: The release date is returned.
     *
     * @return the release date.
     */
    public String getReleaseDate() { return releaseDate; }
    public void setReleaseDate(String releaseDate) { this.releaseDate = releaseDate; }

    /**
     * Returns the speechiness score.
     *
     * Precondition: The SongRecord is initialized.
     * Postcondition: The speechiness value is returned.
     *
     * @return the speechiness.
     */
    public double getSpeechiness() { return speechiness; }
    public void setSpeechiness(double speechiness) { this.speechiness = speechiness; }

    /**
     * Returns the tempo (beats per minute) of the song.
     *
     * Precondition: The SongRecord is initialized.
     * Postcondition: The tempo value is returned.
     *
     * @return the tempo.
     */
    public double getTempo() { return tempo; }
    public void setTempo(double tempo) { this.tempo = tempo; }

    // -------------------------
    // Overridden Methods
    // -------------------------

    /**
     * Returns a string representation of the SongRecord with all its details.
     *
     * Precondition: The SongRecord object is fully initialized.
     * Postcondition: A detailed string about the song is returned.
     *
     * @return a string representing the SongRecord.
     */
    @Override
    public String toString() {
        return "SongRecord{" +
                "valence=" + valence +
                ", year=" + year +
                ", acousticness=" + acousticness +
                ", artists=" + artists +
                ", danceability=" + danceability +
                ", durationMs=" + durationMs +
                ", energy=" + energy +
                ", explicit=" + explicit +
                ", id='" + id + '\'' +
                ", instrumentalness=" + instrumentalness +
                ", key=" + key +
                ", liveness=" + liveness +
                ", loudness=" + loudness +
                ", mode=" + mode +
                ", name='" + name + '\'' +
                ", popularity=" + popularity +
                ", releaseDate=" + releaseDate +
                ", speechiness=" + speechiness +
                ", tempo=" + tempo +
                '}';
    }

    /**
     * Compares this SongRecord with another object for equality.
     *
     * Precondition: The other object is not null.
     * Postcondition: Returns true if all fields of both SongRecord objects are equal.
     *
     * @param o the object to compare with.
     * @return true if the objects are equal; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongRecord that = (SongRecord) o;
        return Double.compare(that.valence, valence) == 0 &&
                year == that.year &&
                Double.compare(that.acousticness, acousticness) == 0 &&
                Objects.equals(artists, that.artists) &&
                Double.compare(that.danceability, danceability) == 0 &&
                durationMs == that.durationMs &&
                Double.compare(that.energy, energy) == 0 &&
                explicit == that.explicit &&
                Objects.equals(id, that.id) &&
                Double.compare(that.instrumentalness, instrumentalness) == 0 &&
                key == that.key &&
                Double.compare(that.liveness, liveness) == 0 &&
                Double.compare(that.loudness, loudness) == 0 &&
                mode == that.mode &&
                Objects.equals(name, that.name) &&
                popularity == that.popularity &&
                releaseDate == that.releaseDate &&
                Double.compare(that.speechiness, speechiness) == 0 &&
                Double.compare(that.tempo, tempo) == 0;
    }

    /**
     * Computes the hash code for the SongRecord based on all its attributes.
     *
     * Precondition: The SongRecord is fully initialized.
     * Postcondition: A hash code is calculated and returned.
     *
     * @return the hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(valence, year, acousticness, artists, danceability, durationMs, energy, explicit, id,
                instrumentalness, key, liveness, loudness, mode, name, popularity, releaseDate, speechiness, tempo);
    }
}
