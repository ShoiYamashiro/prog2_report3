package jp.ac.uryukyu.ie.e205752;

/**
 * 継承クラス。 
 * String name; 
 * //敵の名前 int hitPoint; 
 * //敵のHP int attack; 
 * //敵の攻撃力 boolean
 * dead; //敵の生死状態。true=死亡。 
 */

public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    public LivingThing(String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    public boolean isDead(){
        return dead;
    }

    public String getName(){
        return name;
    }

    /**
     * enemyが生きているかどうかの真偽判定を行う 真であれば、Heroへ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。 偽であればattackメソットは動かない
     * 
     * @param hero 攻撃対象
     */

    public void attack(LivingThing opponent) {
        if (dead){
            return;
        }
        int damage = (int) (Math.random() * attack);
        System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
        opponent.wounded(damage);
    }

    public void wounded(int damage) {
        hitPoint -= damage;
        if (hitPoint < 0) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }

    /**
     * アクセサを使ってprivateしたコードを他のクラスで参照できるようにする。
     * 
     * @return getName
     */
    
    public int getHitPoint() {
        return this.hitPoint;
    }

    public int getAttack() {
        return this.attack;
    }

    public void setName(String _name) {
        this.name = _name;
    }

    public void setHitPoint(int _hitPoint) {
        this.hitPoint = _hitPoint;
    }

    public void setAttack(int _attack) {
        this.attack = _attack;
    }

    public void setDead(boolean _dead) {
        this.dead = _dead;
    }
}