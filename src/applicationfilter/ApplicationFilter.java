/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationfilter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author runef
 */
public class ApplicationFilter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {

            BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("4_19072_0.cxt"), "Cp1252"));
            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("new_4_19072_0.cxt"), "Cp1252"));

            while (input.ready()) {
                String line = input.readLine();
                if (line.contains("Com:=\"\";")) {
                    StringBuilder s = new StringBuilder(line);
                    s.insert(13, "Ingen_kommentar_funnet");
                    line = s.toString();
                }
                output.write(line + "\r\n");
            }
            output.flush();
            output.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
