package br.com.clientapi.clientapi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_service")
    private Integer idService;

    @Column(name = "description_service", nullable = false, length = 500)
    private String descriptionService;

    @Column(name = "value_service", nullable = false)
    private BigDecimal valueService;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

}
