import java.util.ArrayList;

public class searchMethods extends musicCollection{
    public searchMethods(){}

    public boolean linearSearchArtist(ArrayList<Song> songs, String artist){
        for(int i = 0; i<songs.size(); i++){
            if(songs.get(i).getArtist().equals(artist)){
                return true;
            }
        }
        return false;
    }

    public boolean linearSearchTitle(ArrayList<Song> songs, String title){
        for(int i = 0; i<songs.size(); i++){
            if(songs.get(i).getTitle().equals(title)){
                return true;
            }
        }
        return false;
    }

    public boolean linearSearchGenre(ArrayList<Song> songs, String genre){
        for(int i = 0; i<songs.size(); i++){
            if(songs.get(i).getGenre().equals(genre)){
                return true;
            }
        }
        return false;
    }

    public boolean linearSearchYear(ArrayList<Song> songs, int year){
        for(int i = 0; i<songs.size(); i++){
            if(songs.get(i).getYear()==year){
                return true;
            }
        }
        return false;

    }

}
