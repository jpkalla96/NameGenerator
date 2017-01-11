import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by adrian on 14.11.2016.
 */

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        boolean isMale = true;
        String lastName = "Gniwotta";
        boolean lastNameAlliteration = true;
        boolean lastNameUse = false;
        char firstLetter = 'A';         //if you set lastNameUse to "true", your input for your preferred first letter is automatically ignored
        boolean firstLetterUse = true;
        int maxLength = 8;
        boolean maxLengthUse = true;
        int minLength = 3;
        boolean minLengthUse = false;


        File file = new File("C:\\Users\\adria\\IdeaProjects\\Namengenerator\\namen.txt");
        Scanner input = new Scanner(file);
        List<Name> namen = new ArrayList();
        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line != ""){
                String[] namenInput = line.split(" ");
                namen.add(new Name(namenInput[0], namenInput[1].charAt(0)));
            }
        }
        for(int i = 0; i < namen.size(); i++){
            if (namen.get(i).isMale(isMale)){
                if(namen.get(i).lastName(lastName, lastNameAlliteration, lastNameUse)){
                    if(namen.get(i).firstLetter(firstLetter, firstLetterUse, lastNameUse)){
                        if(namen.get(i).maxLength(maxLength, maxLengthUse)){
                            if(namen.get(i).minLength(minLength, minLengthUse)){
                                System.out.println(namen.get(i).getName());
                            }
                        }
                    }
                }
            }
        }
        input.close();
    }
}