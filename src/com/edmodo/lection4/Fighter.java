package com.edmodo.lection4;

/**
 * Created by pc on 19.11.2016.
 */
public class Fighter implements Warrior, Cloneable {

    int damage = 50;
    int health = 150;
    String[] nameArray = {"Jimmy", "John", "James", "Jerry"};
    String name;
    String squadName;


    Fighter(int nameNumber, int surnameNumber) {
        this.name = nameArray[nameNumber] + "_" + surnameNumber;
    }

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
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void setSquadName(String name) {
        squadName = name;
    }

    @Override
    public String getHealthStatus() {
        String healthStatus = new String();
        if (health > 0) {
            healthStatus = "\u001b[30;mЕго здоровье равно " + health + "\n";
        } else healthStatus = "\u001b[31;mБоец пал смертью храбрых!\n";
        return healthStatus;
    }

    @Override
    public String getNameOnly() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder strFighter = new StringBuilder().append("\u001b[32;m" + name)
                .append("\u001b[30;m. Класс" + "\u001b[32;m Борец")
                .append("\u001b[30;m , Отряд " + "\u001b[30;m" + squadName + "\n");
        return strFighter.toString();
    }

    @Override
    public Fighter clone() throws CloneNotSupportedException {
        return (Fighter) super.clone();
    }
}
