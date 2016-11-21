package com.edmodo.lection4;

/**
 * Created by pc on 19.11.2016.
 */
public class Scout implements Warrior, Cloneable {

    int damage = 80;
    int health = 60;
    String name = "Patrick";
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
        StringBuilder strScout = new StringBuilder().append("\u001b[34;m" + name)
                .append("\u001b[30;m. Класс" + "\u001b[34;m Разведчик")
                .append("\u001b[30;m , Отряд " + "\u001b[30;m" + squadName + "\n");
                return strScout.toString();
    }

    @Override
    public Scout clone() throws CloneNotSupportedException {
        return (Scout)super.clone();
    }
}
