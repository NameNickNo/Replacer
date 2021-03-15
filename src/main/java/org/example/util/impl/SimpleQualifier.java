package org.example.util.impl;

import org.example.util.Qualifier;

public class SimpleQualifier implements Qualifier {

    public SimpleQualifier() {
    }

    public String qualifyReplacement(String toReplace) {
        int indexLeftParenthesis = toReplace.indexOf("[");
        String numbersString = toReplace.substring(0, indexLeftParenthesis);
        int count = Integer.parseInt(numbersString);

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < count; i++) {
            String symbols = toReplace.substring(indexLeftParenthesis + 1, toReplace.length() - 1);
            stringBuilder.append(symbols);
        }

        return stringBuilder.toString();
    }
}
