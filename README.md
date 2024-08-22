# Desafios de lógica
Este repositório possui a finalidade de armazenar os desafios de lógica propostos pela Supera Inovação em Tecnologia.
## Desafio dos resistores
A resolução está na pasta /desafio/resistores.
### Introdução
Os resistores são componentes elétricos marcados com listras/faixas coloridas para indicar tanto o
valor de sua resistência em ohms, quanto a tolerância permitida.
Imagine que Diogo, o dono de um "Kit Básico Raspberry Pi", esvaziou diversos sacos zip-lock de
resistores, e ao invés de ficar procurando de um por um o resistor para seu projeto, precisa que a
partir do valor necessário, tenha em mãos a sequência de cores correta.
#### Código de Cores dos Resistores
Os códigos básicos dos resistores são:
- 0: preto
- 1: marrom
- 2: vermelho
- 3: laranja
- 4: amarelo
- 5: verde
- 6: azul
- 7: violeta
- 8: cinza
- 9: branco


Todos os resistores possuem pelo menos três bandas, sendo que a primeira e a segunda banda
correspondem ao primeiro e segundo dígito do valor de ohms. A terceira indica a potência de 10 que
deve ser multiplicada para obter o valor.


Exemplo: Um resistor de 47 ohms é igual a 47 * 10 ^ 0, teria a seguinte sequência de cores:
amarelo violeta preto


A maioria dos resistores também possuem uma quarta faixa que indica sua tolerância ( 5% por
exemplo ), representado por uma faixa dourada. Portanto, no exemplo acima, ficaria amarelo
violeta preto dourado.
#### Desafio
Sua função deverá receber uma string contendo o valor de ohms a ser convertido, seguido de um
espaço e a palavra "ohms" (ex: 47 ohms)


Os valores de entrada seguem as seguintes regras:
- Para resistores menores que 1000 ohms, o valor em ohms é formatado apenas
como um número simples. Por exemplo, com o resistor de 47 ohms acima, sua função
receberia a string "47 ohms" e retornaria a string "amarelo violeta preto dourado".
- Para resistores maiores ou iguais a 1000 ohms, mas menores que 1.000.000 ohms, o
valor de ohms é dividido por 1.000 e tem um "k" minúsculo depois dele. Por exemplo, se
sua função recebesse a string "4.7k ohms", ela precisaria retornar a string "amarelo violeta
vermelho dourado".
- Para resistores maior ou igual a 1.000.000 ohms, o valor de ohms é dividido por
1.000.000 e tem um “M” maiúsculo depois dele. Por exemplo, se sua função recebesse a
string “1M ohms”, ela precisaria retornar a string “marrom preto verde dourado”.


Mais Exemplos:
- "10 ohms" => "marrom preto preto dourado"
- "100 ohms" => "marrom preto marrom dourado"
- "220 ohms" => "vermelho vermelho marrom dourado"
- "330 ohms" => "laranja laranja marrom dourado"
- "470 ohms" => "amarelo violeta marrom dourado"
- "680 ohms" => "azul cinza marrom dourado"
- "1k ohms" => "marrom preto vermelho dourado"
- "2M ohms" => "vermelho preto verde dourado"


Observações


Os números decimais de entrada serão sempre separados por ponto.

## Desafio Snail
A resolução está na pasta /desafio/snail.
### Desafio
Dado uma matriz N x N, retorne os valores organizados dos elementos mais externos para os mais
internos, em sentido horário.\
Exemplo:

![snail-chalenge](/images/snail-chalenge.png)

### Observações
- A ideia é percorrer a matriz de duas dimensões em um padrão de caracol no sentido horário
- Uma entrada com uma matriz vazia também deve ser considerada