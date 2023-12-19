package com.thomasb.audio_utils;

import java.util.HashMap;

import com.mpatric.mp3agic.Mp3File;

import java.io.InputStream;

public class App {
    public static void main(String[] args) {

        Command.setArgs(args);
        HashMap<String, String> options = Command.parseArgs();
        Command.storeParsedArgs(options);
        String input = Command.getArg("input");
        System.out.println(input);
        try {
            Mp3File mp3File = new Mp3File(input);
            System.out.println(mp3File.getLengthInMilliseconds());
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
