package com.sergiomartinrubio.jpa.javaee8.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@Table(name = "BAR_CHILD")
public class BarChild {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @OneToOne(mappedBy = "barChild")
    private Bar bar;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BarChild barChild = (BarChild) o;
        return Objects.equals(id, barChild.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
