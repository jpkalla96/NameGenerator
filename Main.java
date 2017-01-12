import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by adrian on 14.11.2016.
 */

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        boolean isMale;
        String lastName = "Gniwotta";
        boolean lastNameAlliteration = false;
        boolean lastNameUse = false;
        char firstLetter = 'A';
        boolean firstLetterUse;
        int maxLength = 100;
        boolean maxLengthUse;
        int minLength = 0;
        boolean minLengthUse;

        Scanner userInput = new Scanner(System.in);
        System.out.println("What gender should the name be? Please enter true for male and false for female.");
        isMale = userInput.nextBoolean();
        System.out.println("Do you have a preferred first letter? Please answer with true or false.");
        firstLetterUse = userInput.nextBoolean();
        if (firstLetterUse){
            System.out.println("Does your preferred first letter depend on your last name? Please answer with true or false.");
            lastNameUse = userInput.nextBoolean();
            if (lastNameUse){
                System.out.println("Please enter your last name.");
                lastName = userInput.next();
                System.out.println("Do you want the name to be an alliteration of your last name? Please answer with true or false.");
                lastNameAlliteration = userInput.nextBoolean();
            }else{
                System.out.println("What is your preferred first letter?");
                firstLetter = userInput.next().toUpperCase().charAt(0);
            }
        }
        System.out.println("Do you have a maximum length for the name? Please answer with true or false.");
        maxLengthUse = userInput.nextBoolean();
        if (maxLengthUse){
            System.out.println("What is your maximum length? Please answer as an int.");
            maxLength = userInput.nextInt();
        }
        System.out.println("Do you have a minimum length for the name? Please answer with true or false.");
        minLengthUse = userInput.nextBoolean();
        if (minLengthUse){
            System.out.println("What is your minimum length? Please answer as an int.");
            minLength = userInput.nextInt();
        }

        File file = new File("C:\\Users\\adria\\IdeaProjects\\Namengenerator\\namen.txt");
        Scanner fileInput = new Scanner(file);
        List<Name> namen = new ArrayList();
        while (fileInput.hasNextLine()) {
            String line = fileInput.nextLine();
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
        fileInput.close();
        userInput.close();
    }
}