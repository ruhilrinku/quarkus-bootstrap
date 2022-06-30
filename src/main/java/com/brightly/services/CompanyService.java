package com.brightly.services;

import com.brightly.dto.CompanyDto;

import java.util.List;

public interface CompanyService {

    public void addCompany(CompanyDto companyDto);

    public CompanyDto findCompany(long id);

    public List<CompanyDto> findAll();
}
