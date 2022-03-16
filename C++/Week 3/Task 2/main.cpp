#include <iostream>
#include "Package.h"
#include "TwoDayPackage.h"
#include "OvernightPackage.h"

using namespace std;

int main() {
    Package pk1("Bruce Lee", "1 Fighting Rd", "Hong Kong", "Chine", 12345, "Alice Wong", "Jurong Ave 1", "Jurong", "Singapore", 23456, 8.5, 0.5);

    TwoDayPackage pk2("Donald Trump", "1600 Pennsylvania Ave", "Washington", "USA", 34567, "Barack Obama", "21 Democracy St", "Washington", "USA", 45678, 10.5, 0.65, 2.0);

    OvernightPackage pk3("Lee Hsien Loong", "1 Parliament Pl", "CBD", "Singapore", 56789, "Bob Tan", "Yishun Ave 1", "Yishun", "Singapore", 67891, 12.25, 0.7, 0.25);

    cout << "Package 1:" << endl;
    cout << "Sender: " << pk1.getSenderName() << endl;
    cout << pk1.getSenderAddress() << " ";
    cout << pk1.getSenderCity() << " ";
    cout << pk1.getSenderState() << endl;
    cout << "Recipient: " << pk1.getRecipientName() << endl;
    cout << pk1.getRecipientAddress() << " ";
    cout << pk1.getRecipientCity() << " ";
    cout << pk1.getRecipientState() << endl;
    cout << pk1.calculateCost() << endl << endl;

    cout << "Package 2:" << endl;
    cout << "Sender: " << pk2.getSenderName() << endl;
    cout << pk2.getSenderAddress() << " ";
    cout << pk2.getSenderCity() << " ";
    cout << pk2.getSenderState() << endl;
    cout << "Recipient: " << pk2.getRecipientName() << endl;
    cout << pk2.getRecipientAddress() << " ";
    cout << pk2.getRecipientCity() << " ";
    cout << pk2.getRecipientState() << endl;
    cout << pk2.calculateCost() << endl << endl;

    cout << "Package 3:" << endl;
    cout << "Sender: " << pk3.getSenderName() << endl;
    cout << pk3.getSenderAddress() << " ";
    cout << pk3.getSenderCity() << " ";
    cout << pk3.getSenderState() << endl;
    cout << "Recipient: " << pk3.getRecipientName() << endl;
    cout << pk3.getRecipientAddress() << " ";
    cout << pk3.getRecipientCity() << " ";
    cout << pk3.getRecipientState() << endl;
    cout << pk3.calculateCost() << endl << endl;

    return 0;
}