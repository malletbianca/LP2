#include <stdio.h>
#include <stdlib.h>
#include <math.h>

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef void    (* Figure_Print) (struct Figure*);
typedef float   (* Figure_Area)  (struct Figure*);
typedef int     (* Figure_Drag)  (struct Figure*);

typedef struct {
    void    (* print) (struct Figure*);
    float   (* area)  (struct Figure*);
    int     (* drag)  (struct Figure*);
} Figure_vtable;

typedef struct Figure {
    int x, y;
    int stroke;
    Color strokeColor;
    Figure_vtable* vtable;
} Figure;

/////
typedef struct {
    Figure super;
    Color fillColor;
    int width, height;
} Triangle;

void Triangle_print (Triangle* this) {
    Figure* sup = (Figure*) this;
    printf("Triangulo de base (%d) e altura (%d) na posicao (%d,%d).\n", this->width, this->height, sup->x, sup->y);
    printf("Contorno de tamanho (%d) e cor (R%d, G%d, B%d).\nCor de preenchimento (R%d, G%d, B%d)\n",
           sup->stroke, sup->strokeColor.r, sup->strokeColor.g, sup->strokeColor.b, this->fillColor.r, this->fillColor.g, this->fillColor.b);
    printf("Triangulo de area (%.1f)\n", sup->vtable->area(sup)); sup->vtable->drag(sup);
}

float Triangle_area (Triangle* this) {
    Figure* sup = (Figure*) this;
    return (this->width * this->height)/2;
}

void Triangle_drag (Triangle* this, int dx, int dy) {
    Figure* sup = (Figure*) this;
    dx = dy = 10;
    sup->x += dx;
    sup->y += dy;
    printf("Nova posicao (%d, %d)\n\n", sup->x, sup->y);
}

Figure_vtable triangle_vtable = {
    (Figure_Print) Triangle_print,
    (Figure_Area)  Triangle_area,
    (Figure_Drag)  Triangle_drag,
};

Triangle* triangle_new (int x, int y, int stroke, Color strokeColor, int width, int height, Color fillColor) {
    Triangle* this = malloc(sizeof(Triangle));
    Figure* sup = (Figure*) this;
    sup->vtable = &triangle_vtable;
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
    printf("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n", this->width, this->height, sup->x, sup->y);
    printf("Contorno de tamanho (%d) e cor (R%d, G%d, B%d).\nCor de preenchimento (R%d, G%d, B%d)\n",
           sup->stroke, sup->strokeColor.r, sup->strokeColor.g, sup->strokeColor.b, this->fillColor.r, this->fillColor.g, this->fillColor.b);
    printf("Elipse de area (%.1f)\n", sup->vtable->area(sup)); sup->vtable->drag(sup);
}

float Ellipse_area (Ellipse* this) {
    Figure* sup = (Figure*) this;
    return this->width * this->height * 3.14;
}

void Ellipse_drag (Ellipse* this, int dx, int dy) {
    Figure* sup = (Figure*) this;
    dx = dy = 10;
    sup->x += dx;
    sup->y += dy;
    printf("Nova posicao (%d, %d)\n\n", sup->x, sup->y);
}

Figure_vtable ellipse_vtable = {
    (Figure_Print) Ellipse_print,
    (Figure_Area)  Ellipse_area,
    (Figure_Drag)  Ellipse_drag,
};

Ellipse* ellipse_new (int x, int y, int stroke, Color strokeColor, int width, int height, Color fillColor) {
    Ellipse* this = malloc(sizeof(Ellipse));
    Figure* sup = (Figure*) this;
    sup->vtable = &ellipse_vtable;
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
        figs[i]->vtable->print(figs[i]);
    }

    for (int i = 0; i < 4; i++) {
        free(figs[i]);
    }
}
