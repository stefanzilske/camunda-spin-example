package de.holisticon.spin.example.domain;

import lombok.*;

import javax.money.MonetaryAmount;

/**
 * Created by stefanzilske on 28.04.17.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class AnotherDomainObject {

    private Long id;

    private String name;

    private MonetaryAmount cost;

    private OneDomainObject parent;

}
