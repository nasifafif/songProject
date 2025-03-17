import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class musicCollection {
    private ArrayList<Song> songs = new ArrayList<Song>();
    private ArrayList<String> explicit = new ArrayList<>();

    public void start() {
        importData();
        removeExplicit();
    }

    public void importData(){
        try{
            File myFile = new File("src\\songs_normalize.csv");
            Scanner scanner = new Scanner(myFile);
            while(scanner.hasNext()){
                String data = scanner.nextLine();
                String[] split = data.split(",");
                String artist = split[0];
                String songTitle = split[1];
                int duration = 0;
                try {
                    duration = Integer.parseInt(split[2]);
                } catch (NumberFormatException e) {
                    System.out.print("");
                }
                int year = 0;
                try {
                    year = Integer.parseInt(split[3]);
                } catch (NumberFormatException e) {
                    System.out.print("");
                }
                String genre = split[4];
                double dance_ability = 0.0;
                try {
                    dance_ability = Double.parseDouble(split[5]);
                } catch (NumberFormatException e) {
                    System.out.println();
                }

                Song song = new Song(artist,songTitle,duration,year,genre,dance_ability);
                songs.add(song);
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
    public void importExplicit() {
        try {
            File myFile = new File("src\\explicit.csv");
            Scanner scan = new Scanner(myFile);
            while (scan.hasNext()) {
                String data = scan.nextLine();
                explicit.add(data);
            }
        }
        catch(IOException exception){
            System.out.println(exception.getMessage());

        }
    }

    public void removeExplicit() {
        importExplicit();
        for(int i = 0; i<songs.size(); i++){
            for (String s : explicit) {
                if (s.equals(songs.get(i).getArtist()) || s.equals(songs.get(i).getTitle())) {
                    songs.remove(i);
                    i--;
                }
            }
        }
    }

    public void menu(){

    }
}
