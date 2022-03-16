#pragma once

#include "PlayableCharacter.h"

using namespace std;

class Knight: public PlayableCharacter {
    public:
        Knight();
        Knight(string, int, int, int);
        void ability_one(vector<PlayableCharacter*>&, int);
};