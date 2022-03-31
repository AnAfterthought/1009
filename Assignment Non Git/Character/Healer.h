#ifndef HEALER_H
#define HEALER_H

#include "Hero.h"

class Healer:public Hero {
    public:
        Healer(string, int, int, double, int, bool);
        void strike(vector<Hero*>&);
        void ability(vector<Hero*>&);
};

#endif