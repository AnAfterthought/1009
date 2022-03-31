#include "Hero.h"

Hero::Hero(string name, int health, int attack, double protection, int speed, bool playerCharacter) {
    this->name = name;
    this->health = health;
    this->maxHealth = health;
    this->attack = attack;
    this->protection = protection;
    this->speed = speed;
    this->turnMeter = 0;
    this->playerCharacter = playerCharacter;
    this->bleed = make_tuple(0, 0);
}

Hero::~Hero() {
}

string Hero::getName() {
    return this->name;
}

int Hero::getHealth() {
    return this->health;
}

void Hero::setHealth(int health) {
    this->health = health;
    if (this->health <= 0) {
        this->health = 0;
    }
    if (this->health > this->maxHealth) {
        this->health = this->maxHealth;
    }
}

int Hero::getMaxHealth() {
    return this->maxHealth;
}

int Hero::getAttack() {
    return this->attack;
}

void Hero::setAttack(int attack) {
    this->attack = attack;
}

double Hero::getProtection() {
    return this->protection;
}

void Hero::setProtection(double protection) {
    this->protection = protection;
}

int Hero::getSpeed() {
    return this->speed;
}

void Hero::setSpeed(int speed) {
    this->speed = speed;
}

int Hero::getTurnMeter() {
    return this->turnMeter;
}

void Hero::setTurnMeter() {
    if (this->health > 0) {
        this->turnMeter += this->speed;
    }
}

bool Hero::isPlayerCharacter() {
    return this->playerCharacter;
}

tuple<int, int> Hero::getBleed() {
    return this->bleed;
}

void Hero::setBleed(int turns, int damage) {
    get<0>(this->bleed) = turns;
    get<1>(this->bleed) = damage;
}

void Hero::performChecks() {
    if (get<0>(this->bleed) > 0) {
        this->health -= get<1>(this->bleed);
        get<0>(this->bleed) -= 1;
    }
}

void Hero::makeDecision(vector<Hero*>& party) {
    performChecks();
    int choice;
    if (this->playerCharacter) {
        cout << "1. Attack" << endl;
        cout << "2. Ability" << endl;
        cin >> choice;
    } else {
        choice = rand() % 2;
    }
    if (choice == 0 || choice == 1) {
        this->strike(party);
    } /*else if (choice == 2) {
        this->ability(party);
    }*/
    this->turnMeter -= 20;
}

void Hero::strike(vector<Hero*>& party) {

}

/*void Hero::ability(vector<Hero*>& party) {

}*/