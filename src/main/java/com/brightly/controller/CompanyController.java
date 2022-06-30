package com.brightly.controller;

import com.brightly.dto.CompanyDto;
import com.brightly.entity.Company;
import com.brightly.services.CompanyService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("/companies")
public class CompanyController {

    @Inject private CompanyService companyService;

    @POST
    public void addCompany(CompanyDto companyDto) {
        companyService.addCompany(companyDto);
    }

    @Transactional
    @POST
    @Path("/create")
    public void addCompany(Company company) {
        Company.persist(company);
    }

    @GET
    public List<CompanyDto> listCompanies() {
        return companyService.findAll();
    }

    @GET
    @Path("/{id}")
    public CompanyDto listCompanyById(@PathParam("id") long id) {
        return companyService.findCompany(id);
    }
}
