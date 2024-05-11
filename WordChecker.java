import java.util.ArrayList;

public class WordChecker {
    /** Initialized in the constructor and contains no null elements */
    private ArrayList<String> wordList;

    // constructor added by me
    public WordChecker(ArrayList<String> a){
        wordList = a;
    }

    /**
    * Returns true if each element of wordList (except the first) contains the previous
    * element as a substring and returns false otherwise, as described in part (a)
    * Precondition: wordList contains at least two elements.
    * Postcondition: wordList is unchanged.
    */
    public boolean isWordChain()
    {
        for(int i = 1; i < wordList.size(); i++){
            if(wordList.get(i).indexOf(wordList.get(i - 1)) == -1) return false;
        }

        return false;
    }
    /**
    * Returns an ArrayList<String> based on strings from wordList that start
    * with target, as described in part (b). Each element of the returned ArrayList has had
    * the initial occurrence of target removed.
    * Postconditions: wordList is unchanged.
    * Items appear in the returned list in the same order as they appear in wordList.
    */
    public ArrayList<String> createList(String target)
    {
        ArrayList<String> ret = new ArrayList<String>();

        for(int i = 0; i < wordList.size(); i++){
            if(wordList.indexOf(target) == 0){
                // for "fit-on-paper" purposes
                String temp = wordList.get(i).substring(target.length());
                wordList.add(temp);
            }
        }

        return ret;
    }
    // There may be instance variables, constructors, and methods that are not shown.

    public static void main(String[] args){
        // to be written
    }
}
