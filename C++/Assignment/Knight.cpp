#include "Knight.h"

Knight::Knight() {
}

Knight::Knight(string name, int maxHealth, int damage, int speed) : PlayableCharacter(name, maxHealth, damage, speed){
}

void Knight::ability_one(vector<PlayableCharacter*> &characters, int index) {
    characters[index]->setHealth(characters[index]->getHealth() + 20);
}