import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class importer {

    public static ArrayList<Song> importData(String filePath) {
        ArrayList<Song> songs = new ArrayList<Song>();

        try {
            File myFile = new File(filePath);
            Scanner scanner = new Scanner(myFile);
            while(scanner.hasNext()) {
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
                    System.out.print("");
                }

                Song song;
                if(genre.contains("rock")) {
                    song = new RockSong(artist, songTitle, duration, year, genre, dance_ability);
                } else {
                    song = new Song(artist, songTitle, duration, year, genre);
                }
                songs.add(song);
            }
        } catch (IOException exception) {
            System.out.println("Error reading the file: " + exception.getMessage());
        }

        return songs;
    }
}
