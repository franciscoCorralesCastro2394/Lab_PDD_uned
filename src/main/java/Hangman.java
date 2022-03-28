import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Hangman {

    Set<String> usedWordsSet = new HashSet<>();
    Set<String> wordsList = new HashSet<>();

    public int countAlphabet(String word, char alphabet){

        int numAlp = 0;

        for(char alp:word.toCharArray())
        {
            if(alp == alphabet){
                numAlp += 1;
            }
        }


        return numAlp;
    }

    public String fetchWord(int requestLen){

        for (String result : wordsList){

            if (result.length() != requestLen) continue;
            else if (usedWordsSet.add(result)) return result;
        }

        return null;

    }

    public void loadWords(){

        String word = null;

        try(BufferedReader br = new BufferedReader(new FileReader("src/words.txt"))) {
            while ((word = br.readLine()) != null){
                wordsList.add(word);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String fetchClue(String word,String clue, char guess){

        if (guess < 'a' || guess > 'z') throw new IllegalArgumentException("Invalid character");

        StringBuilder newClue = new StringBuilder();
        for (int i = 0; i< word.length(); i++){
            if (guess == word.charAt(i) && guess != clue.charAt(i)){
                newClue.append(guess);
            }else newClue.append(clue.charAt(i));
        }

        System.out.println(newClue.toString());
        return newClue.toString();
    }
}
