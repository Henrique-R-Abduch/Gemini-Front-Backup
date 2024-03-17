package br.com.fiap.stocker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_PRODUTO", uniqueConstraints = {
    @UniqueConstraint(name = "UK_NM_PRODUTO", columnNames = {"NM_PRODUTO"})
})
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_PRODUTO")
    @SequenceGenerator(name = "ID_PRODUTO", sequenceName = "ID_PRODUTO")
    @Column(name = "ID_PRODUTO")  
    private int id;

    @Column(name = "NM_PRODUTO", nullable = false)
    private String nome;

    @Column(name = "QTD_PRODUTO")
    private int qtd;

    @Column(name = "PRECO_PRODUTO")
    private float preco;

    @Column(name = "DESC_PRODUTO")
    private String desc;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "ID_TP_PRODUTO",
            referencedColumnName = "ID_TP_PRODUTO",
            foreignKey = @ForeignKey(name = "FK_TP_PRODUTO")
    )
    private TipoProduto tipo;

}
