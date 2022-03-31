#include "Wolf.h"

Wolf::Wolf(string name, int health, int attack, double protection, int speed, bool playerCharacter):Hero(name, health, attack, protection, speed, playerCharacter) {

}

void Wolf::strike(vector<Hero*>& party) {
    int target = -1;
    int targetHealth;
    int damage;
    while (target == -1) {
        target = rand() % party.size();
        targetHealth = party[target]->getHealth();
        if (targetHealth == 0) {
            target = -1;
        }
    }
    damage = this->getAttack() * (1 - party[target]->getProtection());
    targetHealth -= damage;
    party[target]->setHealth(targetHealth);
    party[target]->setBleed(1, 1);
    cout << this->getName() << " dealt " << damage << " to " << party[target]->getName() << endl;
}

void Wolf::ability(vector<Hero*>& party) {
    this->setProtection(this->getProtection() + 0.1);
}