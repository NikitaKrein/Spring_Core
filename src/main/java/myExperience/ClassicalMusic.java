package myExperience;

import org.springframework.stereotype.Component;

@Component
public class ClassicalMusic implements Music {
    private ClassicalMusic(){}

    public static ClassicalMusic getClassicalMusic(){
        return new ClassicalMusic();
    }

    public void doMyInit(){
        System.out.println("Doing doing");
    }

    public void doMyDestroy(){
        System.out.println("Doing reeeeeeeedoing");
    }

    @Override
    public String getSong() {
        return "Bohemian Rhapsody";
    }
}
