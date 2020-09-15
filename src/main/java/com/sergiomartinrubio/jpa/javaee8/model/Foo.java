package com.sergiomartinrubio.jpa.javaee8.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "FOO")
@NamedQuery(name = "Foo.findAll", query = "SELECT f FROM Foo f")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Foo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "foo_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "bar_id", referencedColumnName = "bar_id")
    private Bar bar;

    @ManyToMany(mappedBy = "foos")
    private List<FooChild> fooChildren;
}
