# Departamento com Guardas de Trânsito 😎🦺

Este é um projeto Java em Spring Framework que tem o objetivo de registrar locais com grandes eventos (aqui chamados departamentos) com os seus respectivos guardas de trânsito.

<p align="center">
    <img width="460" height="300" src="src/assets/to_readme/bateAew.gif">
</p>

## Departamento 🏢
- Cada departamento possui o seu número de identificação **(id)**, **nome**, **endereço** e uma lista de **guardas**. 
  - O endereço pode ser gravado apenas com o valor do CEP, pois o programa irá obter automaticamente os outros valores (como logradouro, localidade, uf...) através da API [https://viacep.com.br/ws](https://viacep.com.br/ws).
  - 👮‍ Cada guarda possui o seu **nome**, **horário de entrada**, **horário de saída** e em que **parte do local** ele irá trabalhar (por exemplo, "guarita" ou "estacionamento A").

## Exemplo

Na URL, digitando "_departamentos/_" e o número de identificação do departamento, é possível obter os dados do local e dos guardas relacionados com o número de ID digitado.


### localhost:8080/departamentos/1

```
{
    "id": 1,
    "nomeLocal": "Salão de Assembleia",
    "endereco": {
        "cep": "17048-696"
        ...
    },
    "guardas": [
        {
            "nome": "José",
            "horaEntrada": "7",
            "horaSaida": "12",
            "local": "Guarita"
        },
        {
            "nome": "João",
            "horaEntrada": "12",
            "horaSaida": "17",
            "local": "Guarita"
        },
        {
            "nome": "Yuri",
            "horaEntrada": "7",
            "horaSaida": "16",
            "local": "Estacionamento"
        }
    ]
}
```

## Prático

Este projeto também procura explorar alguns padrões de projetos utilizados para resolver problemas, na prática. Especificamente são eles:
- Singleton
- Strategy/Repository
- Facade

E se aplica para:

- Organizar locais em que serão administrados
- Saber quais guardas irão trabalhar no evento
- Ter noção dos horários de entrada e saída dos guardas
- Não deixar espaço algum sem guardas, de modo que tenha monitoramento completo
