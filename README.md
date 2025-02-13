# 📌 Documentação da API - Gerenciamento de Veículos

## 📍 Introdução

Esta API permite o gerenciamento de marcas, modelos e veículos.
Os endpoints fornecem operações para listar, cadastrar, atualizar e excluir dados.

---

## 🏎️ Veículos

### 🔹 Listar Veículos

**GET** `/api/veiculos/listarVeiculos`

#### 🔹 Exemplo de Resposta:

```json
[
    {
        "id": 4,
        "modelo": {
            "id": 2,
            "nome": "Dolphin",
            "marca": {
                "id": 2,
                "nome": "BYD"
            }
        },
        "anoFabricacao": 2023,
        "cor": "Azul",
        "preco": 120000.00,
        "quilometragem": 8000,
        "statusDisponibilidade": "RESERVADO"
    }
]
```

### 🔹 Cadastrar Veículo

**POST** `/api/veiculos/cadastrarVeiculo`

#### 🔹 Parâmetros (JSON):

```json
{
    "modelo": { "id": 2 },
    "anoFabricacao": 2023,
    "cor": "Azul",
    "preco": 120000.00,
    "quilometragem": 8000,
    "statusDisponibilidade": "RESERVADO"
}
```

#### 🔹 Respostas:
- `201 Created`: Veículo cadastrado com sucesso.
- `400 Bad Request`: Erro na requisição.

### 🔹 Atualizar Veículo

**PUT** `/api/veiculos/atualizarVeiculo/{id}`

#### 🔹 Parâmetros (JSON):

```json
{
    "modelo": { "id": 2 },
    "anoFabricacao": 2024,
    "cor": "Preto",
    "preco": 130000.00,
    "quilometragem": 5000,
    "statusDisponibilidade": "DISPONIVEL"
}
```

#### 🔹 Respostas:
- `200 OK`: Veículo atualizado com sucesso.
- `404 Not Found`: Veículo não encontrado.

### 🔹 Deletar Veículo

**DELETE** `/api/veiculos/deletarVeiculo/{id}`

#### 🔹 Respostas:
- `202 Accepted`: Veículo deletado com sucesso.
- `404 Not Found`: Veículo não encontrado.

---

## 🚘 Modelos

### 🔹 Listar Modelos

**GET** `/api/modelos/listarModelos`

### 🔹 Cadastrar Modelo

**POST** `/api/modelos/cadastrarModelo`

#### 🔹 Parâmetros (JSON):

```json
{
    "nome": "Corolla",
    "marca": { "id": 1 }
}
```

### 🔹 Deletar Modelo

**DELETE** `/api/modelos/deletarModelo/{id}`

---

## 🏢 Marcas

### 🔹 Listar Marcas

**GET** `/api/marcas/listarMarcas`

### 🔹 Cadastrar Marca

**POST** `/api/marcas/cadastrarMarca`

#### 🔹 Parâmetros (JSON):

```json
{
    "nome": "Toyota"
}
```

### 🔹 Deletar Marca

**DELETE** `/api/marcas/deletarMarca/{id}`

---

## 🔗 Considerações Finais

- Todas as requisições devem ser feitas para `http://localhost:8080`.
- O `id` de modelos e marcas deve existir antes de cadastrar um veículo.
- Use ferramentas como Postman, cURL ou o Fetch API para testar a API.
