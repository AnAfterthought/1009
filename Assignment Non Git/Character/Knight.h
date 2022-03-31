#ifndef KNIGHT_H
#define KNIGHT_H

#include "Hero.h"

class Knight:public Hero {
    public:
        Knight(string, int, int, double, int, bool);
        void strike(vector<Hero*>&);
        void ability(vector<Hero*>&);
};

#endif