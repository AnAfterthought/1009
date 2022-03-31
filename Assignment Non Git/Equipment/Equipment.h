#ifndef EQUIPMENT_H
#define EQUIPMENT_H

#include "..\Character\Hero.h"

class Equipment{
    public:
        virtual void equip(Hero*);
        virtual void unequip(Hero*);
};

#endif