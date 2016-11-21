package com.edmodo.lection4;

/**
 * Created by pc on 19.11.2016.
 */
public class Bomber implements Warrior, Cloneable {

    int damage = 100;
    int health = 50;
    String name = "Bob";
    String squadName;

    @Override
    public int attack() {
        return this.damage;
    }

    @Override
    public void takeDamage(int damage) {
        this.health -= damage;
    }

    @Override
    public boolean isAlive() {
        if (health > 0) {
            System.out.println(toString() + "\u001b[30;m  Остаток здоровья: " + health + "\n");
            return true;
        }
        else {
            System.out.println(toString() + "\u001b[31;m . Погиб!\n");
            return false;
        }
    }

    @Override
    public void setSquadName(String name) {
        squadName = name;
    }

    @Override
    public String toString() {
        StringBuilder strBomber = new StringBuilder().append("\u001b[31;m" + name)
                .append("\u001b[30;m. Класс" + "\u001b[31;m Подрывник")
                .append("\u001b[30;m , Отряд " + "\u001b[30;m" + squadName + "\n");
                return strBomber.toString();
    }

    @Override
    public Bomber clone() throws CloneNotSupportedException {
        return (Bomber) super.clone();
    }
}
