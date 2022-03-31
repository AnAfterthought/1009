#include <cstddef>
#include "PartyMember.h"

PartyMember::PartyMember(Hero* hero, Equipment* equipmentOne, Equipment* equipmentTwo) {
    this->hero = hero;
    this->equipmentOne = equipmentOne;
    this->equipmentTwo = equipmentTwo;
}

Hero* PartyMember::getHero() {
    return this->hero;
}

void PartyMember::setEquipment(Equipment* equipment, int position) {
    if (position = 1) {
        this->equipmentOne = equipment;
    } else {
        this->equipmentTwo = equipment;
    }
}

void PartyMember::applyEquipment() {
    if (this->equipmentOne != NULL) {
        equipmentOne->equip(this->hero);
    }
    if (this->equipmentTwo != NULL) {
        equipmentTwo->equip(this->hero);
    }
}

/*#include "Party.h"

void Party::insert(Hero * hero) {
    this->party.push_back(hero);
}

void Party::insert(Equipment* equipment) {
    this->equipped.push_back(equipment);
}

void Party::equip() {
    for (Hero* h : this->party) {
        equipped[0]->modifyHero(h);
    }
}*/