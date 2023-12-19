package com.thomasb.audio_utils;

import java.util.HashMap;

public class Command {
    static private String[] args;
    static private HashMap<String, String> options;

    static public void setArgs(String[] args) {
        Command.args = args;
    }

    // only supports --option for now
    static public HashMap<String, String> parseArgs() {
        HashMap<String, String> options = new HashMap<String, String>();
        String tempKey = "unknown";
        String tempValue = "unknown";
        for (String flag : args) {
            if ((flag.startsWith("--"))) {
                tempKey = flag.substring(2);
            } else {
                tempValue = flag;
                options.put(tempKey, tempValue);
            }
        }
        return options;
    }

    static public void storeParsedArgs(HashMap<String, String> options) {
        Command.options = options;
    }

    static public String getArg(String key) {
        String value = Command.options.get(key);
        if (value == null) {
            System.out.println("Error: " + key + " is not a valid option.");
            System.exit(1);
        }
        return value;
    }
}
