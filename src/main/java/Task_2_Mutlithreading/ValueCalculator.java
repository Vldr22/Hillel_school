package Task_2_Mutlithreading;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class ValueCalculator implements UseMultithreading {

    protected float[] array;
    protected float[] halfArray1;
    protected float[] halfArray2;
    protected final int ARRAY_LANG = 5000000;
    protected final int HALF_ARRAY_LANG = ARRAY_LANG / 2;

    protected long start;

    public ValueCalculator() {
        this.array = new float[ARRAY_LANG];
        this.halfArray1 = new float[HALF_ARRAY_LANG];
        this.halfArray2 = new float[HALF_ARRAY_LANG];
        createArray();
    }

    private void createArray() {
        start = System.currentTimeMillis();
        for (int i = 0; i < ARRAY_LANG; i++) {
            array[i] = 1;
        }
        arrayHalfCopy();
    }

    protected void arrayHalfCopy() {
        System.arraycopy(array, 0, halfArray1, 0, HALF_ARRAY_LANG);
        System.arraycopy(array, 0, halfArray2, 0, HALF_ARRAY_LANG);
    }

    protected void gateGluing() {
        IntStream.range(0, HALF_ARRAY_LANG).forEach(i -> halfArray1[i] =
                (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2)));
        IntStream.range(0, HALF_ARRAY_LANG).forEach(i -> halfArray2[i] =
                (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2)));
    }

    protected void reverse() {
        System.arraycopy(halfArray1, 0, array, 0, HALF_ARRAY_LANG);
        System.arraycopy(halfArray2, 0, array, HALF_ARRAY_LANG, HALF_ARRAY_LANG);
    }

    protected void shuffling() {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        for (int i = ARRAY_LANG - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);

            float temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    protected void findMaxValue() {
        float maxValue = 0;
        for (int i = 1; i < ARRAY_LANG; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }
    }
}
