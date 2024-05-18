package org.example;

import java.util.ArrayList;

public class FindingBy {

    public void findingByName(String name) {
        ArrayList<Program> programs = LIstProgram.createList();
        ArrayList<Program> foundPrograms = new ArrayList<>();

        for (Program program : programs) {
            if (program.getName().equalsIgnoreCase(name)) {
                foundPrograms.add(program);
            }
        }

        for (Program program : foundPrograms) {
            System.out.println(program.toString());
        }
    }

    public void findingByChannelAndCurrentTime(String channel,int time) {
        ArrayList<Program> nowPrograms = RunningProgramms.programsOnThemMoment(time);
        ArrayList<Program> foundPrograms = new ArrayList<>();

        for (Program program : nowPrograms) {
            if (program.getChannel().equalsIgnoreCase(channel)) {
                foundPrograms.add(program);
            }
        }

        for (Program program : foundPrograms) {
            System.out.println(program.toString());
        }
    }
    public void findingByChannelAndTimeBetween (
            String channel,
            int intTime1,
            int intTime2
    ) {
        String timeEarlier = String.valueOf(intTime1);
        String timeAfter = String.valueOf(intTime2);

        ArrayList<Program> programs = LIstProgram.createList();

        ArrayList<Program> programsInInterval = new ArrayList<>();

        for (Program program : programs) {
            if (program.getChannel().equalsIgnoreCase(channel)) {
                BroadcastsTime programStartTime = new BroadcastsTime(timeEarlier);
                BroadcastsTime programEndsTime = new BroadcastsTime(timeAfter);

                if (program.getChannel().equalsIgnoreCase(channel)) {
                    if (program.getTime().between(
                            programStartTime,
                            programEndsTime)) {
                        programsInInterval.add(program);
                    }
                }
            }
            for (Program prog : programsInInterval) {
                System.out.println(prog.toString());
            }
        }
    }



}
