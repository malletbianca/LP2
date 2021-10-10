#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);

typedef struct Figure {
    int x, y;
    int stroke;
    Color strokeColor;
    void (* print) (struct Figure*);
} Figure;

/////
typedef struct {
    Figure super;
    Color fillColor;
    int width, height;
} Triangle;

void Triangle_print (Triangle* this) {
    Figure* sup = (Figure*) this;
    printf("Triangulo de base (%d) e altura (%d) na posicao (%d,%d).\nContorno de tamanho (%d) e cor (R%d, G%d, B%d).\nCor de preenchimento (R%d, G%d, B%d)\n\n",
           this->width, this->height, sup->x, sup->y, sup->stroke, sup->strokeColor.r, sup->strokeColor.g, sup->strokeColor.b, this->fillColor.r, this->fillColor.g, this->fillColor.b);
}

Triangle* triangle_new (int x, int y, int stroke, Color strokeColor, int width, int height, Color fillColor) {
    Triangle* this = malloc(sizeof(Triangle));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Triangle_print;
    sup->x = x;
    sup->y = y;
    sup->stroke = stroke;
    sup->strokeColor = strokeColor;
    this->width = width;
    this->height = height;
    this->fillColor = fillColor;
}

/////
typedef struct {
    Figure super;
    Color fillColor;
    int width, height;
} Ellipse;

void Ellipse_print (Ellipse* this) {
    Figure* sup = (Figure*) this;
    printf("Elipse de tamanho (%d,%d) na posicao (%d,%d).\nContorno de tamanho (%d) e cor (R%d, G%d, B%d).\nCor de preenchimento (R%d, G%d, B%d)\n\n",
           this->width, this->height, sup->x, sup->y, sup->stroke, sup->strokeColor.r, sup->strokeColor.g, sup->strokeColor.b, this->fillColor.r, this->fillColor.g, this->fillColor.b);
}

Ellipse* ellipse_new (int x, int y, int stroke, Color strokeColor, int width, int height, Color fillColor) {
    Ellipse* this = malloc(sizeof(Ellipse));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Ellipse_print;
    sup->x = x;
    sup->y = y;
    sup->stroke = stroke;
    sup->strokeColor = strokeColor;
    this->width = width;
    this->height = height;
    this->fillColor = fillColor;
}

/////
void main (void) {
    Color black = {0, 0, 0};
    Color white = {255, 255, 255};
    Color red = {255, 0, 0};
    Color green = {0, 255, 0};
    Color blue = {0, 0, 255};

    Figure* figs[4] = {
        (Figure*) triangle_new(10,10, 5, black, 50,50, white),
        (Figure*) ellipse_new(10,10, 5, black, 50,50, red),
        (Figure*) triangle_new(50,50, 5, black, 100,100, green),
        (Figure*) ellipse_new(50,50, 5, black, 100,100, blue)
    };

    for (int i = 0; i < 4; i++) {
        figs[i]->print(figs[i]);
    }

    for (int i = 0; i < 4; i++) {
        free(figs[i]);
    }
}
