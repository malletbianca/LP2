typedef struct Rect Rect;
Rect* rect_new (int x, int y, int width, int height);

void rect_print (Rect* this);
void rect_drag (Rect* this, int dx, int dy);
float rect_area (Rect* this);
