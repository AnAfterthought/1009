#ifndef PARTYMEMBER_H
#define PARTYMEMBER_H

#include "Character\Hero.h"
#include "Equipment\Equipment.h"

class PartyMember {
    private:
        Hero* hero;
        Equipment* equipmentOne;
        Equipment* equipmentTwo;
    public:
        PartyMember(Hero*, Equipment*, Equipment*);
        Hero* getHero();
        void setEquipment(Equipment*, int);
        void applyEquipment();
};

/*class Party {
    private:
        std::vector<Hero*> party;
        std::vector<Equipment*> equipped;
    public:
        void insert(Hero*);
        void insert(Equipment*);
        void equip();
};*/

#endif