package com.sergiomartinrubio.jpa.javaee8.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "FOO")
@NamedQuery(name = "Foo.findAll", query = "SELECT f FROM Foo f")
public class Foo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "bar_id", nullable = false)
    private Bar bar;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "foo_child",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "foo_id"))
    private List<FooChild> fooChildren;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Foo foo = (Foo) o;
        return Objects.equals(id, foo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
