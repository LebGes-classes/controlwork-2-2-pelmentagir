
package org.example;

import org.example.io.TXTParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class RunningProgramms {
    public static ArrayList<Program> programsSortedByTime() {
        ArrayList<Program> programs = LIstProgram.createList();

        Comparator<Program> comparator = new Comparator<Program>() {
            @Override
            public int compare(Program p1, Program p2) {
                int channelComparison = p1.getChannel().compareTo(p2.getChannel());
                if (channelComparison!= 0) {
                    return channelComparison;
                } else {
                    return p1.getTime().compareTo(p2.getTime());
                }
            }
        };

        Collections.sort(programs, comparator);

        return programs;
    }
    public static ArrayList<Program> programsOnThemMoment (int time) {
        ArrayList<String> channelsAfterParsing = TXTParser.parser("data.txt");

        ArrayList<Program> programList = new ArrayList<>();

        for (int i = 0; i < channelsAfterParsing.size() - 1; i++){
            String str = channelsAfterParsing.get(i);
            String channelsStr = channelsAfterParsing.get(i + 1);
            if (str.charAt(0) == '#') {
                continue;
            } else if (Character.isDigit(str.charAt(0))) {
                BroadcastsTime bt1 = new BroadcastsTime(str);
                BroadcastsTime bt2 = new BroadcastsTime(String.valueOf(time));

                if (bt1.compareTo(bt2) == 0) {
                    String[] data = channelsStr.split(" ");
                    programList.add(new Program(
                            data[0],
                            data[1],
                            data[2]
                    ));
                    i++;
                }
            }
        }
        return programList;
    }
}
