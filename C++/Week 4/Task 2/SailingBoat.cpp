#include "SailingBoat.h"

SailingBoat::SailingBoat(string boatName, double distance) {
    this->boatName = boatName;
    this->distance = distance;
}

string SailingBoat::getName() {
    return this->boatName;
}

double SailingBoat::operator/(SailingBoat boat) {
    return this->distance / boat.distance;
}