package com.edmodo.lection4;

import java.util.Scanner;

/**
 * Created by pc on 19.11.2016.
 */
public class Squad implements Cloneable {

    String squadName;
    int warriorNumber = (int) (Math.random()*1) + 3;

    public void setName() {
        System.out.println("\u001b[30;m Установите имя отряда\n");
        Scanner scName = new Scanner(System.in);
        squadName = scName.nextLine();

    }

    Warrior[] squad = new Warrior[warriorNumber];

    void createSquad(){
        for (int i = 0; i < warriorNumber; i++) {
            int warriorType = (int) (Math.random() * 3 + 1);
            switch (warriorType) {
                case 1:
                    squad[i] = new Scout();
                    break;
                case 2:
                    squad[i] = new Fighter();
                    break;
                case 3:
                    squad[i] = new Bomber();
                    break;
            }
        }
    }

    void setSquadNameForWarriors() {
        for (Warrior warrior : squad) {
            warrior.setSquadName(squadName);
        }
    }

    //находит случайного живого бойца
    public Warrior getRandomWarrior() {
        int randomWarrior;
        do {
            randomWarrior = (int) (Math.random() * (squad.length - 1));
            System.out.println("\u001b[30;m На бой вызываются:\n");
        } while (!squad[randomWarrior].isAlive());
       // System.out.println(squad[randomWarrior].toString() + "\n");
        return squad[randomWarrior];
    }
    // проверяет, остались ли живые бойцы
    public boolean hasAliveWarriors() {
        for (Warrior warrior : squad) {
            if (warrior.isAlive()) return true;
        } return false;
    }

    @Override
    public String toString() {
        return squadName;
    }

    @Override
    public Squad clone() throws CloneNotSupportedException {
        return (Squad) super.clone();
    }
}
