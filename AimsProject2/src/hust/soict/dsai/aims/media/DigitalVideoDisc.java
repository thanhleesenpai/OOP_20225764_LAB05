package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc() {
        super(nbDigitalVideoDiscs, "Unknown", "Unknown", 0.0f, 0, "Unknown");
        nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(String title) {
        super(nbDigitalVideoDiscs, title, "Unknown", 0.0f, 0, "Unknown");
        nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(nbDigitalVideoDiscs, title, category, cost, 0, "Unknown");
        nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(nbDigitalVideoDiscs, title, category, cost, 0, director);
        nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(nbDigitalVideoDiscs, title, category, cost, length, director);
        nbDigitalVideoDiscs++;
    }

    public boolean isMatch(String title) {
        return this.getTitle().equalsIgnoreCase(title);
    }

//    @Override
//    public String toString() {
//        return "DVD - " + getTitle() + " - " + (getCategory() != null ? getCategory() : "Unknown") + " - "
//                + (getDirector() != null ? getDirector() : "Unknown") + " - " + getLength() + " mins: " + getCost()
//                + "f";
//    }
    @Override
    public String toString() {
        return "DigitalVideoDisc [Title: " + getTitle() + ", Category: " + getCategory() +
               ", Director: " + getDirector() + ", Length: " + getLength() + " mins, Cost: " + getCost() + "]";
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + getTitle());
        System.out.println("DVD length: " + getLength() + " mins");
    }
}
