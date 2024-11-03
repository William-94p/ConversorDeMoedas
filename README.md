# Conversor de Moedas - Challenge Alura & Oracle

Este é um projeto desenvolvido como parte do Challenge promovido pela Alura em parceria com a Oracle. O desafio propõe a criação de uma aplicação em Java para realizar a conversão de moedas de forma prática e interativa, utilizando uma API externa para obter as taxas de câmbio atualizadas.

## Descrição do Projeto

A aplicação é um **Conversor de Moedas** que permite ao usuário converter valores entre diferentes moedas. O projeto foi desenvolvido em **Java** e utiliza a biblioteca **HttpClient** para realizar requisições HTTP para uma API de taxas de câmbio. Com essa integração, a aplicação fornece uma experiência interativa e dinâmica de conversão, com base em taxas de câmbio reais e atualizadas.

O projeto apresenta um menu interativo com opções de conversão específicas, possibilitando ao usuário realizar conversões comuns, como de Real para Dólar, Real para Euro, Iene para Euro, e outras. 

## Tecnologias Utilizadas

- **Java**: Linguagem principal do projeto, escolhida pela sua versatilidade e pela robustez em desenvolvimento de aplicações.
- **HttpClient**: Biblioteca nativa do Java, usada para realizar requisições HTTP. Facilita a comunicação com APIs externas, permitindo que o aplicativo acesse as taxas de câmbio.
- **ExchangeRate-API**: API utilizada para obter as taxas de câmbio atualizadas em tempo real, permitindo a conversão precisa dos valores entre moedas.

## Como o Projeto Funciona

### Estrutura do Projeto

O projeto consiste em um único arquivo Java que contém:
1. **Menu Interativo**: Um menu de opções permite ao usuário selecionar uma conversão específica.
2. **Requisição à API de Câmbio**: Ao iniciar a aplicação, o programa carrega as taxas de câmbio atuais diretamente da API.
3. **Conversão de Moedas**: A aplicação utiliza as taxas de câmbio fornecidas pela API para converter valores entre as moedas selecionadas.
4. **Funções Auxiliares**: Funções de suporte para interpretar os dados da API e processar as conversões.

### Opções do Menu

O menu apresenta as seguintes opções de conversão para o usuário:

```
=== Conversor de Moedas ===
Escolha uma opção:
1. Real para Dólar
2. Real para Euro
3. Real para Peso argentino
4. Real para Iene
5. Iene para Euro
6. Peso argentino para Dólar
7. Sair
```

### Como Funciona a Conversão

1. A aplicação consulta as taxas de câmbio da API ExchangeRate-API, com base no Real (BRL) como moeda de referência.
2. Através das taxas obtidas, calcula-se o valor desejado entre as moedas de origem e destino escolhidas pelo usuário.
3. As taxas de câmbio são utilizadas em fórmulas matemáticas que asseguram a conversão precisa entre quaisquer pares de moedas disponíveis.

### Utilização da API ExchangeRate-API

A API fornece dados de câmbio atualizados a cada requisição. Para esse projeto, as taxas de câmbio são obtidas com a seguinte URL:
```url
https://v6.exchangerate-api.com/v6/4fec4e59ef5321f89431ef79/latest/BRL
```
> **Nota:** É necessário substituir `4fec4e59ef5321f89431ef79` pela sua própria chave de API, obtida ao registrar-se no [ExchangeRate-API](https://www.exchangerate-api.com/).

## Como Executar o Projeto

1. **Pré-requisitos**:
   - Ter o Java instalado na versão 11 ou superior.
   - Configurar uma chave de API própria no `API_URL` no código, caso a chave fornecida não esteja mais ativa.

2. **Clonar o repositório**:
   ```bash
   git clone https://github.com/seu-usuario/conversor-moedas-challenge.git
   cd conversor-moedas-challenge
   ```

3. **Compilar e Executar**:
   - Compile o arquivo Java:
     ```bash
     javac ConversorMoedas.java
     ```
   - Execute a aplicação:
     ```bash
     java ConversorMoedas
     ```

4. **Uso**:
   - Ao iniciar, o programa exibe o menu de opções. Escolha a opção de conversão desejada e insira o valor em reais (ou na moeda especificada no menu).
   - O programa exibirá o valor convertido e retornará ao menu para novas conversões.

## Desafios e Aprendizado

Este projeto faz parte do Challenge Alura + Oracle, uma iniciativa para aprimorar habilidades em Java e explorar o uso de APIs externas. O projeto promoveu um aprendizado prático sobre:

- Consumo de APIs em Java usando HttpClient
- Manipulação de JSON e taxas de câmbio
- Estruturação e implementação de uma aplicação orientada a menus interativos
  
Essa experiência também permitiu o desenvolvimento de habilidades importantes para o mercado de trabalho, como integração com APIs e boas práticas de programação em Java.

## Contribuição

Sinta-se à vontade para contribuir com este projeto. Sugestões de melhoria, correções de bugs ou novas funcionalidades são sempre bem-vindas. 

1. **Fork o repositório**
2. **Crie uma branch**: `git checkout -b minha-nova-funcionalidade`
3. **Commit suas mudanças**: `git commit -m 'Adiciona nova funcionalidade'`
4. **Envie para a branch**: `git push origin minha-nova-funcionalidade`
5. **Abra um Pull Request**

---

**Alura + Oracle | Challenge Back-End**
