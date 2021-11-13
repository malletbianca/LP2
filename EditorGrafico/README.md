# LP2: Projeto 2/2
Projeto de editor gráfico vetorial.
O editor cria figuras entre as 5 disponíveis — ponto, linha, retângulo, elipse e triângulo —, através do clique, quando acionada a opção específica para cada uma das figuras no menu de ferramentas.

Também é possível arrastar, aumentar e diminuir o tamanho, alternar a cor e excluir uma figura em foco.

###  Criação de figuras
É preciso selecionar a figura desejada no menu de seleção. A figura que corresponde ao botão em foco é criada, apenas através do **clique**, no local da moldura onde está o **cursor do mouse**. Para criar uma nova figura, é preciso que um botão seja selecionado novamente.

Além disso, existem teclas específicas que funcionam como **atalhos** para o menu de botões. Os comandos são os seguintes:
- Tecla 'd' ou 'D': Atalho para ponto
- Tecla 'l' ou 'L': Atalho para linha
- Tecla 'r' ou 'R': Atalho para retângulo
- Tecla 'e' ou 'E': Atalho para elipse
- Tecla 't' ou 'T': Atalho para triângulo
- Tecla 'ESC': Desabilita qualquer botão em foco no menu de figuras

### Seleção de figura em foco
Sempre que uma figura é criada, o foco muda para ela; a figura em foco pode ser identificada pelo **contorno vermelho**.
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
