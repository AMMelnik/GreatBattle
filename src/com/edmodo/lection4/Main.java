package com.edmodo.lection4;

import java.util.Scanner;

/**
 * Created by pc on 19.11.2016.
 */
public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("\u001b[30;m Как создать отряды: \n"
                + "\u001b[32;m (1) запустить механизм клонирования\n" + "\u001b[32;m (2) набрать бойцов самостоятельно\n");
        Scanner scTwoSquads = new Scanner(System.in);
        int twoSquads = scTwoSquads.nextInt();
        Battle battle = new Battle();
        battle.readyToBattle(twoSquads);
        battle.startBattle();
    }
}
