package gh2;

import deque.Deque;
import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;
import deque.ArrayDeque;

public class GuitarHero {
    private static String KEYBOARD = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    public static final double CONCERT_A = 440.0;
    public static final double CONCERT_C = CONCERT_A * Math.pow(2, 3.0 / 12.0);

    private static double getConcert(int index) {
        return CONCERT_A * Math.pow(2, (index - 24) / 12.0);
    }
    public static void main(String[] args) {
        Deque<GuitarString> strings = new ArrayDeque<>(KEYBOARD.length());
        for (int i = 0; i < KEYBOARD.length(); i++) {
            strings.addLast(new GuitarString(getConcert(i)));
        }

        while (true) {
            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = KEYBOARD.indexOf(key);
                if (index != -1) {
                    strings.get(index).pluck();
                }
            }

            /* compute the superposition of samples */
            double sample = 0;
            for (int i = 0; i < KEYBOARD.length(); i++) {
                sample += strings.get(i).sample();
            }

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            for (int i = 0; i < KEYBOARD.length(); i++) {
                strings.get(i).tic();
            }
        } //while
    }
}
