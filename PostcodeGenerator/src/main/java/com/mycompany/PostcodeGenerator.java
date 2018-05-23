/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author FeniksBV
 */
public class PostcodeGenerator {
    //
    // Een postcodetable (Excel) is van het web geplukt.
    // Dat bestand is geconverteerd naar een TAB-seperated bestand: postcodeFromWeb.txt
    // Data uit dat bestand wordt gelezen en omgezet naar SQL queries (inserts).
    // Dat sql bestand kan dienen om via een mysql commando te worden gebruikt
    // om een mysql tabel (postcode) te vullen met postcde / straatnaam / woonplaats
    //
    // mysql -u root -pyourpassword applikaasie < postcodeInsert.sql

    public static void main(String[] args) {

        try (Scanner input = new Scanner(new File("postcodeFromWeb.txt"));
                PrintWriter output = new PrintWriter("postcodeInsert.sql");) {

            boolean firstLine = true;
            while (input.hasNext()) {
                String line = input.nextLine();
                // skip de eerste regel want die bevat de kolomnamen
                if (!firstLine) {
                    // Kolommen worden gescheiden door tabs
                    String tokens[] = line.split("\t");

                    // Pas op: er zijn straatnamen met dubbelquote in de naam.
                    // Hier loopt je sql tzt op vast.
                    // replace alle dubbelquote met enkele quote
                    String straatNaam = tokens[5].replace("\"", "'");

                    output.printf("INSERT IGNORE INTO postcode (postcode,straat, plaats) VALUES(\"%s\",\"%s\",\"%s\")\n",
                            tokens[2], straatNaam, tokens[8]);
                }
                firstLine = false;
            }
            
            
        } catch (FileNotFoundException ex) {
            System.out.println("File not found exception, das jammer");
        }

    }

}
