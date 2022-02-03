package com.gmail.basecv.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Objects;

@Data
@EqualsAndHashCode(callSuper = false)
public class OrganizationSection extends Section {

    private final List<Organization> organizations;

    public OrganizationSection(List<Organization> organizations) {
        Objects.requireNonNull(organizations, "organizations must not be null");
        this.organizations = organizations;
    }
}
