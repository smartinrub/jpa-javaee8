package com.sergiomartinrubio.jpa.javaee8.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "FOO_CHILD")
public class FooChild {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Basic(fetch = FetchType.EAGER)
    private String name;

    @ManyToMany(mappedBy = "fooChildren", fetch = FetchType.EAGER)
    private List<Foo> foos;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FooChild fooChild = (FooChild) o;
        return Objects.equals(id, fooChild.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
