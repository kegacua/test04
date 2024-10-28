package com.example.test04.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Seller {

    @Id
    private Long idSeller;
    

    private String nameSeller;

    @ManyToOne
    @JoinColumn(name="team_id")
    private Team team;
}
