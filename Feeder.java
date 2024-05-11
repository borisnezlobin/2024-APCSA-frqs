public class Feeder
{
    /**
    * The amount of food, in grams, currently in the bird feeder; initialized in the constructor and
    * always greater than or equal to zero
    */
    private int currentFood;

    /**
    * Simulates one day with numBirds birds or possibly a bear at the bird feeder,
    * as described in part (a)
    * Precondition: numBirds > 0
    */
    public void simulateOneDay(int numBirds)
    {
        boolean isNormal = Math.random() < 0.95;
        if(!isNormal){
            currentFood = 0;
            return;
        }

        int gramsPerBird = (int)(Math.random() * 40 + 0.5) + 10;
        currentFood -= gramsPerBird * numBirds;
        if(currentFood < 0) currentFood = 0;
    }

    /**
    * Returns the number of days birds or a bear found food to eat at the feeder in this simulation,
    * as described in part (b)
    * Preconditions: numBirds > 0, numDays > 0
    */
    public int simulateManyDays(int numBirds, int numDays)
    {
        int count = 0;
        while(count < numDays && currentFood > 0){
            simulateOneDay(numBirds);
            count++;
        }

        return count;
    }

    
    // pray it works, the examples given rely on randomness, so I can't test them.
}