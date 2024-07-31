package com.example.coffeeweb.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users", uniqueConstraints = {
        @UniqueConstraint(name = "unique_user_name",
        columnNames= {"user_name"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @SequenceGenerator(name = "customer_id_seq_gen", sequenceName = "customer_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "customer_id_seq_gen", strategy = GenerationType.SEQUENCE)
    @Id
    private Integer id;

    @Column(name="user_name",length = 50,nullable = false)
    private String userName;

    @Column(name="customer_email",length = 50,nullable = false)
    private String customerEmail;



}

