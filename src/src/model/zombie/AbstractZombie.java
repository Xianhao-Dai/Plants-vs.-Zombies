package src.model.zombie;

public abstract class AbstractZombie {
    /**
     * max health point of a certain zombie
     */
    protected float maxHP;
    /**
     * current health point of a certain zombie
     */
    protected float currentHP;
    /**
     * the speed of a certain zombie
     */
    protected float speed;
    /**
     * the damage once caused by a certain zombie
     */
    protected float damage;
    /**
     * the column coordinate of a certain zombie
     */
    protected float xCoordinate;
    /**
     * the belonging row of a certain zombie
     */
    protected float yLane;
    /**
     * the buff types towards a certain zombie(could be with multiple types simultaneously)
     */
    protected ZombieBuffType zombieBuffType;
    enum ZombieBuffType {
        NONE(0),
        HIGHSPEED(1 << 0),
        HIGHDAMAGE(1 << 1);

        private int type;
        ZombieBuffType(int type) {
            this.type = type;
        }
    }
    /**
     * the debuff types towards a certain zombie(could be with multiple types simultaneously)
     */
    protected ZombieDebuffType zombieDebuffType;
    enum ZombieDebuffType {
        NONE(0),
        LOWSPEED(1 << 0),
        LOWDAMAGE(1 << 1);

        private int type;

        ZombieDebuffType(int type) {
            this.type = type;
        }
    }
    /**
     * called whenever a certain zombie's health point declined to 0
     */
    protected abstract void killed();
}
