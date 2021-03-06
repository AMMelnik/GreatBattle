package com.edmodo.lection4;

/**
 * Created by pc on 19.11.2016.
 */
class Fighter implements Warrior, Cloneable {

    private int damage = 50;
    private int health = 150;
    private String name;
    private String squadName;


    Fighter(String name) {
        this.name = name;
    }

    @Override
    public int attack() {
        return this.damage;
    }

    @Override
    public void takeDamage(int damage) {
        health -= damage;
    }

    @Override
    public boolean isAlive() {
        return (health > 0);
    }

    @Override
    public void setSquadName(String name) {
        squadName = name;
    }

    @Override
    public String getHealthStatus() {
        if (health > 0) {
            return "\u001b[30;mЕго здоровье равно " + health + "\n";
        } else return "\u001b[31;mБоец пал смертью храбрых!\n";
    }

    @Override
    public String getNameOnly() {
        return name;
    }

    @Override
    public String toString() {
        return "\u001b[34;m" + name + "\u001b[30;m. Класс" + "\u001b[34;m Борец" +
                "\u001b[30;m , Отряд " + "\u001b[30;m" + squadName + "\n";
    }

    @Override
    public Fighter clone() throws CloneNotSupportedException {
        return (Fighter) super.clone();
    }
}
