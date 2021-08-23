#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
	int x, y;
	int h, w;
	int vert;
	float raioExt;
	float raioInt;
	int r1, g1, b1; //cor interna
	int r2, g2, b2; //cor do contorno
	int stroke; //espessura do contorno

} Estrela;

void print (Estrela* s) {
	printf("Tamanho: (%d,%d)\nPosicao: (%d,%d)\nNumero de vertices: (%d)\nRaio externo: (%.1f)\nRaio interno: (%.1f)\nCor de fundo: (R%d, G%d, B%d)\nCor do contorno: (R%d, G%d, B%d)\nEspessura do contorno: (%d)\n", s->w,s->h, s->x,s->y, s->vert, s->raioExt, s->raioInt, s->r1,s->g1,s->b1, s->r2,s->g2,s->b2, s->stroke);
}

int main() {
	Estrela s1 = {0,0, 10,10, 5, 5.0, 4.0, 24,24,24, 30,30,30, 2};
	print(&s1);

	return 0;
}
