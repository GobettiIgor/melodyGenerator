package br.edu.utfpr.melodyGenerator.service.impl;

import br.edu.utfpr.melodyGenerator.enumeration.Durations;
import br.edu.utfpr.melodyGenerator.model.RandomMelody;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class GenerateMelodyService {

    RandomMelody randomMelody;

    public RandomMelody createMelody(RandomMelody randomMelody){
        randomMelody.setMelody("");

        this.randomMelody = randomMelody;

        //if (this.instrumentName != null) melody += "I[" + this.instrumentName + "] ";

        //durations

        final List<String> enumNames = Stream.of(Durations.values())
                .map(Durations::name)
                .collect(Collectors.toList());


        float currentLength = 0; //melody length
        while (currentLength < randomMelody.getLength()){

            //random note
            String note = randomMelody.getNotes().get((int) (randomMelody.getNotes().size()*randomMelody.getR().nextFloat()));

            //duration
            String durationName = enumNames.get((int) (enumNames.size()*randomMelody.getR().nextFloat()));
            float durationValue = Durations.valueOf(durationName).duration;

            //octave
            int octave = 5;
            if (randomMelody.getOctaveInterval() > 1){
                int shift = (int)randomMelody.getOctaveInterval() /2;
                if (randomMelody.getR().nextFloat() < randomMelody.getOctaveShiftProbability())
                    octave += -shift + randomMelody.getR().nextInt(randomMelody.getOctaveInterval());
            }

            //
            randomMelody.setMelody(randomMelody.getMelody() + note  + octave + durationName + " ");

            currentLength += durationValue;
        }

        //System.out.println(this.melody); // Para teste

        return randomMelody;
    }
}
