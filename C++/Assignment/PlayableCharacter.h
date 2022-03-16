#pragma once

#include <string>
#include <vector>

using namespace std;

class PlayableCharacter {
    private:
        string name;
        int maxHealth;
        int health;
        int damage;
        int defence;
        int speed;
        int initiative;
    public:
        PlayableCharacter();
        PlayableCharacter(string, int, int, int);
        string getName();
        int getMaxHealth();
        int getHealth();
        void setHealth(int);
        int getDamage();
        void setDamage(int);
        int getDefence();
        void setDefence(int);
        int getSpeed();
        void setSpeed(int speed);
        int getInitiative();
        void setInitiative();
        virtual void ability_one(vector<PlayableCharacter*>&, int);
        //virtual void ability_two(vector<PlayableCharacter>, int);
        //virtual void ability_three(vector<PlayableCharacter>, int);
        void attack(PlayableCharacter&);
};