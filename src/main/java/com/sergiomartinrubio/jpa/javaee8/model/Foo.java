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
@Table(name = "FOO")
@NamedQuery(name = "Foo.findAll", query = "SELECT f FROM Foo f")
public class Foo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

//    @ManyToOne
//    @JoinColumn(name = "bar_id", nullable = false)
//    private Bar bar;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "foo_child",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "foo_id"))
    private List<FooChild> fooChildren;

}
