/*
 * HTML Generator
 */
package Triangle;

/**
 * This class will be use to generate the HTML file containing the source code with the specified format
 * @author Caro Jhonny Nikko
 */

import java.awt.Desktop;
import java.util.*;
import java.io.*;


public class HTMLGenerator {
    // Attributes
    private String sourceFile;
    private String newFileName;
    private String fileExtention;
    public ArrayList<Character> specialChars;
    
    // Init
    public HTMLGenerator() throws Exception{
        sourceFile = "source2.tri";
        fileExtention = ".html";
        newFileName = getNewFileName(sourceFile);
        
        
        specialChars =  new ArrayList<>(Arrays.asList('+','-','*','=','<','>','&','@','%','^','?','\\'));
        
        
        // Pruebas
        File f = createFile(newFileName);
        writeToFile(newFileName, "Mi codigo va aqui!", true);
        
        
        writeToFile(newFileName, textFormat('1'), true);
        writeToFile(newFileName, textFormat('!'), true);
        
        
        closeFile(newFileName);
        
        //Desktop.getDesktop().browse(f.toURI());
    }
    
    // Methods
    public String getNewFileName(String sourceFileName){
        String newName = (new StringBuilder()).append(sourceFileName.substring(0, sourceFileName.lastIndexOf("."))).append(fileExtention).toString();
        return newName;
    }
    
    // This methods will let us know the type of char we are analyzing
    public boolean isNumber(char n) {
        return (n >= '0' && n <= '9');
    }
    
    public boolean isAlpha(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    public boolean isSpecial(char s) {
        for (char i : specialChars){
            if (s == i){
                return true;
            }
        }
        return false;
    }
    
    
    //Methods use to Create, edit and close the HTML file
    public void writeToFile(String fileName, String text, boolean isAppend) throws Exception{
        FileWriter writer = new FileWriter(fileName, isAppend);
        writer.write(text);
        writer.close();
    }
    
    public File createFile(String fileName) throws Exception{
        File file = new File(fileName);
        writeToFile(fileName, "<html><body><h1>Result</h1>", false);
        return file;
    }
    
    public void closeFile(String fileName) throws Exception{
        writeToFile(fileName, "</body></html>", true);
    }
    
    
    // Method to set the text forma  -- needs more work
    public String textFormat(char c){
        String text = "";
        
        if (isNumber(c)){
            text = text + "<p style=\"color:blue;\">" + c + "</p>";
        }
        
        if (c == '!'){
            text = text + "<p style=\"color:green;\">" + c + "</p>";
        }
        
        return text;
    }
}
