package com.sergiomartinrubio.jpa.javaee8.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "BAR")
public class Bar {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    private String name;

    // fetch strategy is eager by default
    @OneToOne
    @JoinColumn(name = "bar_child_id", referencedColumnName = "id")
    private BarChild barChild;

    // lazy fetch strategy by default
    @OneToMany(mappedBy = "bar")
    private List<Foo> foos;

}
