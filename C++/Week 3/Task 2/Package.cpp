#include <stdexcept>
#include "Package.h"

// constructor initializes data members
Package::Package(const string& sName, const string& sAddress, const string& sCity, const string& sCountry, int sZIP, const string& rName, const string& rAddress, const string& rCity, const string& rCountry, int rZIP, double w, double cost) : senderName(sName), senderAddress(sAddress), senderCity(sCity), senderState(sCountry), senderZIP(sZIP), recipientName(rName), recipientAddress(rAddress), recipientCity(rCity), recipientState(rCountry), recipientZIP(rZIP) {
    setWeight(w);
    setCostPerOunce(cost);
}

Package::Package() {
}

void Package::setSenderName(const string& name) {
    senderName = name;
}

string Package::getSenderName() const {
    return senderName;
}

void Package::setSenderAddress(const string& address) {
    senderAddress = address;
} 

string Package::getSenderAddress() const {
    return senderAddress;
}

void Package::setSenderCity(const string& city) {
    senderCity = city;
}

string Package::getSenderCity() const {
    return senderCity;
}

void Package::setSenderState(const string& state) {
    senderState = state;
}

string Package::getSenderState() const {
    return senderState;
}

void Package::setSenderZIP(int zip) {
    senderZIP = zip;
}

int Package::getSenderZIP() const {
    return senderZIP;
}

void Package::setRecipientName(const string& name) {
    recipientName = name;
}

string Package::getRecipientName() const {
    return recipientName;
}

void Package::setRecipientAddress(const string& address) {
    recipientAddress = address;
}

string Package::getRecipientAddress() const {
    return recipientAddress;
}

void Package::setRecipientCity(const string& city) {
    recipientCity = city;
}

string Package::getRecipientCity() const {
    return recipientCity;
}

void Package::setRecipientState(const string& state) {
    recipientState = state;
}

string Package::getRecipientState() const {
    return recipientState;
}

void Package::setRecipientZIP(int zip) {
    recipientZIP = zip;
}

int Package::getRecipientZIP() const {
    return recipientZIP;
}

void Package::setWeight(double w) {
    if (w >= 0.0)
        weight = w;
    else
        throw invalid_argument("Weight must be >= 0.0");
}

double Package::getWeight() const {
    return weight;
}

void Package::setCostPerOunce(double cost) {
    if (cost >= 0.0)
        costPerKg = cost;
    else
        throw invalid_argument("Cost must be >= 0.0");
} 

double Package::getCostPerKg() const {
    return costPerKg;
}

double Package::calculateCost() const {
    return getWeight() * getCostPerKg();
}