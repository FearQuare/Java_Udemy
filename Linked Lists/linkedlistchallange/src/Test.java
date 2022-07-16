import java.util.*;

public class Test {
    public static void main(String[] args) {
        ArrayList<Songs> lustForLife = new ArrayList<>();
        ArrayList<Album> albums = new ArrayList<>();
        LinkedList<Songs> playlist = new LinkedList<>();

        Songs Love = new Songs("Love", 4.32);
        Songs LustforLife = new Songs("Lust for Life", 4.24);
        Songs ThirteenBeaches = new Songs("13 Beaches", 4.55);

        lustForLife.add(Love);
        lustForLife.add(LustforLife);
        lustForLife.add(ThirteenBeaches);

        Album LustForLife = new Album(lustForLife);
        albums.add(LustForLife);



        ArrayList<Songs> human = new ArrayList<>();
        Songs humanRace = new Songs("Human Race", 4.09);
        Songs painkiller = new Songs("Painkiller", 2.59);
        Songs fallenAngel = new Songs("Fallen Angel", 3.06);
        human.add(humanRace);
        human.add(painkiller);
        human.add(fallenAngel);
        Album Human = new Album(human);
        albums.add(Human);

        addPlaylist(playlist, albums, "Pain Killer");
        addPlaylist(playlist, albums, "Lust for Life");
        addPlaylist(playlist, albums, "Fallen Angel");
        addPlaylist(playlist, albums, "13 Beaches");

        surf(playlist);

    }

    private static void Menu(){
        System.out.println("To quit: 0\nTo Skip: 1\nTo Previous: 2");
    }

    private static void addPlaylist(LinkedList<Songs> linkedList, ArrayList<Album> arrayList, String song){
        int counter = 0;
        int index1 = 0;
        int index2 = 0;
        for (Album album : arrayList) {
            for (int j = 0; j < album.getAlbum().size(); j++) {
                if (album.getAlbum().get(j).getTitle().equals(song)) {
                    counter++;
                }
                index2++;
            }
            index1++;
        }
        if(counter>0){
            linkedList.add(arrayList.get(index1-1).getAlbum().get(index2-1));
        }else{
            System.out.println("The song is unavailable.");
        }
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
            System.out.println("Now visiting " + songsListIterator.next());
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
                        System.out.println("Now listening " + songsListIterator.previous());
                    } else {
                        System.out.println("We are at the end of the queue.");
                        goingForward = true;
                    }
                }
            }
        }

    }
}
