#include <iostream>
#include <string>

using namespace std;

class SailingBoat {
    private:
        string boatName;
        double distance;
    public:
        SailingBoat(string, double);
        string getName();
        double operator/(SailingBoat);
        friend ostream& operator<<(ostream&, const SailingBoat&);
};