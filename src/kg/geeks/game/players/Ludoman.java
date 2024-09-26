package kg.geeks.game.players;

import java.util.Random;
    public class Ludoman extends Hero {
        private Random random;

        public Ludoman(int health, int damage, String name) {
            super(health, damage, name, SuperAbility.Roll);
            random = new Random();
        }

        @Override
        public void applySuperPower(Boss boss, Hero[] heroes) {
            int w1 = random.nextInt(6) + 1;
            int w2 = random.nextInt(6) + 1;

            System.out.println(this.getName() + " бросает: " + w1 +" и " + w2) ;

            if (w1 == w2) {

                int damageToBoss =w1 *w2;
                boss.setHealth(boss.getHealth() - damageToBoss);
                System.out.println("Совпадение... Урон Боссу: " + damageToBoss);
            } else {

                int randomTeammateIndex;
                do {
                    randomTeammateIndex = random.nextInt(heroes.length);
                } while (heroes[randomTeammateIndex] == this || heroes[randomTeammateIndex].getHealth() <= 0);

                int damageToTeammate = w1 + w2;
                heroes[randomTeammateIndex].setHealth(heroes[randomTeammateIndex].getHealth() - damageToTeammate);
                System.out.println("Не совпадение... Урон тиммейту (" + heroes[randomTeammateIndex].getName() + "): " + damageToTeammate);
            }
        }
    }

