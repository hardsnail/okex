package com.okex.c2c.trading.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Rings {

    private static final String RING_FILE_PATH = "G:\\纯音乐\\庄心妍 - 走着走着就散了.mp3";

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
    
    public static void main(String[] args) {
    	ring();
	}

}
