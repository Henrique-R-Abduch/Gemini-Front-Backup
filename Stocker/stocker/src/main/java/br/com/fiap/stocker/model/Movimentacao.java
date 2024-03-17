package br.com.fiap.stocker.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.fiap.stocker.validation.TipoMovimentacao;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movimentacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_MOVIMENTACAO")
    @SequenceGenerator(name = "ID_MOVIMENTACAO", sequenceName = "ID_MOVIMENTACAO")
    @Column(name = "ID_MOVIMENTACAO") 
    private int id;

    @NotBlank
    @Size(min = 5, message = "a descricao deve ter mais de 5 caracteres")
    private String descricao;

    @Past
    private LocalDate data;

    @Positive(message = "o valor deve ser positivo")
    private BigDecimal valor;

    @TipoMovimentacao(message = "Os valores aceitos são DEBITO e CREDITO")
    private String tipo;

    //boillerplate code

}
