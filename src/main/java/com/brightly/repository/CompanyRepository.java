package com.brightly.repository;

import com.brightly.entity.Company;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.runtime.annotations.RegisterForReflection;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RegisterForReflection
public class CompanyRepository implements PanacheRepository<Company> {
}
