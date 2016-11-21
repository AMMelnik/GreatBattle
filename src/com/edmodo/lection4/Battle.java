package com.edmodo.lection4;

/**
 * Created by pc on 19.11.2016.
 */
public class Battle {

    DateHelper dateHelper = new DateHelper();
    Squad squad1 = new Squad();
    Squad squad2 = null;

  /*  void chooseWarrior(Squad s){
        int unitOfSquad = (int) (Math.random()*s.length)
    }*/

    void readyToBattle(int value) throws CloneNotSupportedException {
        System.out.println("\u001b[32;m Первый отряд\n");
        squad1.setName();
        squad1.createSquad();
        squad1.setSquadNameForWarriors();
        if (value == 1) {
            squad2 = squad1.clone();
            System.out.println("\u001b[32;m Второй отряд\n");
            squad2.setName();
        }
        if (value == 2) {
            squad2 = new Squad();
            System.out.println("\u001b[32;m Второй отряд\n");
            squad2.setName();
            squad2.createSquad();
        }
        squad2.setSquadNameForWarriors();
        System.out.println("\u001b[30;m Первый отряд: " + squad1.toString() + "\n"
                + "\u001b[30;m Второй отряд: " + squad2.toString() + "\n");
    }

    void showBattle() {
         System.out.println(dateHelper.getFormattedStartDate() + "\n");
         while(squad1.hasAliveWarriors()) {
             Warrior warrior1 = squad1.getRandomWarrior();
             Warrior warrior2 = squad2.getRandomWarrior();
             System.out.println("\u001b[30;m Атакует боец " + warrior1.toString() + "\n");
             warrior2.takeDamage(warrior1.attack());
             System.out.println("\u001b[30;m Боец " + warrior2.toString() + "\u001b[30;m  принимает удар!\n");
             dateHelper.skipTime();

             Warrior warrior3 = squad1.getRandomWarrior();
             Warrior warrior4 = squad2.getRandomWarrior();
             System.out.println("\u001b[30;m Атакует боец " + warrior4.toString() + "\n");
             warrior3.takeDamage(warrior4.attack());
             System.out.println("\u001b[30;m Боец " + warrior3.toString() + "\u001b[30;m  принимает удар!\n");
             dateHelper.skipTime();
         }
         System.out.println(dateHelper.getFormattedDiff());
         for (Warrior warrior : squad1.squad) {
            System.out.println(warrior.isAlive());
         }
         for (Warrior warrior : squad2.squad) {
            System.out.println(warrior.isAlive());
         }
    }

}
