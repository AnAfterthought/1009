#pragma once

#include "Car.h"

using namespace std;

class Convertible: virtual public Car {
    private:
        bool isTopUp;
    public:
        void putTopUp();
        void putTopDown();
        void showCar();
};