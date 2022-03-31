#ifndef WOLF_H
#define WOLF_H

#include "Hero.h"

class Wolf:public Hero {
    public:
        Wolf(string, int, int, double, int, bool);
        void strike(vector<Hero*>&);
        void ability(vector<Hero*>&);
};

#endif