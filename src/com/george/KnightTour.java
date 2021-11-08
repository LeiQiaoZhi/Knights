package com.george;

import java.util.ArrayList;

public class KnightTour {
    Coord origin;
    int n;

    KnightTour(Coord origin, int n){
        this.origin = origin;
        this.n = n;
    }

    void findPaths(){
        ArrayList<Coord> board = makeboard(n);
        board.removeIf(b->b.equals(new Coord(2,2)));
        ArrayList<Coord> path = new ArrayList<>();
        path.add(origin);
        solve(origin,board,path);
    }

    void solve(Coord coord, ArrayList<Coord> board, ArrayList<Coord> path){
        if (board.isEmpty()) {
            System.out.println("Found Path");
            path.forEach(c-> System.out.print(c.toS() + "->"));
            System.out.print("FINISH\n");
            return;
        }

        // coordinates in the board that can be reached by the current coordinate
        ArrayList<Coord> availables = new ArrayList<Coord>();
        for (Coord r : reachables(coord)) {
            if(board.stream().anyMatch(b->b.equals(r))){
                availables.add(r);
            }
        }

        for (Coord avail : availables) {
            board.removeIf(b->b.equals(avail));
            path.add(avail);
            solve(avail,board,path);
            // backtracked, so we recover the states
            path.remove(avail);
            board.add(avail);
        }
        return;
    }

    public static ArrayList<Coord> makeboard(int n){
        ArrayList<Coord> board = new ArrayList<Coord>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board.add(new Coord(i,j));
            }
        }
        return board;
    }

    ArrayList<Coord> reachables(Coord from){
        ArrayList<Coord> rs = new ArrayList<>(); 
        rs.add(new Coord(from.x+2,from.y+1));
        rs.add(new Coord(from.x+2,from.y-1));
        rs.add(new Coord(from.x-2,from.y+1));
        rs.add(new Coord(from.x-2,from.y-1));
        rs.add(new Coord(from.x+1,from.y+2));
        rs.add(new Coord(from.x+1,from.y-2));
        rs.add(new Coord(from.x-1,from.y+2));
        rs.add(new Coord(from.x-1,from.y-2));
        return rs;
    }
}
