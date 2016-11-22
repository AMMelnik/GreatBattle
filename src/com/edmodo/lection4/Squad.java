package com.edmodo.lection4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by pc on 19.11.2016.
 */
class Squad implements Cloneable {

    private String squadName = new String();
    private int warriorNumber = (int) (Math.random() * 1) + 3;
    ArrayList<Warrior> squadList = new ArrayList<>();

    void setName() {
        System.out.println("\u001b[30;m Установите имя отряда\n");
        Scanner scName = new Scanner(System.in);
        this.squadName = scName.nextLine();
    }

    Warrior[] squad = new Warrior[warriorNumber];
    // добавление бойцов в отряд
    void createSquad() {
        for (int i = 0; i < warriorNumber; i++) {
            int warriorType = (int) (Math.random() * 3 + 1);
            int firstNameRandom = (int) (Math.random() * 4);
            int lastNameRandom = (int) (Math.random() * 101 + 1);
            switch (warriorType) {
                case 1:
                    squad[i] = new Scout(firstNameRandom, lastNameRandom);
                    break;
                case 2:
                    squad[i] = new Fighter(firstNameRandom, lastNameRandom);
                    break;
                case 3:
                    squad[i] = new Bomber(firstNameRandom, lastNameRandom);
                    break;
            }
            squadList.add(squad[i]);
        }
    }

    void setSquadNameForWarriors() {
        for (Warrior warrior : squad) {
            warrior.setSquadName(this.squadName);
        }
    }

    //находит случайного живого бойца
    Warrior getRandomWarrior() {
        int randomWarrior = (int) (Math.random() * (squadList.size()));
        return squadList.get(randomWarrior);
    }

    // проверяет, остались ли живые бойцы
    boolean hasAliveWarriors() {
        for (Warrior warrior : squad) {
            if (!warrior.isAlive()) squadList.remove(warrior);
        }
        if (squadList.isEmpty()) {
            return false;
        } else return true;
    }

    @Override
    public String toString() {
        return this.squadName;
    }

    @Override
    public Squad clone() throws CloneNotSupportedException {
        Squad clonedSquad = (Squad) super.clone();
        clonedSquad.squad = (Warrior[]) squad.clone();
        clonedSquad.setName();
        clonedSquad.setSquadNameForWarriors();
        return clonedSquad;
    }

}
