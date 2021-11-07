#include <stdio.h>
#include <stdlib.h>
#include "rect.h"

void main (void) {
    Rect* r1 = rect_new(10,10, 100,100);
    rect_drag(r1, 50,50);
    rect_print(r1);

    Rect* r2 = rect_new(20,20, 50,50);
    rect_drag(r2, 50,50);
    rect_print(r2);

    free(r1);
    free(r2);
}
