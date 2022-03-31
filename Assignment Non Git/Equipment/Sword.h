#ifndef SWORD_H
#define SWORD_H

#include "Equipment.h"

class Sword:public Equipment {
    public:
        void equip(Hero*);
        void unequip(Hero*);
};

#endif