public class Song {
    private String artist;
    private String title;
    private double duration;
    private String genre;
    private int year;

    public Song(String artist,String title,int duration,int year,String genre) {
        this.artist=artist;
        this.title=title;
        this.duration=duration;
        this.year=year;
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
    public String getGenre(){
        return genre;
    }
    public int getYear(){
        return year;
    }
}
