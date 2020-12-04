import javax.swing.*;
import java.io.File;
import java.util.*;

//Student Name: MAday Moya
//Date: 11/30/2020
//Program Name: Project2
//Description: Program that reads a Java source-code file and reports the number of keywords
//(including null, true, and false) in the file.


class CountKeywords {
    public static void main(String[] args) throws Exception {

        JFileChooser fileChooser = new JFileChooser(); //Ask the user for the name of the source file (JFileChooser).
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            countKeywords(file);
        } else {
            System.out.println("Ups you forget to select the file");
        }
    }

    public static void countKeywords(File file) throws Exception {
        // Array of all Java keywords + true, false and null
        String[] keywordString = {"abstract", "assert", "boolean",
                "break", "byte", "case", "catch", "char", "class", "const",
                "continue", "default", "do", "double", "else", "enum",
                "extends", "for", "final", "finally", "float", "goto",
                "if", "implements", "import", "instanceof", "int",
                "interface", "long", "native", "new", "package", "private",
                "protected", "public", "return", "short", "static",
                "strictfp", "super", "switch", "synchronized", "this",
                "throw", "throws", "transient", "try", "void", "volatile",
                "while", "true", "false", "null"};


        TreeMap<String, Integer> map = new TreeMap<String, Integer>(); //map to store all the Java keywords.

        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString)); // set with the keys to compare
        int count = 0;

        Scanner input = new Scanner(file); //reads a Java source-code file

        while (input.hasNext()) {
            String word = input.next();
            if (keywordSet.contains(word)) {
                count++;
                if (map.get(word) == null) {
                    map.put(word, 1); // if not exist the key in the map insert it
                } else {
                    int value = map.get(word).intValue(); // if exist get value and increment
                    value++;
                    map.put(word, value); // save the new value
                }
            }
        }

        for (String entry : map.keySet()) {
            System.out.println(" Key: " + entry + " ---> " + " Value:  " + map.get(entry));

        }
        System.out.println(" The number of keywords in  " + file.getName() + " is: " + count);
    }
}


