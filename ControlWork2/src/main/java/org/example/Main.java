package org.example;

import org.example.io.TXTParser;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] header = new String[]{"Канал","Время","Название"};
        ArrayList<Program> sortPrograms = RunningProgramms.programsSortedByTime();
        String[][] answer = new String[sortPrograms.size()][3];
        int index = 0;
        for(Program program: sortPrograms){
            String str = program.toString();
            String[] cols = str.split(";");
            answer[index++] = cols;
        }

        io.XLSXActions.writeFile(answer,"salfetka5.xlsx",header,"title");
    }
}