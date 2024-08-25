public class WordMatch {
    private String secret;

    public WordMatch(String secret) {
        this.secret = secret;
    }

    public int scoreGuess(String guess) { //can parse int
        if (guess.isEmpty()) {
            throw new IllegalArgumentException("Your guess cannot be an empty String!");
        }
        if (guess.length()>secret.length()) {
            throw new IllegalArgumentException("Your guess cannot exceed the number of characters in the Secret word");
        }
        int occurrences = 0;
        int index = secret.indexOf(guess);
        while (index!=-1) {
            occurrences++;
            index = secret.indexOf(guess, index+1);
        }
        return occurrences*guess.length()*guess.length();
    }

    public String findBetterGuess(String guess1, String guess2) {
        int guess1Score = scoreGuess(guess1);
        int guess2Score = scoreGuess(guess2);
        if (guess1Score>guess2Score) {
            return guess1;
        }
        else if (guess2Score>guess1Score) {
            return guess2;
        }
        else {
            if (guess1.compareTo(guess2)>0) {
                // positive = guess 1 is alphabetically better (further down the alphabet) than guess 2
                return guess1;
            }
            else {
                return guess2;
            }
        }
    }
}
