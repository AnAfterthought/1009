#include "Product.h"

class Box {
    private:
        double volume;
    public:
        void setVolume(double);
        friend bool checkSize(Box,Product);
};