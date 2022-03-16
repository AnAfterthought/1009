#include "Car.h"
#include "Convertible.h"
#include "RaceCar.h"
#include "ConvertibleRaceCar.h"

int main() {
    Car myCar;
    myCar.turnIgnitionOn();
    myCar.setSpeed(35);
    myCar.showCar();

    myCar.setSpeed(80);
    myCar.showCar();

    myCar.turnIgnitionOff();
    myCar.showCar();

    Convertible yourCar;
    yourCar.turnIgnitionOn();
    yourCar.setSpeed(35);
    yourCar.putTopDown();
    yourCar.showCar();

    yourCar.setSpeed(80);
    yourCar.showCar();

    yourCar.putTopUp();
    yourCar.turnIgnitionOff();
    yourCar.showCar();

    Car aCar;
    RaceCar aRaceCar;

    aCar.turnIgnitionOn();
    aCar.setSpeed(100);
    cout << "A car at 100 mph: ";
    aCar.showCar();
    
    aRaceCar.turnIgnitionOn();
    aRaceCar.setSpeed(100);
    cout << "A race car at 100 mph: ";
    aRaceCar.showCar();

    ConvertibleRaceCar aConvertibleRaceCar;
    aConvertibleRaceCar.turnIgnitionOn();
    aConvertibleRaceCar.setSpeed(35);
    aConvertibleRaceCar.showCar();

    aConvertibleRaceCar.setSpeed(80);
    aConvertibleRaceCar.showCar();

    aConvertibleRaceCar.turnIgnitionOff();
    aConvertibleRaceCar.showCar();

    return 0;
}