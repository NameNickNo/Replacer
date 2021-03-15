package org.example;

import org.example.util.CanReplace;
import org.example.util.impl.Replacer;
import org.example.util.impl.SimpleQualifier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) {

        CanReplace replacer = new Replacer(new SimpleQualifier());

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string;

        try {
            string = bufferedReader.readLine();

            System.out.println(replacer.replace(string));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
