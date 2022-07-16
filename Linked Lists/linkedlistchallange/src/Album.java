import java.util.ArrayList;

public class Album {
    private ArrayList<Songs> album;

    public Album(ArrayList<Songs> album) {
        this.album = album;
    }

    public ArrayList<Songs> getAlbum() {
        return album;
    }
}
