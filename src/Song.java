public class Song {
    private String artist;
    private String title;
    private double duration;
    private String genre;
    private int year;
    private double dance_ability;

    public Song(String artist, String title, double duration, int year, double dance_ability,String genre) {
        this.artist=artist;
        this.title=title;
        this.duration=duration;
        this.year=year;
        this.dance_ability=dance_ability;
        this.genre=genre;
    }

    public String getArtist(){
        return artist;
    }
    public String getTitle(){
        return title;
    }
    public double getDuration(){
        return duration;
    }
    public String genre(){
        return genre;
    }
    public int year(){
        return year;
    }
    public double getDance_ability(){
        return dance_ability;
    }




}
