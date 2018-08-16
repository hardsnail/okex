package com.okex.c2c.trading.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Rings {

    private static final String RING_FILE_PATH = "";

    public static void ring() {
        try {
            FileInputStream fileau = new FileInputStream(RING_FILE_PATH);
            Player player;
            player = new Player(fileau);
            player.play();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }

}
