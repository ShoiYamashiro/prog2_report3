package jp.ac.uryukyu.ie.e205752;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WarriorTest {
    /**
     * 倒れたはずの敵は攻撃できないことを検証。 検証手順 (1) ヒーローと敵を準備。ヒーローの攻撃力は敵を一撃で倒せるほど強い状態とする。 (2)
     * ヒーローが殴り、敵も殴る。敵は一撃で倒されていることを期待。 (3) 敵が死んだ状態ならば攻撃できないはず。
     * つまり攻撃実行してもヒーローのHPは減っていないことを期待。これを検証する。
     */
    @Test
    void attackTest() {
        int defaultWarriorHp = 100;
        int defaultAttack = 10;
        int assumeAttack = 15;
        int beforeAttackEnemyHP = 100; 
        Warrior demoWarrior = new Warrior("デモ勇者", defaultWarriorHp, defaultAttack);
        Enemy slime = new Enemy("スライムもどき", beforeAttackEnemyHP, 100);
        for(int i=0; i < 3; i++){
            beforeAttackEnemyHP = slime.getHitPoint();
            demoWarrior.attackWithWeponSkill(slime);
            assertEquals(assumeAttack, beforeAttackEnemyHP - slime.getHitPoint());
        }
    }
    
}