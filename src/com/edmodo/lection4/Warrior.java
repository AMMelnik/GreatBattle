package com.edmodo.lection4;

/**
 * Created by pc on 19.11.2016.
 */
interface Warrior {

    int attack();

    void takeDamage(int damage);

    boolean isAlive();

    void setSquadName(String name);

    String getHealthStatus();

    String getNameOnly();
}
