package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Setter
@Getter
@DiscriminatorValue("A")
@Entity
public class Album extends Item {
    private String artist;
    private String etc;

}
