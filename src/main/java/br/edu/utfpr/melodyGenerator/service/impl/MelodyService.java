package br.edu.utfpr.melodyGenerator.service.impl;

import br.edu.utfpr.melodyGenerator.model.RandomMelody;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service

public class MelodyService {

    RandomMelody randomMelody;

    private Pattern getPattern(){
        return new Pattern(randomMelody.getMelody()).setInstrument(randomMelody.getInstrumentName()).setTempo(randomMelody.getBpm());
    }

    public RandomMelody playMelody(){
        new Player().play(this.getPattern());
        return randomMelody;
    }

    public RandomMelody playOnRepeat(int times){
        new Player().play(this.getPattern().repeat(times));
        return randomMelody;
    }

    public RandomMelody exportMelody(String path, String id) throws IOException {
        File file = new File(path + "Audio " + id + ".midi");
        String pathFile = file.getAbsolutePath();

        MidiFileManager
                .savePatternToMidi(this.getPattern(), new File(pathFile));

        return randomMelody;
    }
}
