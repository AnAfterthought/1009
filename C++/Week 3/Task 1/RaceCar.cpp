#include "RaceCar.h"

void RaceCar::setSpeed(int speed) {
    this->speed = speed;
    if (speed > 199)
        this->speed = 199;
    if (!(this->isIgnitionOn))
        this->speed = 0;
}