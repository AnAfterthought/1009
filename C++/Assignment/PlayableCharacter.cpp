#include "PlayableCharacter.h"

PlayableCharacter::PlayableCharacter() {
}

PlayableCharacter::PlayableCharacter(string name, int maxHealth, int damage, int speed) {
    this->name = name;
    this->maxHealth = maxHealth;
    this->health = maxHealth;
    this->damage = damage;
    this->speed = speed;
}

string PlayableCharacter::getName() {
    return this->name;
}

int PlayableCharacter::getMaxHealth() {
    return this->maxHealth;
}

int PlayableCharacter::getHealth() {
    return this->health;
}

void PlayableCharacter::setHealth(int health) {
    this->health = health;
}

int PlayableCharacter::getDamage() {
    return this->damage;
}

void PlayableCharacter::setDamage(int damage) {
    this->damage = damage;
}

int PlayableCharacter::getSpeed() {
    return this->speed;
}

void PlayableCharacter::setSpeed(int speed) {
    this->speed = speed;
}

int PlayableCharacter::getInitiative() {
    return this->initiative;
}

void PlayableCharacter::setInitiative() {
    this->initiative = rand() % 8 + this->speed;
}

void PlayableCharacter::attack(PlayableCharacter& pc) {
    pc.setHealth(pc.getHealth() - this->damage);
}

void PlayableCharacter::ability_one(vector<PlayableCharacter*> &characters, int index) {
}