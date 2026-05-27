public class LetterSample {
    private String wordSegment;
    private char nextLetter;
    /*
    Constructor that constructs a letter sample object, initializing the word segment and next letter according to the 
    input as the constructor is called
    */
    public LetterSample(String wordSegment, char nextLetter){
        this.wordSegment = wordSegment;
        this.nextLetter = nextLetter;
    }
    // Returns the word segment of the letter sample
    public String getSegment(){
        return wordSegment;
    }
    // Returns the next letter of the letter sample
    public char getNextLetter(){
        return nextLetter;
    }
    //Returns a string that represents the letter sample
    public String toString(){
        return "\"" + wordSegment + "\" -> " + nextLetter;
    }
    public static final char STOP = '.';
    // Generates letter samples that represent an inputted word, according to the inputted segment size
    public static LetterSample[] toSamples(String input, int segmentSize){
        input += STOP;
        LetterSample[] myLetterSamples = new LetterSample[input.length()];
        for(int i = 0; i < input.length(); i++){
            String retString = "";
            if(i <= segmentSize){
                for(int j = 0; j < i; j++){
                    retString += input.charAt(j);
                }
            }
            else{
                for(int k = segmentSize; k > 0; k--){
                    retString += input.charAt(i - k);
                }
            }
            myLetterSamples[i] = new LetterSample(retString, input.charAt(i));
        }
        return myLetterSamples;
    }
}
