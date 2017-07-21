package de.holisticon.spin.example.domain;

import lombok.*;

import java.util.Set;

/**
 * Created by stefanzilske on 28.04.17.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class OneDomainObject {

    private Long id;

    private String name;

    private Set<AnotherDomainObject> children;
}
