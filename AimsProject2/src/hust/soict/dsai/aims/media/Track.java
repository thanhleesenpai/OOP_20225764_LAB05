package hust.soict.dsai.aims.media;

public class Track implements Playable{
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }
    @Override
    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

	public Track() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    Track otherTrack = (Track) obj;
	    return this.getTitle() != null && this.getTitle().equals(otherTrack.getTitle())
	           && this.getLength() == otherTrack.getLength();
	}

}

