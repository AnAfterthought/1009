#include "Car.h"

void Car::turnIgnitionOn() {
    this->isIgnitionOn = true;
}

void Car::turnIgnitionOff() {
    this->isIgnitionOn = false;
    this->speed = 0;
}

void Car::setSpeed(int speed) {
    this->speed = speed;
    if (speed > 65)
        this->speed = 65;
    if (!(this->isIgnitionOn))
        this->speed = 0;
}

void Car::showCar() {
    cout << "Ignition is ";
    if (this->isIgnitionOn)
        cout << "on";
    else
        cout << "off";
    cout << ". Speed is " << this->speed << "mph." << endl;
}