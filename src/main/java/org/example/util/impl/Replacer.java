package org.example.util.impl;

import org.example.util.CanReplace;
import org.example.util.Qualifier;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Replacer implements CanReplace {
    private Qualifier qualifier;

    public Replacer() {
    }

    public Replacer(Qualifier qualifier) {
        this.qualifier = qualifier;
    }

    public Qualifier getQualifier() {
        return qualifier;
    }

    public void setQualifier(Qualifier qualifier) {
        this.qualifier = qualifier;
    }




    public String replace(String expression) {
        List<String> stringList = new ArrayList<>();
        stringList.add(expression);
        Pattern pattern = Pattern.compile("\\d+\\[[a-zA-Z]*" + "]");

        int count = 0;

        while (stringList.get(count).contains("[")) {
            Matcher matcher = pattern.matcher(stringList.get(count));


            while (matcher.find()) {
                String toReplace = matcher.group();
                String replacement = qualifier.qualifyReplacement(toReplace);
                String updatedString = stringList.get(count).replace(toReplace, replacement);

                stringList.add(updatedString);
                count++;
            }

        }

        return stringList.get(stringList.size() - 1);
    }
}
