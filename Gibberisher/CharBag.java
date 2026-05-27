import java.util.Random;
public class CharBag {
    private int[] lettersInBag;
    // Constructor that creates a CharBag Object
    public CharBag(){
        lettersInBag = new int[27];
        for(int i = 0; i < 27; i++){
            lettersInBag[i] = 0;
        }
    }
    // Adds a character to the character bag
    public void add(char newLetter){
        if(((int)newLetter) >= 65 && ((int)newLetter) <= 90){
            newLetter += 32;
            lettersInBag[newLetter - 97] += 1;
        }
        else if(((int)newLetter) >= 97 && ((int)newLetter) <= 122){
            lettersInBag[newLetter - 97] += 1;
        }
        else{
            lettersInBag[26] += 1;
        }
    }
    // Removes a character from the character bag
    public void remove(char removedLetter){
        if(((int)removedLetter) >= 65 && ((int)removedLetter) <= 90){
            removedLetter += 32;
            if(lettersInBag[removedLetter - 97] != 0){
                lettersInBag[removedLetter - 97] -= 1;
            }
        }
        else if(((int)removedLetter) >= 97 && ((int)removedLetter) <= 122){
            if(lettersInBag[removedLetter - 97] != 0){
                lettersInBag[removedLetter - 97] -= 1;
            }       
        }
        else{
            if(lettersInBag[26] != 0){
                lettersInBag[26] -= 1;
            }
        }
    }
    // Returns the number of the inputted characters in the character bag
    public int getCount(char countedLetter){
        if(((int)countedLetter) >= 65 && ((int)countedLetter) <= 90){
            countedLetter += 32;
            return lettersInBag[countedLetter - 97];
        }
        else if(((int)countedLetter) >= 97 && ((int)countedLetter) <= 122){
            return lettersInBag[countedLetter - 97];
        }
        else{
            return lettersInBag[26];
        }
    }
    // Returns the number of characters in the character bag overall
    public int getSize(){
        int sum = 0;
        for(int i = 0; i < 27; i++){
            sum += lettersInBag[i];
        }
        return sum;
    }
    // Returns a string that displays the contents of the character bag
    public String toString(){
        String retString = "CharBag{";
        for(int i = 0; i < 26; i++){
            retString += (char)(i + 97) + ":" + lettersInBag[i] + ", ";
        }
        retString += LetterSample.STOP + ":" + lettersInBag[26] + "}";
        return retString;
    }
    // Returns a character chosen at random in our character bag
    public char getRandomChar(){
        if(this.getSize() == 0){
            return '.';
        }
        Random random = new Random();
        int count = random.nextInt(this.getSize());
        for(int i = 97; i < 123; i++){
            count -= getCount((char)i);
            if(count < 0){
                return (char)i;
            }
        }
        return LetterSample.STOP;
        
    }
}
