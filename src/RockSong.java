public class RockSong extends Song {
    private double danceAbility;

    public RockSong(String artist, String title, int duration, int year, String genre, double danceAbility) {
        super(artist, title, duration, year, genre);
        this.danceAbility = danceAbility;
    }

    public double getDanceAbility() {
        return danceAbility;
    }

    @Override
    public String getGenre() {
        String genre = "Rock";  // Fixed genre
        String danceabilityLevel;
        if (danceAbility <= 0.2) {
            danceabilityLevel = "Low Danceability";
        } else if (danceAbility <= 0.5) {
            danceabilityLevel = "Medium Danceability";
        } else if (danceAbility <= 0.9) {
            danceabilityLevel = "High Danceability";
        } else {
            danceabilityLevel = "High Danceability";
        }
        return genre + " - " + danceabilityLevel + ", at a score of " + danceAbility;
    }
}
