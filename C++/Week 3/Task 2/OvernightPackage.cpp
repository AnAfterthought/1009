#include <stdexcept>
#include "OvernightPackage.h"

OvernightPackage::OvernightPackage(const string& sName, const string& sAddress, const string& sCity, const string& sCountry, int sZIP, const string& rName, const string& rAddress, const string& rCity, const string& rCountry, int rZIP, double w, double cost, double fee) : Package(sName, sAddress, sCity, sCountry, sZIP, rName, rAddress, rCity, rCountry, rZIP, w, cost) {
    setOvernightFeePerKg(fee);
}

void OvernightPackage::setOvernightFeePerKg(double overnightFee) {
    if (overnightFee >= 0.0)
        overnightFeePerKg = overnightFee;
    else
        throw invalid_argument("Overnight fee must be >= 0.0");
}

double OvernightPackage::getOvernightFeePerKg() const {
    return overnightFeePerKg;
}

double OvernightPackage::calculateCost() const {
    return getWeight() * (getCostPerKg() + getOvernightFeePerKg());
}
