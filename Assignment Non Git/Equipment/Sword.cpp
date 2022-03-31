#include "Sword.h"

void Sword::equip(Hero* hero) {
    hero->setAttack(hero->getAttack() + 2);
}

void Sword::unequip(Hero* hero) {
    hero->setAttack(hero->getAttack() - 2);
}