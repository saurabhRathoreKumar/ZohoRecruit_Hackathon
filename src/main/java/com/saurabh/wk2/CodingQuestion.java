package com.saurabh.wk2;

public class CodingQuestion {
    public static void main(String[] args) {
        CodingQuestion cq = new CodingQuestion();
        String ring = "ownwsn";
        String key = "onwso";
        int ans = cq.minPress(ring, key);
        System.out.println(ans);
    }

    int minPress(String ring, String key) {
        int m = ring.length();
        int position = 0;
        int ans = 0;
        for(int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            int clockwise = getClockwiseDistance(position, ring, c, m);
            int anticlockwise = getAntiClockwiseDistance(position, ring, c, m);

            int press = 0;
            int newPos = 0;
            
            if(clockwise < anticlockwise) {
                press = clockwise + 1;
                newPos = getClockwiseIndex(position, ring, c, m);
            }
            else if(anticlockwise < clockwise) {
                press = anticlockwise + 1;
                newPos = getAntiClockwiseIndexPos(position, ring, c, m);
            }
            else {
                // When equal, check from position 0
                int clockwiseFrom0 = getClockwiseDistance(0, ring, c, m);
                int anticlockwiseFrom0 = getAntiClockwiseDistance(0, ring, c, m);
                
                if(clockwiseFrom0 <= anticlockwiseFrom0) {
                    press = clockwise + 1;
                    newPos = getClockwiseIndex(position, ring, c, m);
                } else {
                    press = anticlockwise + 1;
                    newPos = getAntiClockwiseIndexPos(position, ring, c, m);
                }
            }

            position = newPos;
            ans += press;
        }
        return ans;
    }

    private int getClockwiseDistance(int pos, String ring, char c, int m) {
        int count = 0;
        while (true) {
            if(ring.charAt(pos) == c) {
                return count;
            }
            pos = (pos + 1) % m;
            count++;
        }
    }

    private int getAntiClockwiseDistance(int pos, String ring, char c, int m) {
        int count = 0;
        while (true) {
            if(ring.charAt(pos) == c) {
                return count;
            }
            pos = (pos - 1 + m) % m;
            count++;
        }
    }

    private int getClockwiseIndex(int pos, String ring, char c, int m) {
        while (true) {
            if(ring.charAt(pos) == c) {
                return pos;
            }
            pos = (pos + 1) % m;
        }
    }

    private int getAntiClockwiseIndexPos(int pos, String ring, char c, int m) {
        while (true) {
            if(ring.charAt(pos) == c) {
                return pos;
            }
            pos = (pos - 1 + m) % m;
        }
    }

}
