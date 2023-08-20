package com.example.week5day1.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class CustomerDetials {
    @Id
    private Integer id;
    @NotEmpty(message = "should be not empty")
//    @Column(columnDefinition = "varchar(9) not null")
    private String gender;

    @NotNull(message = "should be not null")
//   @Column(columnDefinition = "int not null ")
    private Integer age;
    @NotEmpty(message = "should be not empty")
//    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Customer customer;
}
