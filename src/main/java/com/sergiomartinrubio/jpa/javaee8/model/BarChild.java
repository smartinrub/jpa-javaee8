package com.sergiomartinrubio.jpa.javaee8.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "BAR_CHILD")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class BarChild {

    @Id
    @GeneratedValue
    @Column(name = "bar_child_id")
    private Integer id;


    // fetch strategy is eager by default
    @OneToOne(
            mappedBy = "barChild",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Bar bar;
}
