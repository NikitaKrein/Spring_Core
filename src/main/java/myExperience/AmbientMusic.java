package myExperience;

import org.springframework.stereotype.Component;

public class AmbientMusic implements Music {
    @Override
    public String getSong() {
        return "Hop Hey Laley";
    }
}
