#include <iostream>
#include <algorithm>
#include "PlayableCharacter.h"
#include "Knight.h"

using namespace std;

bool compareInitiative(PlayableCharacter& left, PlayableCharacter& right) {
    return left.getInitiative() > right.getInitiative();
}

int main() {
    PlayableCharacter *character;
    vector<PlayableCharacter*> player;
    vector<PlayableCharacter> enemy;
    vector<PlayableCharacter> turn_order;
    int target_no;
    srand((unsigned int)time(NULL));

    Knight k = Knight("Hello 4", 123, 45, 6);
    player.push_back(&k);
    k = Knight("Hello 4", 133, 45, 6);
    player.push_back(&k);

    character = player[0];
    character->ability_one(player, 1);
    cout << player[1]->getHealth() << endl;

    /*player.push_back(PlayableCharacter("Hello 1", 100, 10, 5));
    player.push_back(PlayableCharacter("Hello 2", 100, 10, 3));
    player.push_back(PlayableCharacter("Hello 3", 100, 10, 3));
    enemy.push_back(PlayableCharacter("Enemy 1", 50, 5, 3));
    enemy.push_back(PlayableCharacter("Enemy 2", 50, 5, 3));
    enemy.push_back(PlayableCharacter("Enemy 3", 50, 5, 3));

    for (PlayableCharacter pc : player) {
        pc.setInitiative();
        turn_order.push_back(pc);
    }

    for (PlayableCharacter pc : enemy) {
        pc.setInitiative();
        turn_order.push_back(pc);
    }

    sort(turn_order.begin(), turn_order.end(), compareInitiative);

    while (!player.empty() && !enemy.empty()) {
        target_no = rand() % enemy.size();
        player[0].attack(enemy[target_no]);
        if (enemy[target_no].getHealth() == 0)
            enemy.erase(enemy.begin() + target_no);
    }*/
}