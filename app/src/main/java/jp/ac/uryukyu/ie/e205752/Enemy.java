package jp.ac.uryukyu.ie.e205752;
/**
 * 敵クラス。 
 * String name; //敵の名前 
 * int hitPoint; //敵のHP 
 * int attack; //敵の攻撃力 boolean
 * dead; //敵の生死状態。true=死亡。 
 * Created by tnal on 2016/11/13.
 */
public class Enemy extends LivingThing {

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * 
     * @param name      モンスター名
     * @param maximumHP モンスターのHP
     * @param attack    モンスターの攻撃力
     */
    public Enemy(String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
    }

    /**
     * enemyが生きているかどうかの真偽判定を行う
     * 真であれば、Heroへ攻撃するメソッド。 attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
     * 偽であればattackメソットは動かない
     * @param hero 攻撃対象
     */

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。 
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    @Override
    public void wounded(int damage) {
        setHitPoint(getHitPoint() - damage);
        if (getHitPoint() < 0) {
            setDead(true);
            System.out.printf("モンスター%sは倒れた。\n", getName());
        }
    }

    /**
     * アクセサを使ってprivateしたコードを他のクラスで参照できるようにする。
     * 
     * @return getName
     */
}