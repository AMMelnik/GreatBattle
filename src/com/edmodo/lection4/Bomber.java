package com.edmodo.lection4;

/**
 * Created by pc on 19.11.2016.
 */
public class Bomber implements Warrior, Cloneable {

    private int damage = 100;
    private int health = 50;
    private String[] nameArray = {"Bob", "Bill", "Bryan", "Benjamin"}; //почему нельзя задать произвольное имя?
    private String name;
    private String squadName;

    Bomber(int nameNumber, int surnameNumber) {
        this.name = nameArray[nameNumber] + "_" + surnameNumber; //необязательно в этих случаях писать this
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
        if (health > 0) { //везде, где ожидается условие или возвращается результат условия, можно сразу проверять/возвращать. в данном случае можно сразу писать return health > 0;
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
        String healthStatus = new String(); //лишняя переменная и лишний конструктор, можно сразу вернуть нужное значение
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
        StringBuilder strBomber = new StringBuilder().append("\u001b[31;m" + name) //никакого выигрыша в производительности от использования билдера в данном случае не будет, скорее наоборот.
                // строки точно не следует складывать в цикле, при обычной инициализации можно.
                .append("\u001b[30;m. Класс" + "\u001b[31;m Подрывник")
                .append("\u001b[30;m , Отряд " + "\u001b[30;m" + squadName + "\n");
        return strBomber.toString();
    }

    @Override
    public Bomber clone() throws CloneNotSupportedException {
        return (Bomber) super.clone();
    }
}
