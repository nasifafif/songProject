import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class musicCollection {
    private ArrayList<Song> songs = new ArrayList<Song>();
    private ArrayList<String> possibleSongs = new ArrayList<>();
    public static ArrayList<Integer> idxs = new ArrayList<>();

    public void start() {
        importData();
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

    public void printInfo(int songNum){
        System.out.println("Title: " + songs.get(songNum).getTitle());
        System.out.println("Artist: " + songs.get(songNum).getArtist());
        double i = (double) 1 / 60000;
        double dur = (songs.get(songNum).getDuration() * i);
        System.out.println("Duration: " + dur + " minutes");
        System.out.println("Year: " + songs.get(songNum).getYear());
        System.out.println("Genre: " + songs.get(songNum).getGenre());
    }
    public void linearSearchTitle(String title){
        possibleSongs.clear();
        idxs.clear();
        for (int i = 0 ; i<songs.size(); i++){
            if(songs.get(i).getTitle().toLowerCase().contains(title.toLowerCase())){
                possibleSongs.add(songs.get(i).getTitle());
                idxs.add(i);
            }
        }
    }
    public void linearSearchArtist(String artist){
        possibleSongs.clear();
        idxs.clear();
        for(int i =0; i<songs.size(); i++){
            if(songs.get(i).getArtist().toLowerCase().contains(artist.toLowerCase())){
                possibleSongs.add(songs.get(i).getTitle());
                idxs.add(i);
            }
        }
    }
    public void linearSearchGenre(String genre){
        for(int i = 0; i<songs.size(); i++){
            if(songs.get(i).getGenre().toLowerCase().contains(genre.toLowerCase())){
                possibleSongs.add(songs.get(i).getTitle());
                idxs.add(i);
            }
        }
    }
    public void linearSearchYear(int year) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getYear() == year) {
                possibleSongs.add(songs.get(i).getTitle());
                idxs.add(i);
            }
        }
    }

    public void removeDuplicates() {
        for (int i = 0; i < possibleSongs.size(); i++) {
            for (int j = i + 1; j < possibleSongs.size(); j++) {
                if (possibleSongs.get(i).equals(possibleSongs.get(j))) {
                    possibleSongs.remove(j);
                    idxs.remove(j); // Remove corresponding index
                    j--;
                }
            }
        }
    }

    public void searchTitle(){
        int count =  0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome! Enter a title of a song to search the database");
        String title = scan.nextLine();
        linearSearchTitle(title);
        if(!possibleSongs.isEmpty()){
            removeDuplicates();
            for(int i =0; i<possibleSongs.size(); i++){
                count++;
                System.out.println(count+ ": " + possibleSongs.get(i));
            }
            System.out.println("Which song would you like to learn about?(Enter number)");
            int choice = scan.nextInt();
            printInfo(idxs.get(choice-1));
        }
        else{
            System.out.println("No songs found with that title");
        }

    }

    public void searchArtist(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter an artist to see their information.");
        String artist = scan.nextLine();
        linearSearchArtist(artist);
        if(possibleSongs.isEmpty()){
            System.out.println("No artists found matching that name.");
            return;
        }
        removeDuplicates();
        int count = 0;
        for(int i = 0; i<possibleSongs.size(); i++){
            count++;
            System.out.println(count + ": " + possibleSongs.get(i));
        }
        System.out.println("Which song would you like to see information about?(Enter number)");
        int choice = scan.nextInt();
        printInfo(idxs.get(choice-1));
    }

    public void searchGenre() {
        possibleSongs.clear();
        idxs.clear();

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a genre to search for songs:");
        String genre = scan.nextLine();
        linearSearchGenre(genre);

        if (possibleSongs.isEmpty()) {
            System.out.println("No songs found with that genre.");
            return;
        }

        removeDuplicates();
        int count = 0;
        for (int i = 0; i < possibleSongs.size(); i++) {
            count++;
            System.out.println(count + ": " + possibleSongs.get(i));
        }

        System.out.println("Which song would you like to see information about? (Enter number)");
        int choice = scan.nextInt();
        printInfo(idxs.get(choice - 1));
    }


    public void searchYear() {
        possibleSongs.clear();
        idxs.clear();

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a year to search for songs:");
        int year = scan.nextInt();
        scan.nextLine(); // consume leftover newline
        linearSearchYear(year); // assuming your search method takes a String

        if (possibleSongs.isEmpty()) {
            System.out.println("No songs found from that year.");
            return;
        }

        removeDuplicates();
        int count = 0;
        for (int i = 0; i < possibleSongs.size(); i++) {
            count++;
            System.out.println(count + ": " + possibleSongs.get(i));
        }

        System.out.println("Which song would you like to see information about? (Enter number)");
        int choice = scan.nextInt();
        printInfo(idxs.get(choice - 1));
    }

}
