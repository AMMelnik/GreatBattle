package com.edmodo.lection4;

/**
 * Created by pc on 19.11.2016.
 */
public class Battle {

    private Squad squad1 = new Squad();
    private Squad squad2 = null;

    void readyToBattle(int value) throws CloneNotSupportedException {
        System.out.println("\u001b[32;m Первый отряд\n");
        squad1.setName();
        squad1.setSquadSize();
        squad1.createSquad();
        squad1.setSquadNameForWarriors();

        /* "глубокое" клонирование второго отряда не получается. копируются ссылки, отряд дерется сам с собой
        Может надо Equals переопределять?
         */
        if (value == 1) {
            try {
                System.out.println("\u001b[32;m Второй отряд\n");
                squad2 = squad1.clone();
            } catch (CloneNotSupportedException e) {
                System.out.println("Отряд не может быть клонирован");
            }
        }
        // создаем второй отряд с нуля
        if (value == 2) {
            squad2 = new Squad();
            System.out.println("\u001b[32;m Второй отряд\n");
            squad2.setName();
            squad2.setSquadSize();
            squad2.createSquad();
            squad2.setSquadNameForWarriors();
        }
        System.out.println("\u001b[30;m Первый отряд: " + squad1.toString() + "\n"
                + "\u001b[30;m Второй отряд: " + squad2.toString() + "\n");
    }

    void startBattle() {
        DateHelper dateHelper = new DateHelper();
        // выводим текущую дату-время -1500 лет
        System.out.println(dateHelper.getFormattedStartDate() + "\n");
        Warrior warrior1, warrior2;
        boolean isBattleEnd = false;
        // пока есть живые в обоих отрядах
        while (!isBattleEnd) {
            //выбор бойцов для первого раунда
            warrior1 = squad1.getRandomWarrior();
            warrior2 = squad2.getRandomWarrior();
            // описание раунда
            StringBuilder strBattleFirstRound = new StringBuilder("\u001b[30;m     На бой вызываются: \n")
                    .append(warrior1.toString() + "и " + warrior2.toString() + "\n")
                    .append("\u001b[30;mАтакует боец " + warrior1.getNameOnly() + "\n")
                    .append("\u001b[30;mБоец " + warrior2.getNameOnly() + "\u001b[30;m  принимает удар!");
            System.out.println(strBattleFirstRound);
            // удар и потеря здоровья
            warrior2.takeDamage(warrior1.attack());
            System.out.println(warrior2.getHealthStatus());
            squad2.needHimDeleteFromSquad(warrior2);
            // пропускаем время раунда 20мин
            dateHelper.skipTime();
            // если есть живые в первом и нет живых во втором
            if (squad1.hasAliveWarriors() & !squad2.hasAliveWarriors()) {
                System.out.println("\u001b[31;m Второй отряд полностью разбит!!!\n");
                System.out.println("\u001b[36;m Победу одержал отряд " + squad1.toString() + " ! УРА!!!\n");
                isBattleEnd = true;
                continue;
            }
            // если есть живые во втором и нет живых во первом
            if (!squad1.hasAliveWarriors() & squad2.hasAliveWarriors()) {
                System.out.println("\u001b[31;m Первый отряд полностью разбит!!!\n");
                System.out.println("\u001b[36;m Победу одержал отряд " + squad2.toString() + " ! УРА!!!\n");
                isBattleEnd = true;
                continue;
            }
            // выбор бойцов для второго раунда. Пока не придумал, как обойтись без такого большого дублирования кода
            warrior1 = squad1.getRandomWarrior();
            warrior2 = squad2.getRandomWarrior();
            StringBuilder strBattleSecondRound = new StringBuilder("\u001b[30;m     На бой вызываются: \n")
                    .append(warrior1.toString() + "и " + warrior2.toString() + "\n")
                    .append("\u001b[30;mАтакует боец " + warrior2.getNameOnly() + "\n")
                    .append("\u001b[30;mБоец " + warrior1.getNameOnly() + "\u001b[30;m  принимает удар!");
            System.out.println(strBattleSecondRound);
            warrior1.takeDamage(warrior2.attack());
            System.out.println(warrior1.getHealthStatus());
            squad1.needHimDeleteFromSquad(warrior1);
            dateHelper.skipTime();
            if (squad1.hasAliveWarriors() & !squad2.hasAliveWarriors()) {
                System.out.println("\u001b[31;m Второй отряд полностью разбит!!!\n");
                System.out.println("\u001b[36;m Победу одержал отряд " + squad1.toString() + " ! УРА!!!\n");
                isBattleEnd = true;
                continue;
            }
            if (!squad1.hasAliveWarriors() & squad2.hasAliveWarriors()) {
                System.out.println("\u001b[31;m Первый отряд полностью разбит!!!\n");
                System.out.println("\u001b[36;m Победу одержал отряд " + squad2.toString() + " ! УРА!!!\n");
                isBattleEnd = true;
            }
        }
        // вывести вермя сражения
        System.out.println(dateHelper.getFormattedDiff());
    }
}
