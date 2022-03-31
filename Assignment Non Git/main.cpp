#include "PartyMember.h"
#include "Character\Knight.h"
#include "Character\Healer.h"
#include "Character\Wolf.h"
#include "Equipment\Sword.h"

using namespace std;

void generateEnemies(vector<Hero*>& party) {
    int noOfEnemies = rand() % 3 + 1;
    for (int i = 0; i < noOfEnemies; i++) {
        Hero* enemy = new Wolf("Wolf", 10, 5, 0.1, 6, false);
        party.push_back(enemy);
    }
}

bool checkDefeated(vector<Hero*> party) {
    for (Hero* h : party) {
        if (h->getHealth() > 0) {
            return true;
        }
    }
    return false;
}

void display(vector<Hero*> party, vector<Hero*> enemy) {
    cout << "Your party" << endl;
    for (int i = 0; i < party.size(); i++) {
        cout << i + 1 << ". " << party[i]->getName() << " " << party[i]->getHealth() << " " << party[i]->getTurnMeter() << endl;
    }
    cout << "Enemy party" << endl;
    for (int i = 0; i < enemy.size(); i++) {
        cout << i + 1 << ". " << enemy[i]->getName() << " " << enemy[i]->getHealth() << " " << enemy[i]->getTurnMeter() << endl;
    }
    cout << "==========================================" << endl;
}

void clearParty(vector<Hero*>& party) {
    while(!party.empty()) {
        delete party.back();
        party.pop_back();
    }
}

int main() {
    srand(time(NULL));

    // Battle loop
    vector<Hero*> party;
    vector<Hero*> enemy;
    bool battle = true;

    Hero* k = new Knight("Pro", 50, 10, 0.4, 5, true);
    party.push_back(k);
    Hero* d = new Healer("Noob", 21, 10, 0.4, 5, true);
    party.push_back(d);

    generateEnemies(enemy);

    while (battle) {
        for (Hero* h : party) {
            if (!battle) {
                break;
            }
            h->setTurnMeter();
            if (h->getTurnMeter() >= 20 && h->getHealth() > 0) {
                display(party, enemy);
                cout << h->getName() << "'s turn" << endl;
                h->makeDecision(enemy);
                battle = checkDefeated(party) && checkDefeated(enemy);
            }
        }
        for (Hero* h : enemy) {
            if (!battle) {
                break;
            }
            h->setTurnMeter();
            if (h->getTurnMeter() >= 20 && h->getHealth() > 0) {
                display(party, enemy);
                h->makeDecision(party);
                battle = checkDefeated(party) && checkDefeated(enemy);
                cout << battle << endl;
            }
        }
    }

    clearParty(enemy);

    return 0;
}
