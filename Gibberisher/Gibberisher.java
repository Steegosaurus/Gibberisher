public class Gibberisher {
    private Trie<CharBag> model;
    private int segmentLength;
    private int letterSamplesProcessed;
    // Constructor that creates a Gibberisher object.
    public Gibberisher(int segmentLength){
        this.segmentLength = segmentLength;
        model = new Trie<>();
        letterSamplesProcessed = 0;
    }
    /*
    Function "trains" our Trie<CharBag> Node system based on a given string array. 
    This means that a node tree is built based on the words in our string array.
    */
    public void train(String[] stringArray){
        for(int i = 0; i < stringArray.length; i++){
            LetterSample[] sample = LetterSample.toSamples(stringArray[i], segmentLength);
            for(int k = 0; k < sample.length; k++){
                if(model.get(sample[k].getSegment()) == null){
                    model.put(sample[k].getSegment(), new CharBag());
                }
                model.get(sample[k].getSegment()).add(sample[k].getNextLetter());
            }
            letterSamplesProcessed += 1;
        }
    }
    // Returns the number of samples processed.
    public int getSampleCount(){
        return letterSamplesProcessed;
    }
    // Generates a random word based on the model that should have already been trained.
    public String generate(){
        String word = "";
        String stringSeg;
        CharBag letterCounts;
        char nextChar;
        int k = 0;
        while((word.length() == 0 || (word.charAt(word.length() - 1) != LetterSample.STOP)) && k <= 100){
            k++;
            if(word.length() <= segmentLength){
                stringSeg = word;
            }
            else{
                stringSeg = "";
                for(int i = word.length() - segmentLength; i < word.length(); i++){
                    stringSeg += word.charAt(i);
                }
            }
            letterCounts = model.get(stringSeg);
            if(letterCounts == null){
                word += LetterSample.STOP;
            }
            else{
                nextChar = letterCounts.getRandomChar();
                if(nextChar == LetterSample.STOP){
                    return word;
                }
                else{
                    word += nextChar;
                }
            }
        }
        return word;
    }
}
