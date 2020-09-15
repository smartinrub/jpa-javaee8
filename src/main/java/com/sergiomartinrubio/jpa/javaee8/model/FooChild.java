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
@Table(name = "FOO_CHILD")
public class FooChild {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "foo_field")
    @Basic(fetch = FetchType.EAGER)
    private String fooField;

    @ManyToMany(mappedBy = "fooChildren", fetch = FetchType.EAGER)
    private List<Foo> foos;

}
