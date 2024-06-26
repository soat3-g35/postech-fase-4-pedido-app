package br.com.fiap.pos.soat3.pedido.infrastructure.controllers.categoria;

import jakarta.validation.constraints.NotEmpty;

public record CategoriaRequest(@NotEmpty(message = "Nome da Categoria não pode ser vazio") String nome) {
}
