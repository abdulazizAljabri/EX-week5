package com.example.week5day1.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.engine.internal.Cascade;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Should not be empty")
//    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    // relation one to one
    @OneToOne(cascade = CascadeType.DETACH , mappedBy = "customer")
    @PrimaryKeyJoinColumn
    private CustomerDetials customerDetials;

}
