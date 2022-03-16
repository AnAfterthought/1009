#pragma once

#include "Car.h"

class RaceCar: virtual public Car {
    public:
        void setSpeed(int);
};