/*
 * HTML Generator
 */
package Triangle;

/**
 * This class will be use to generate the HTML file containing the source code with the specified format
 * @author Carolina Narvaez
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
    public HTMLGenerator(String filePath) throws Exception{
        fileExtention = ".html";
        newFileName = getNewFileName(filePath);
        
        
        specialChars =  new ArrayList<>(Arrays.asList('+','-','*','=','<','>','&','@','%','^','?','\\'));
        
        
        // Pruebas
        File f = createFile(newFileName);
        writeToFile(newFileName, "Mi codigo va aqui!", true);
        
        
        writeToFile(newFileName, textFormat('1'), true);
        writeToFile(newFileName, textFormat('!'), true);
        writeToFile(newFileName, filePath.replace(".tri", ".html"), true);
        
        
        closeFile(newFileName);
        
        //Desktop.getDesktop().browse(f.toURI());
    }
    
    // Methods
    public String getNewFileName(String filePath){
        return filePath.replace(".tri", ".html");
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
    
    
    // Method to set the text format  -- needs more work
    public String textFormat(char c){
        String text = "";
        
        if (isNumber(c)){
            text = text + "<p>" + "<b style=\"color:blue;\">" + c + "</b>";
        }
        
        if (c == '!'){
            text = text + "<b style=\"color:green;\">" + c + "</b></p>";
        }
        
        return text;
    }
}
