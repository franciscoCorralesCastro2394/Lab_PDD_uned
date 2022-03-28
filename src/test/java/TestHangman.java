
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class TestHangman {

    @Test
    void test_alphabetCountInAWord(){

        String word = "pizza";
        char alphabet = 'a';

        Hangman hangman = new Hangman();

        int count = hangman.countAlphabet(word,alphabet);

        assertEquals(1,count);

    }

    @Test
    public void test_lenOfFetchedWord(){

        Hangman hangman = new Hangman();
        String word = hangman.fetchWord(5);

        assertTrue(word.length() == 5);

    }

    @Test
    public void test_lenOfFetchedWordRandom(){

        Random random = new Random();
        int requestedLen = 5 + random.nextInt((9 - 5) + 1);
        System.out.println(requestedLen);

        Hangman hangman = new Hangman();
        hangman.loadWords();

        String word = hangman.fetchWord(requestedLen);
        System.out.println(word);

        assertTrue(word.length() == requestedLen);


    }

    @Test
    public void test_uniqueOfFetchedWord(){

        Random random = new Random();

        Set<String> usedWordsSet = new HashSet<>();

        int round = 0;
        String word = null;

        Hangman hangman = new Hangman();
        hangman.loadWords();

        while (round < 10){
            int requestedLen = 5 + random.nextInt((9 - 5) + 1);
            String result = hangman.fetchWord(requestedLen);
            System.out.println(result);
            System.out.println(requestedLen);
            assertTrue(usedWordsSet.add(result));
            round++;
        }


    }


    @Test
    void  test_whenInvalidGuessThenFetchClueThrowsExcp(){

        Hangman hangman = new Hangman();

        Exception e = assertThrows(IllegalArgumentException.class,
                () -> hangman.fetchClue("pizza","-----",'1')
                );
        assertEquals("Invalid character",e.getMessage());


    }


}
