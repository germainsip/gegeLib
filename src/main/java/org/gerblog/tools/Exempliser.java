package org.gerblog.tools;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.gerblog.libexemple.Exemple;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class Exempliser {
    //List<Exemple> exempleList;
    public Exemple[] exTab;
    public Exempliser()  {

       // this.exempleList = exempleList;

           //FileReader reader = new FileReader(file);
        try {
            File file = new File(getClass().getResource("/org/gerblog/libexemple/liste_exemples.json").getPath());
            FileReader fileReader = new FileReader(file);

            ObjectMapper mapper = new ObjectMapper();
            this.exTab = mapper.readValue(file,Exemple[].class);
            //BufferedReader br = new BufferedReader(fileReader);

          //  String st;
           // while ((st = br.readLine()) != null)
             //   System.out.println(st);
        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

    }
}
