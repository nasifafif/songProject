import java.util.ArrayList;

public class searchMethods{
    public searchMethods(){}

    public ArrayList<String> linearSearchTitle(String str, ArrayList<Song> allSongs){
        ArrayList<String> matches = new ArrayList<>();
        for(int i =0; i<allSongs.size(); i++){
            if(allSongs.get(i).getTitle().toLowerCase().contains(str.toLowerCase())){
                matches.add(allSongs.get(i).getTitle());
                musicCollection.idxs.add(i);
            }
        }
        return matches;
    }

    public void linearSearchArtist(){

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
