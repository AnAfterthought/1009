#ifndef HERO_H
#define HERO_H

#include <iostream>
#include <vector>
#include <string>
#include <tuple>

using namespace std;

class Hero {
    private:
        string name;
        int health;
        int maxHealth;
        int attack;
        double protection;
        int speed;
        int turnMeter;
        bool playerCharacter;
        tuple<int, int> bleed;
    public:
        Hero(string, int, int, double, int, bool);
        virtual ~Hero();
        string getName();
        int getHealth();
        void setHealth(int);
        int getMaxHealth();
        int getAttack();
        void setAttack(int);
        double getProtection();
        void setProtection(double);
        int getSpeed();
        void setSpeed(int);
        int getTurnMeter();
        void setTurnMeter();
        bool isPlayerCharacter();
        tuple<int, int> getBleed();
        void performChecks();
        void setBleed(int, int);
        void makeDecision(vector<Hero*>&);
        virtual void strike(vector<Hero*>&);
        //virtual void ability(vector<Hero*>&);
};

#endif