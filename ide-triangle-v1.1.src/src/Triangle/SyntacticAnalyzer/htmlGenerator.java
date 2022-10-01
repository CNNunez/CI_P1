/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.SyntacticAnalyzer;

/**
 * This class will be use to generate the HTML file containing the source code with the specified format
 * @author Carolina Narvaez
 */

import java.awt.Desktop;
import java.util.*;
import java.io.*;


public class htmlGenerator {
    // Attributes
    private String sourceFile;
    private String fileName;
    private String fileExtention;
    public StringBuffer HTMLText;
    
    // Init
    public htmlGenerator(String filename) throws Exception{
        fileExtention = ".html";
        fileName = getNewFileName(filename);
        HTMLText = new StringBuffer("");
        
        
        
        // Pruebas
        File f = createFile(fileName);
        writeToFile("Mi codigo va aqui!", true);
        
        
        writeToFile(textFormat('1'), true);
        writeToFile(textFormat('!'), true);
        writeToFile(filename.replace(".tri", ".html"), true);
        
        //closeFile(newFileName);
        
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

    
    
    //Methods use to Create, edit and close the HTML file
    public void writeToFile(String text, boolean isAppend) throws Exception{
        FileWriter writer = new FileWriter(fileName, isAppend);
        writer.write(text);
        writer.close();
    }
    
    public File createFile(String fileName) throws Exception{
        File file = new File(fileName);
        writeToFile("<html><body><h1>Result</h1>", false);
        return file;
    }
    
    public void closeFile() throws Exception{
        writeToFile(HTMLText.toString(), true);
        writeToFile("</body></html>", true);
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
