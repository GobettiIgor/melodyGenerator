package br.edu.utfpr.melodyGenerator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RandomMelody {
    private ArrayList<String> notes;
    private String instrumentName = "";
    private String melody;
    private final Random r = new Random();
    private float length = 4;
    private int bpm;
    private int octaveInterval;
    private float octaveShiftProbability;

    public RandomMelody(final ArrayList<String> notes, final float length, final int bpm){
        this.length = length;
        this.bpm = bpm;
        this.notes = (ArrayList<String>) notes.clone();
    }

    public static HashMap<String, String[]> keys = new HashMap<String, String[]>(){
        {
            put("C MAJOR", new String[]{"C", "D", "E", "F", "G", "A", "B"});
            put("D MAJOR", new String[]{"D", "E", "F#", "G", "A", "B", "C#"});
            put("E MAJOR", new String[]{"E", "F#", "G#", "A", "B", "C#", "D#"});
            put("F MAJOR", new String[]{"F", "G", "A", "Bb", "C", "D", "E"});
            put("G MAJOR", new String[]{"G", "A", "B", "C", "D", "E", "F#"});
            put("A MAJOR", new String[]{"A", "B", "C", "D", "E", "F#", "G#"});
            put("C MINOR", new String[]{"C", "D", "Eb", "F", "G", "Ab", "Bb"});
            put("D MINOR", new String[]{"D", "E", "F", "G", "A", "Bb", "C"});
            put("E MINOR", new String[]{"E", "F#", "G", "A", "B", "C", "D"});
            put("F MINOR", new String[]{"F", "G", "Ab", "Bb", "C", "Db", "Eb"});
            put("G MINOR", new String[]{"G", "A", "Bb", "C", "D", "Eb", "F"});
            put("A MINOR", new String[]{"A", "B", "C", "D", "E", "F", "G"});
            put("B MINOR", new String[]{"B", "C#", "D", "E", "F#", "G", "A"});
        }
    };

    public RandomMelody(final ArrayList<String> notes){
        this.notes = (ArrayList<String>) notes.clone();
    }

    public RandomMelody setBpm(final int bpm){
        this.bpm = bpm;
        return this;
    }
    public RandomMelody setLength(final float length){
        this.length  = length;
        return this;
    }
    public RandomMelody setMainInstrumentName(String instrumentNameConstant){
        this.instrumentName = instrumentNameConstant;
        return this;
    }
    public RandomMelody setOctaveInterval(int octaveInterval){
        this.octaveInterval = octaveInterval;
        return this;
    }
    public RandomMelody setOctaveShiftProbability(final float octaveShiftProbability){
        this.octaveShiftProbability = octaveShiftProbability;
        return this;
    }

    public String getMelody(){
        return this.melody;
    }

}
