package com.george;

import java.nio.charset.CoderResult;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        KnightTour knightTour = new KnightTour(new Coord(2,2), 5);
        knightTour.findPaths();
    }
}

class Coord{
    int x;
    int y;
    Coord(int x, int y){
        this.x = x;
        this.y = y;
    }

    boolean equals(Coord other){
        if(other.x==this.x&&other.y==this.y){
            return true;
        }
        return false;
    }

     String toS(){
        return "(" + this.x + "," + this.y + ")";
    }
}
