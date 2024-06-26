package br.com.fiap.pos.soat3.pedido.infrastructure.gateways.produto;

import br.com.fiap.pos.soat3.pedido.domain.entity.Categoria;
import br.com.fiap.pos.soat3.pedido.domain.entity.Produto;
import br.com.fiap.pos.soat3.pedido.infrastructure.persistence.categoria.CategoriaEntity;
import br.com.fiap.pos.soat3.pedido.infrastructure.persistence.produto.ProdutoEntity;

import java.math.BigDecimal;
import java.util.List;

public class ProdutoEntityMapper {

    public ProdutoEntity toEntity(Produto produtoDomainObj) {
        return new ProdutoEntity(produtoDomainObj.getNome(),
                produtoDomainObj.getValor().toString(),
                produtoDomainObj.getDescricao(),
                produtoDomainObj.getImagem(),
                new CategoriaEntity(produtoDomainObj.getCategoria().getId()));
    }

    public ProdutoEntity updateEntity(ProdutoEntity produtoEntity, Produto produtoDomainObj) {

        if (produtoDomainObj.getNome() != null) {
            produtoEntity.setNome(produtoDomainObj.getNome());
        }
        if (produtoDomainObj.getDescricao() != null) {
            produtoEntity.setDescricao(produtoDomainObj.getDescricao());
        }
        if (produtoDomainObj.getValor() != null) {
            produtoEntity.setValor(produtoDomainObj.getValor().toString());
        }
        if (produtoDomainObj.getImagem() != null) {
            produtoEntity.setImagem(produtoDomainObj.getImagem());
        }
        if (produtoDomainObj.getCategoria() != null && produtoDomainObj.getCategoria().getId() != null) {
            CategoriaEntity categoriaEntity = new CategoriaEntity(produtoDomainObj.getCategoria().getId());
            produtoEntity.setCategoria(categoriaEntity);
        }
        return produtoEntity;
    }

    public List<Produto> toDomainListObj(List<ProdutoEntity> produtoCleanEntities) {
        List<Produto> produtos = produtoCleanEntities.stream()
                .map(produto -> new Produto(produto.getId(),
                        produto.getNome(),
                        produto.getDescricao(),
                        produto.getImagem(),
                        new BigDecimal(produto.getValor()),
                        new Categoria(produto.getCategoria().getId(), produto.getCategoria().getNome())))
                .toList();

        return produtos;
    }

    public Produto toDomainObj(ProdutoEntity produtoEntity) {
        return new Produto(produtoEntity.getId(),
                produtoEntity.getNome(),
                produtoEntity.getDescricao(),
                produtoEntity.getImagem(),
                new BigDecimal(produtoEntity.getValor()),
                new Categoria(produtoEntity.getCategoria().getId(), produtoEntity.getCategoria().getNome()));
    }
}
