class Box;

class Product {
    Box* box;
    private:
        double length;
        double width;
        double depth;
    public:
        void setDimensions(double,double,double);
        friend bool checkSize(Box,Product);
};