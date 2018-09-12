package com.sauzny.designpatterns.structural.adapter.s3;

import com.sauzny.designpatterns.structural.adapter.s1.AdvancedMediaPlayer;
import com.sauzny.designpatterns.structural.adapter.s1.MediaPlayer;
import com.sauzny.designpatterns.structural.adapter.s2.Mp4Player;
import com.sauzny.designpatterns.structural.adapter.s2.VlcPlayer;

public class MediaAdapter implements MediaPlayer {

	AdvancedMediaPlayer advancedMusicPlayer;

	public MediaAdapter(String audioType) {
		if (audioType.equalsIgnoreCase("vlc")) {
			advancedMusicPlayer = new VlcPlayer();
		} else if (audioType.equalsIgnoreCase("mp4")) {
			advancedMusicPlayer = new Mp4Player();
		}
	}

	@Override
	public void play(String audioType, String fileName) {
		if (audioType.equalsIgnoreCase("vlc")) {
			advancedMusicPlayer.playVlc(fileName);
		} else if (audioType.equalsIgnoreCase("mp4")) {
			advancedMusicPlayer.playMp4(fileName);
		}
	}
}
