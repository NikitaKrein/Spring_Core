package myExperience;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.*;

public class Runner {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        System.out.println(musicPlayer.playMusic());

        /* Music music = context.getBean("rockMusic", Music.class);
        Music music1 = context.getBean("classicalMusic", Music.class);
        Music music2 = context.getBean("ambientMusic", Music.class);
        MusicPlayer musicPlayer = new MusicPlayer(music);
        MusicPlayer musicPlayer1 = new MusicPlayer(music1);
        MusicPlayer musicPlayer2 = new MusicPlayer(music2);
        musicPlayer.playMusic();
        musicPlayer1.playMusic();
        musicPlayer2.playMusic();
        */
        //System.out.println(classicalMusic.getSong());
        //ClassicalMusic cl = context.getBean("classicalMusicBean", ClassicalMusic.class);
        //Music music = context.getBean("musicBean", Music.class);
       /* MusicPlayer firstMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer secondMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        boolean comp = firstMusicPlayer == secondMusicPlayer;

        System.out.println(comp);
        System.out.println(firstMusicPlayer);
        System.out.println(secondMusicPlayer);

        firstMusicPlayer.setVolume(79);

        System.out.println(firstMusicPlayer.getVolume());
        System.out.println(secondMusicPlayer.getVolume());*/

        //firstMusicPlayer.playMusic();
        //System.out.println(firstMusicPlayer.getName());
        //System.out.println(firstMusicPlayer.getVolume());


        context.close();
    }
}
