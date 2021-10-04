# LP2: Projeto 1/2
Primeira metade do projeto de editor gráfico vetorial.
O editor cria figuras entre as 5 disponíveis — ponto, linha, retângulo, elipse e triângulo —, quando acionadas as teclas específicas para cada uma.

Também é possível arrastar, aumentar e diminuir o tamanho, alternar a cor e excluir uma figura em foco.

###  Criação de figuras
Pressionada a tecla específica, a figura correspondente é criada no local da moldura onde está o **cursor do mouse**.
- Tecla 'd' ou 'D': Cria ponto
- Tecla 'l' ou 'L': Cria linha
- Tecla 'r' ou 'R': Cria retângulo
- Tecla 'e' ou 'E': Cria elipse
- Tecla 't' ou 'T': Cria triângulo

### Seleção de figura em foco
Sempre que uma figura é criada, o foco muda para ela; a figura em foco pode ser identifica pelo **contorno vermelho**.
As figuras são criadas com cores randômicas. O foco de uma figura pode ser mudado de duas formas:
- Clicando com o mouse diretamente na figura desejada
- Através da tecla '/', que muda a figura em foco cada vez que a tecla é pressionada

### Eventos para figuras em foco
- Tecla 'c' ou 'C': Muda a cor da figura randomicamente
- Tecla '\[': Diminui o tamanho da figura
- Tecla '\]': Aumenta o tamanho da figura
- Tecla '→': Move a figura para a direita
- Tecla '←': Move a figura para a esquerda
- Tecla '↑': Move a figura para cima
- Tecla '↓': Move a figura para baixo
- Tecla 'DELETE': Deleta a figura
- Mouse: Movimenta a figura pelo quadro, ao pressioná-la e arrastá-la
