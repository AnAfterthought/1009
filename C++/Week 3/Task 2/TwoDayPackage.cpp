#include <stdexcept>
#include "TwoDayPackage.h"

TwoDayPackage::TwoDayPackage( const string &sName, const string &sAddress, const string &sCity, const string &sCountry, int sZIP, const string &rName, const string &rAddress, const string &rCity, const string &rCountry, int rZIP, double w, double cost, double fee ) : Package( sName, sAddress, sCity, sCountry, sZIP, rName, rAddress, rCity, rCountry, rZIP, w, cost ) {
   setFlatFee(fee);
}

/*
TwoDayPackage::TwoDayPackage(const string& sName, const string& sAddress, const string& sCity, const string& sCountry, int sZIP, const string& rName, const string& rAddress, const string& rCity, const string& rCountry, int rZIP, double w, double cost, double fee) {
    setFlatFee(fee);
}
*/

void TwoDayPackage::setFlatFee(double fee) {
    if (fee >= 0.0)
        flatFee = fee;
    else
        throw invalid_argument("Flat fee must be >= 0.0");
}

double TwoDayPackage::getFlatFee() const {
    return flatFee;
}

double TwoDayPackage::calculateCost() const {
    return Package::calculateCost() + getFlatFee();
}
