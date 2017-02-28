import java.util.Random;

/**
 * Spinner will create a spinner that has >= 2 options.  Users can spin it to get 
 * a randomly selected value.
 * 
 * @author Ben Link
 *
 */
public class Spinner {
    public final static int SPINNER_MINIMUM = 2;
    public final static int SPINNER_DEFAULT = 10;
    
    private int maxValue;
    private int currentValue;
    
    private Random randomizer;

    public Spinner(){
        this(SPINNER_DEFAULT);
    }
    public Spinner(int newMaxValue) {
        this.setMaxValue(newMaxValue);
        randomizer = new Random();
    }

    public int getCurrentValue() {
        return currentValue;
    }
    public int getMaxValue() {
        return maxValue;
    }

    public int spin(){
        setCurrentValue(randomizer.nextInt(getMaxValue()) + 1);
        return getCurrentValue();
    }
    
    private void setCurrentValue(int newCurrentValue){
        if(newCurrentValue >= 1 && newCurrentValue <= this.getMaxValue()){
            this.currentValue = newCurrentValue;
        } else {
            this.currentValue = 1;
        }
    }
    private void setMaxValue(int newMaxValue) {
        if(newMaxValue >= SPINNER_MINIMUM){
            this.maxValue = newMaxValue;
        } else {
            this.maxValue = SPINNER_DEFAULT;
        }
    }
}
