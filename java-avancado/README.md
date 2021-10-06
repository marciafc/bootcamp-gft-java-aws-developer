# Java avançado

## Paradigma Imperativo

  - É imperativa
    
  - Controle do estado dos objetos em cada linha executada

  - [Imperativo.java](src/main/java/br/com/marcia/aula1/Imperativo.java)

## Paradigma Funcional

  - [Composição de funções](src/main/java/br/com/marcia/aula1/ComposicaoDeFuncoes.java)

  - [Funções puras](src/main/java/br/com/marcia/aula1/FuncoesPuras.java)
    - Retorna sempre o mesmo valor
      
  - Evita compartilhamento de estados, dados mutáveis e efeitos colaterais
    - [Princípio da Imutabilidade](src/main/java/br/com/marcia/aula1/Imutabilidade.java)
    
  - É declarativo: declara o que tem que fazer
    
  - [Funcional.java](src/main/java/br/com/marcia/aula1/Funcional.java)

  - [Interface funcional](src/main/java/br/com/marcia/aula1/Aula.java)
    - só pode ter um método a ser implementado
    - pode ter método default 
    - @FunctionalInterface é opcional
    
  - Interfaces       
    - Antes do Java 8 era necessário criar com classe anônima
      - Criar a interface [Funcao](src/main/java/br/com/marcia/aula1/Funcao.java) e depois [instanciar e implementar](src/main/java/br/com/marcia/aula1/FuncaoComClasseAnonima.java)
      - Verbosidade  
      - Código mais complexo  
    - Java 8: Interface funcional, lambda 
      - InterfaceFuncional nomeVariavel = parametro -> logica
      - [FuncaoComLambda](src/main/java/br/com/marcia/aula1/FuncaoComLambda.java) 
    
  - Recursividade
    <img src="explicacao-recursividade.png">
      
    

## Referência

  - [Instrutor jpbaterabsb - Gitlab](https://github.com/jpbaterabsb/java-avancado)

