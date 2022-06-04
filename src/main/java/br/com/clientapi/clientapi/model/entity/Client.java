package br.com.clientapi.clientapi.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Integer idClient;

    @Column(name = "name_client", nullable = false, length = 300)
    private String nameClient;

    @Column(name = "cpf_client", nullable = false, length = 11)
    private String cpfClient;

    @Column(name = "date_register_client", nullable = false, updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateRegisterClient;

    @PrePersist
    public void prePersist(){
        this.setDateRegisterClient(LocalDate.now());
    }

}
