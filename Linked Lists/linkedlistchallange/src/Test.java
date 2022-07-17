import java.util.*;

public class Test {
    public static void main(String[] args) {
        ArrayList<Album> albums = new ArrayList<>();
        LinkedList<Songs> playlist = new LinkedList<>();

        ArrayList<Songs> lustForLifeSongs = new ArrayList<>();

        Songs Love = new Songs("Love", 4.32);
        Songs LustforLife = new Songs("Lust for Life", 4.24);
        Songs ThirteenBeaches = new Songs("13 Beaches", 4.55);

        lustForLifeSongs.add(Love);
        lustForLifeSongs.add(LustforLife);
        lustForLifeSongs.add(ThirteenBeaches);

        Album lustForLifeAlbum = new Album(lustForLifeSongs);
        albums.add(lustForLifeAlbum);

        ArrayList<Songs> humanSongs = new ArrayList<>();

        Songs humanRace = new Songs("Human Race", 4.09);
        Songs painkiller = new Songs("Painkiller", 2.59);
        Songs fallenAngel = new Songs("Fallen Angel", 3.06);

        humanSongs.add(humanRace);
        humanSongs.add(painkiller);
        humanSongs.add(fallenAngel);

        Album humanAlbum = new Album(humanSongs);
        albums.add(humanAlbum);

        addPlaylist(playlist, albums, "Painkiller");
        addPlaylist(playlist, albums, "Lust for Life");

        surf(playlist);

    }

    private static void Menu(){
        System.out.println("To quit: 0\nTo Skip: 1\nTo Previous: 2");
    }

    private static void addPlaylist(LinkedList<Songs> linkedList, ArrayList<Album> albums, String song){
        int counter = 0;
        for(int i = 0; i < albums.size(); i++){
            for(int j = 0; j<albums.get(i).getAlbum().size(); j++){
                if(albums.get(i).getAlbum().get(j).getTitle().equals(song)){
                    counter++;
                    linkedList.add(albums.get(i).getAlbum().get(j));
                }

                if(counter>0){
                    break;
                }
            }
            if(counter>0){
                break;
            }
        }
        if(counter==0){
            System.out.println("The song you are searching for is unavailable.");
        }
    }

    private static void printList(LinkedList<Songs> linkedList){
        Iterator<Songs> i = linkedList.iterator();
        while(i.hasNext()){
            System.out.println("We have: " + i.next().getTitle());
        }
        System.out.println("========================");
    }

    private static void surf(LinkedList<Songs> linkedList){
        Menu();
        Scanner sc = new Scanner(System.in);
        ListIterator<Songs> songsListIterator = linkedList.listIterator();
        boolean flag = true;
        boolean goingForward = true;
        if(linkedList.isEmpty()){
            System.out.println("No songs in the queue");
            return;
        }else{
            System.out.println("Now visiting " + songsListIterator.next().getTitle());
        }

        while(flag){
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 0 -> {
                    System.out.println("Exiting the program...");
                    flag = false;
                }
                case 1 -> {
                    if (!goingForward) {
                        if (songsListIterator.hasNext()) {
                            songsListIterator.next();
                        }
                        goingForward = true;
                    }
                    if (songsListIterator.hasNext()) {
                        System.out.println("Now listening " + songsListIterator.next().getTitle());
                    } else {
                        System.out.println("Reached the end of the list");
                        goingForward = false;
                    }
                }
                case 2 -> {
                    if (goingForward) {
                        if (songsListIterator.hasPrevious()) {
                            songsListIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (songsListIterator.hasPrevious()) {
                        System.out.println("Now listening " + songsListIterator.previous().getTitle());
                    } else {
                        System.out.println("We are at the end of the queue.");
                        goingForward = true;
                    }
                }
            }
        }

    }
}
