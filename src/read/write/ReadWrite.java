package read.write;

//import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ReadWrite 
{
    public static void main(String[] args) 
    {
        //Write data in byte format
        FileOutputStream outputStream;
        //Wrap data from output stream into character and write into file
        OutputStreamWriter outputStreamWriter;
        //Once buffer space fill up only write to file, so IO process is reduced
        BufferedWriter bufferedWriter;
        
        //Write / insert data
        try
        {
            //Create a file
            outputStream = new FileOutputStream ("MyFile.txt");
            outputStreamWriter = new OutputStreamWriter(outputStream);
            bufferedWriter = new BufferedWriter(outputStreamWriter);
            
            bufferedWriter.write("3");
            bufferedWriter.newLine();
            bufferedWriter.write("YK Liaw");
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(28.00));
            bufferedWriter.newLine();
            
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStreamWriter.close();
            outputStream.close();
            
            System.out.println("File is saved successfully.");
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("File not found error.");
        }
        catch (IOException ex)
        {
            System.out.println("IO Error.");
        }

        
        //Read Data / extract data
        //Open the file to read
        FileReader reader;
        //Read file
        BufferedReader bufferedReader;
        
        try
        {
            reader = new FileReader("MyFile.txt");
            bufferedReader = new BufferedReader(reader);
            
            String line;
            int  num1;
            double num2;
            
            line = bufferedReader.readLine();
            num1 = Integer.parseInt(line);
            System.out.println(num1);
            
            line = bufferedReader.readLine();
            System.out.println(line);
            
            line = bufferedReader.readLine();
            num2 = Double.parseDouble(line);
            System.out.println(num2);
            
            bufferedReader.close();
            reader.close();
        } 
        catch (FileNotFoundException ex)
        {
            System.out.println("File not found error.");
        }
        catch(IOException ex)
        {
            System.out.println("IO Error."); 
        }
 
    }
}
