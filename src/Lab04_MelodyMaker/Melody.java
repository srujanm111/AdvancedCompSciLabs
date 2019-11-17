package Lab04_MelodyMaker;

import java.util.*;

public class Melody {

    private Queue<Note> notes;

    public Melody(Queue<Note> song) {
        notes = new LinkedList<>();
        song.forEach(note -> notes.offer(note));
    }

    public double getTotalDuration() {
        double duration = 0;
        int o = notes.size();
        for (int i = 0; i < o; i++) {
            Note n = notes.poll();
            notes.offer(n);
            if (n.isRepeat()) {
                duration += n.getDuration() * 2;
                while (true) {
                    n = notes.poll();
                    duration += n.getDuration() * 2;
                    notes.offer(n);
                    if (n.isRepeat()) break;
                }
            } else {
                duration += n.getDuration();
            }
        }

        return duration;
    }

    @Override
    public String toString() {
        String n = "";
        for (Note note : notes) {
            n += note.toString() + "\n";
        }
        return n;
    }

    public void changeTempo(double tempo) {
        for (Note note : notes) {
            note.setDuration(note.getDuration() * tempo);
        }
    }

    public void reverse() {
        Stack<Note> reverse = new Stack<>();
        while (!notes.isEmpty()) reverse.push(notes.poll());
        while (!reverse.isEmpty()) notes.offer(reverse.pop());
    }

    public void append(Melody other) {
        other.notes.forEach(note -> notes.offer(note));
    }

    public void play() {
        int o = notes.size();
        for (int i = 0; i < o; i++) {
            if (notes.peek().isRepeat()) {
                Queue<Note> repeatSection = new LinkedList<>();
                do {
                    Note note = notes.poll();
                    note.play();
                    repeatSection.offer(note);
                    notes.offer(notes.poll());
                } while (!notes.peek().isRepeat());
                Note note = notes.poll();
                note.play();
                repeatSection.offer(note);
                notes.offer(notes.poll());
                while (!repeatSection.isEmpty()) repeatSection.poll().play();
            } else {
                notes.peek().play();
                notes.offer(notes.poll());
            }
        }
    }
}
