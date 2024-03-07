package br.com.fiap.stocker.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_TP_PRODUTO", uniqueConstraints = {
    @UniqueConstraint(name = "UK_NM_TP_PRODUTO", columnNames = {"NM_TP_PRODUTO"})
})
public class TipoProduto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_TP_PRODUTO")
    @SequenceGenerator(name = "ID_TP_PRODUTO", sequenceName = "ID_TP_PRODUTO")
    @Column(name = "ID_TP_PRODUTO")    
    private int id;

    @Column(name = "NM_TP_PRODUTO", nullable = false)
    private String nome;
 
}
