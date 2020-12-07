package jp.ac.uryukyu.ie.e205752;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WarriorTest {
    /**
     * デモ勇者のウェポンスキルが発動し三回とも150%の固定ダメージがスライムに入っているか検証 
     * defaultWarriorHpはデモ勇者の体力に仮設定
     * defaultAttackはデモ勇者の攻撃力に仮設定 
     * assumeAttackはウェポンスキルが発動した際の攻撃力の判定に使用
     * beforeAttackEnemyHPはスライムもどきの体力に仮設定
     * for文でデモ勇者のウェポンスキル攻撃を三回行い150%の固定ダメージが入っているか調べる。
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