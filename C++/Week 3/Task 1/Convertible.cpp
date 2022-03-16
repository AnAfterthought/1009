#include "Convertible.h"

void Convertible::putTopUp() {
    this->isTopUp = true;
}

void Convertible::putTopDown() {
    this->isTopUp = false;
}

void Convertible::showCar() {
    Car::showCar();
    cout << "Top is ";
    if (this->isTopUp)
        cout << "up";
    else
        cout << "down";
    cout << "." << endl;
}