package com.ajaygeorge.algorithms.uva.UVA100;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by ajay on 1/21/18.
 */
public class Main {
    static String ReadLn (int maxLg)  // utility function to read from stdin
    {
        byte lin[] = new byte [maxLg];
        int lg = 0, car = -1;
        String line = "";

        try
        {
            while (lg < maxLg)
            {
                car = System.in.read();
                if ((car < 0) || (car == '\n')) break;
                lin [lg++] += car;
            }
        }
        catch (IOException e)
        {
            return (null);
        }

        if ((car < 0) && (lg == 0)) return (null);  // eof
        return (new String (lin, 0, lg));
    }

    public static void main (String args[])  // entry point from OS
    {
        Main myWork = new Main();  // create a dinamic instance
        myWork.Begin();            // the true entry point
    }

    void Begin()
    {
        String input;
        StringTokenizer idata;
        int a, b, cyclemax;

        while ((input = Main.ReadLn (255)) != null)
        {
            idata = new StringTokenizer (input);
            a = Integer.parseInt (idata.nextToken());
            b = Integer.parseInt (idata.nextToken());
            if (a<b) {
                cyclemax = getMaxCycleLength(-1, a, b);
            } else {
                cyclemax = getMaxCycleLength(-1, b, a);
            }
            System.out.println (a + " " + b + " " + cyclemax);
        }
    }

    private int getMaxCycleLength(int maxCycleLength, int lowerLimit, int upperLimit) {
        for (int i = lowerLimit; i<=upperLimit; i++) {
            int cycleLength = findCycleLength(i);
            maxCycleLength = Math.max(maxCycleLength, cycleLength);
        }
        return maxCycleLength;
    }

    public int findCycleLength(int number) {
        int count = 1;
        while (number != 1) {
            if (number%2 != 0) {
                number = 3*number + 1;
            } else {
                number = number/2;
            }
            count++;
        }

        return count;
    }
}
