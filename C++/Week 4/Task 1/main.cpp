#include <iostream>
#include "Box.h"

using namespace std;

bool checkSize(Box b, Product p) {
    if (p.length * p.width * p.depth < b.volume) {
        return true;
    } else {
        return false;
    }
}

int main() {
	double vol, l, w, d;

	Box box;
	Product product;

	cout << "Vol: ";
	cin >> vol;
	box.setVolume(vol);

	cout << "L W D: ";
	cin >> l;
	cin >> w;
	cin >> d;

	product.setDimensions(l, w, d);

	cout << "Fit? " << checkSize(box, product) << endl;
	return 0;
}