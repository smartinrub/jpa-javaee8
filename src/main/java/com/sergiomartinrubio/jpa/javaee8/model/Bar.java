package com.sergiomartinrubio.jpa.javaee8.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "BAR")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Bar {

    @Id
    @GeneratedValue
    @Column(name = "bar_id")
    private Integer id;

    private String name;

    // fetch strategy is eager by default
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "bar_child_id")
    private BarChild barChild;

    @OneToMany
    private Set<Foo> foos;
}
