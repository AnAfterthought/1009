#include "Knight.h"

Knight::Knight(string name, int health, int attack, double protection, int speed, bool playerCharacter):Hero(name, health, attack, protection, speed, playerCharacter) {

}

void Knight::strike(vector<Hero*>& party) {
    int target = -1;
    int targetHealth;
    int damage;
    while (target == -1) {
        cout << "Choose target" << endl;
        cin >> target;
        targetHealth = party[target - 1]->getHealth();
        if (targetHealth == 0) {
            cout << "Target is defeated" << endl;
            target = -1;
        } else {
            damage = this->getAttack() * (1 - party[target - 1]->getProtection());
            targetHealth -= damage;
            party[target - 1]->setHealth(targetHealth);
        }
    }
    cout << this->getName() << " dealt "  << damage << " to " << party[target - 1]->getName() << endl;
}

void Knight::ability(vector<Hero*>& party) {
    this->setProtection(this->getProtection() + 0.1);
}