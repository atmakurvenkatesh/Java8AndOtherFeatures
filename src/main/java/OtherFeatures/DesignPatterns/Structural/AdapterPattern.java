package OtherFeatures.DesignPatterns.Structural;


public class AdapterPattern {

	public static void main(String args[]) {
		// below class Mp3MediaPlayer can play mp3 player (inbuilt) but can also play
		// mp4 and vlc because of
		// MediaAdapter
		Mp3MediaPlayer mediaPlayer = new Mp3MediaPlayer();
		mediaPlayer.play("mp3", "classics.mp3");
		mediaPlayer.play("mp4", "Krish.mp4");
		mediaPlayer.play("vlc", "MIB.vlc");
		mediaPlayer.play("csv", "random.csv");
	}
}

/**
 * Interface is capable of only playing mp3 media files
 */
interface MediaPlayer {
	public void play(String mediaType, String fileName);
}

/**
 * Interface capable of playing mp4 and vlc files both
 */
interface AdvanceMediaPlayer {

	public void playMp4(String fileName);

	public void playVlc(String fileName);

}

class Mp3MediaPlayer implements MediaPlayer {
	// dependency
	MediaAdapter mediaAdapter;

	@Override
	public void play(String mediaType, String fileName) {
		if (mediaType.equals("mp3")) {
			System.out.println("playing " + fileName + " of type " + mediaType);
		} else if (mediaType.equals("mp4") || mediaType.equals("vlc")) {
			mediaAdapter = new MediaAdapter(mediaType);
			mediaAdapter.play(mediaType, fileName);
		} else
			System.out.println("Given media type is not supported ");

	}
}

class MediaAdapter implements MediaPlayer {

	// dependency in MediaAdapter
	AdvanceMediaPlayer advanceMediaPlayer;

	// dependency injection in the same class(not recommended)
	public MediaAdapter(String mediaType) {
		this.advanceMediaPlayer = mediaType.equals("mp4") ? new Mp4MediaPlayer()
				: (mediaType.equals("vlc") ? new VlcMediaPlayer() : null);
	}

	@Override
	public void play(String mediaType, String fileName) {
		if (mediaType.equals("vlc"))
			this.advanceMediaPlayer.playVlc(fileName);
		else if (mediaType.equals("mp4"))
			this.advanceMediaPlayer.playMp4(fileName);
	}

}

class Mp4MediaPlayer implements AdvanceMediaPlayer {
	@Override
	public void playMp4(String fileName) {
		System.out.println("playing " + fileName + " of type mp4");
	}

	// note: this is a clear violation of ISP (as this client(Mp4MediaPlayer) is
	// being forced to override a method it does use)
	public void playVlc(String fileName) {
		// do nothing
	}
}

class VlcMediaPlayer implements AdvanceMediaPlayer {

	// note: this is a clear violation of ISP (as this client is being forced to
	// override a method it does use), for solution, we can segregate these two
	// methods from the parent interface into separate interfaces and only implement
	// the required one
	@Override
	public void playMp4(String fileName) {
		// do nothing
	}

	public void playVlc(String fileName) {
		System.out.println("playing " + fileName + " of type vlc");
	}

}
