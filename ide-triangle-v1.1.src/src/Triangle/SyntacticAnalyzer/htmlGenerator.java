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
        File f = createFile();
    }
    
    // Methods
    // Get the HTML file name
    public String getNewFileName(String filePath){
        return filePath.replace(".tri", ".html");
    }

    //Methods use to Create, edit and close the HTML file
    public void writeToFile(String text, boolean isAppend) throws Exception{
        FileWriter writer = new FileWriter(fileName, isAppend);
        writer.write(text);
        writer.close();
    }
    
    public File createFile() throws Exception{
        File file = new File(fileName);
        writeToFile("<!DOCTYPE html><html><head><style>" + ".myDiv {border: 5px outset DodgerBlue;background-color: white; text-align: left;}" + "</style>" + "</head><body><h1>Result</h1><div class=\"myDiv\">", false);
        return file;
    }
    
    public void closeFile() throws Exception{
        writeToFile(HTMLText.toString(), true);
        writeToFile("</div></body></html>", true);
    }
}