package core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.StringTokenizer;

public class DefinitionDataFichier implements DefinitionData {

    private static String PATH = "assets\\Dictionary.txt";
    private static int NB_DIFENITION = 16;

    @Override
    public String[] getDifinition() {
        String res[] = {"", ""};
        BufferedReader entree;
        String secretWord = null;
        String question = null;
        Random random = new Random();
        int randNumber = random.nextInt(NB_DIFENITION);
        try {
            entree = new BufferedReader(new FileReader(PATH));
            for (int i = 0; i < randNumber; i++)
                question = entree.readLine();
            StringTokenizer tokenizer = new StringTokenizer(question, "#");
            question = (String) tokenizer.nextElement();
            secretWord = (String) tokenizer.nextElement();

            entree.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        res[0] = question;
        res[1] = secretWord;

        return res;
    }
}
