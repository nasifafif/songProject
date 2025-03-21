import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class musicCollection {
    private ArrayList<Song> songs = new ArrayList<Song>();
    private ArrayList<String> explicit = new ArrayList<>();
    private ArrayList<String> possibleSongs = new ArrayList<>();
    public static ArrayList<Integer> idxs = new ArrayList<>();
    private int songNum;

    public void start() {
        importData();
        removeExplicit();
        menu();
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
                    System.out.print("");
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
                if (songs.get(i).getArtist().contains(s) || songs.get(i).getTitle().contains(s)) {
                    songs.remove(i);
                    i--;
                }
            }
        }
    }

    public void menu(){
        System.out.println("Welcome to the song collection!");
        String menuOption = "";
        Scanner scanner = new Scanner(System.in);
        String[][] menu = new String[6][1];
        menu[0][0]="Main Menu";
        menu[1][0]="Search (t)itles";
        menu[2][0]="Search (a)rtists";
        menu[3][0]="Search (g)enre";
        menu[4][0]="Search (y)ear";
        menu[5][0]="(q)uit";

        while (!menuOption.equals("q")) {
            for(int i = 0; i<menu.length; i++){
                for(int j = 0; j<menu[0].length; j++){
                    System.out.println(menu[i][j]);
                }
            }
            System.out.println("Enter choice: ");
            menuOption = scanner.nextLine();

            if (menuOption.equals("t")) {
                searchTitle();

            } else if (menuOption.equals("a")) {
                searchArtist();
            }
            else if(menuOption.equals("g")){
                searchGenre();
            }
            else if (menuOption.equals("y")){
                searchYear();
            }
            else if (menuOption.equals("q")) {
                System.out.println("Goodbye!");
            }
            else {
                System.out.println("Invalid choice");
            }
        }

    }
    public void printInfo(int choice){
        System.out.println("Title: " + songs.get(choice).getTitle());
        System.out.println("Artist: " + songs.get(choice).getArtist());
        double i = (double) 1 / 60000;
        double dur = (songs.get(choice).getDuration()*i);
        System.out.println("Duration: " + dur + " minutes");
        System.out.println("Year: " + songs.get(choice).getYear());
        System.out.println("Genre: " + songs.get(choice).getGenre());
    }

    public void searchTitle(){
        searchMethods x = new searchMethods();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a name of a song for more information of the track.");
        String title = scan.nextLine();
        possibleSongs=x.linearSearchTitle(title,songs);
        System.out.println(possibleSongs.size()==idxs.size());
        int count =0;
        for(int i = 0; i<possibleSongs.size(); i++){
            count++;
            System.out.println(count + ": " + possibleSongs.get(i));
        }
        System.out.println("Which one would you like to learn about? (enter number)");
        int choice = scan.nextInt();
        songNum=idxs.get(choice);

    }

    public void searchArtist(){}

    public void searchGenre(){}

    public void searchYear(){}

}
