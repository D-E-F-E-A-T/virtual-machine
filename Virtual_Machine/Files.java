import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Files{
    
    public String text = "";

    public void read(String fileName, ArrayList<String> instructions){
        try{
            FileReader file = new FileReader("Files/" + fileName + ".txt");
            BufferedReader readFile = new BufferedReader(file);
            
            Scanner fileOne = new Scanner(new File("Files/" + fileName + ".txt"));
            
            while(fileOne.hasNext()){
                text = text + fileOne.next();
                System.out.println(text);
            }
            
            instructions.add(text);

            file.close();
            readFile.close();
            fileOne.close();

        }catch(IOException e){
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        }
       
    }
    

}