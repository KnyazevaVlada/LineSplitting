package split;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String name;
        Date birthdate;
        String [] list;
        String line;

        try(BufferedReader fileReader = new BufferedReader(new FileReader(args[0]))) {
            while ((line = fileReader.readLine()) != null) {
                list = line.split("(?<=\\D) (?=\\d)");
                name = list[0];
                birthdate = new SimpleDateFormat("dd MM yyyy").parse(list[1]);
                PEOPLE.add(new Person(name,birthdate));
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}

