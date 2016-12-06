package com.edmodo.lection4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by pc on 19.11.2016.
 */
class Squad implements Cloneable {

    private String squadName;
    private int warriorsNumber;// (int) (Math.random() * 4) + 3;
    private ArrayList<Warrior> squad;

    void setSquadName() {
        System.out.println("\u001b[30;m Установите имя отряда\n");
        Scanner scName = new Scanner(System.in);
        squadName = scName.nextLine();
    }

    private String getSquadName() {
        return squadName;
    }

    void setSquadSize() {
        System.out.println("\u001b[30;m Сколько бойцов будет в отряде?\n");
        Scanner scNumber = new Scanner(System.in);
        warriorsNumber = scNumber.nextInt();
        squad = new ArrayList<>(warriorsNumber);
    }

    // добавление бойцов в отряд
    void createSquad() {
        String warriorName;
        System.out.println("\u001b[30;m Набираем " + warriorsNumber + " бойцов в отряд " + squadName + "\n");
        for (int i = 0; i < warriorsNumber; i++) {
            boolean isChoiceTypeEnd = false;
            System.out.println("\u001b[30;m Придумайте имя бойца номер " + (i + 1) + "\n");
            Scanner scWarriorName = new Scanner(System.in);
            warriorName = scWarriorName.nextLine();
            while (!isChoiceTypeEnd) {
                System.out.println("\u001b[30;m Выберите класс бойца: \n" + "\u001b[32;m (1) Разведчик\n" + " (2) Борец\n" + " (3) Подрывник\n");
                Scanner scWarriorType = new Scanner(System.in);
                switch (scWarriorType.nextLine()) {
                    case "1":
                        squad.add(i, new Scout(warriorName));
                        isChoiceTypeEnd = true;
                        break;
                    case "2":
                        squad.add(i, new Fighter(warriorName));
                        isChoiceTypeEnd = true;
                        break;
                    case "3":
                        squad.add(i, new Bomber(warriorName));
                        isChoiceTypeEnd = true;
                        break;
                    default:
                        System.out.println("\u001b[30;m Пожалуйста, выберите вариант 1 - 3");
                }
            }
        }
    }

    void setSquadNameForWarriors() {
        for (Warrior warrior : squad) {
            warrior.setSquadName(squadName);
        }
    }

    Warrior getRandomWarrior() {
        int randomWarrior = (int) (Math.random() * (squad.size()));
        return squad.get(randomWarrior);
    }

    boolean hasAliveWarriors() {
        return !squad.isEmpty();
    }

    void needHimDeleteFromSquad(Warrior warrior) {
        if (!warrior.isAlive()) squad.remove(warrior);
    }

    @Override
    public String toString() {
        return squadName;
    }

    //проверял в дебаге и с листом бумаги, вроде все правильно в итоге
    @Override
    public Squad clone() throws CloneNotSupportedException {
        Squad clonedSquad = (Squad) super.clone();
        clonedSquad.squadName = new String(getSquadName());
        clonedSquad.squad = new ArrayList<>(warriorsNumber);
        for (int i = 0; i < warriorsNumber; i++) {
            clonedSquad.squad.add(i, this.squad.get(i).clone());
        }
        clonedSquad.setSquadNameForWarriors();
        return clonedSquad;
    }

}
