package com.brightly.services;

import com.brightly.dto.CompanyDto;
import com.brightly.entity.Company;
import com.brightly.repository.CompanyRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CompanyServiceImpl implements CompanyService {

    @Inject
    private CompanyRepository companyRepository;

    @Override
    @Transactional
    public void addCompany(CompanyDto companyDto) {
        Company company = new Company();
        company.setCode(companyDto.getCompanyCode());
        company.setName(companyDto.getCompanyName());
        company.setDescription(companyDto.getCompanyDescription());

        companyRepository.persist(company);
    }

    @Override
    public CompanyDto findCompany(long id) {
        Company company = companyRepository.findById(id);
        CompanyDto companyDto = null;
        if(company != null) {
            companyDto = getCompanyDto(company);
        }
        return companyDto;
    }

    private CompanyDto getCompanyDto(Company company) {
        CompanyDto companyDto = new CompanyDto();
        companyDto.setCompanyId(company.id);
        companyDto.setCompanyCode(company.getCode());
        companyDto.setCompanyName(company.getName());
        companyDto.setCompanyDescription(company.getDescription());
        return companyDto;
    }

    @Override
    public List<CompanyDto> findAll() {
        List<Company> companyList = companyRepository.listAll();
        return  getCompanyDtos(companyList);
    }

    private List<CompanyDto> getCompanyDtos(List<Company> companyList) {
        List<CompanyDto> companyDtoList = new ArrayList<>();
        if(companyList != null && !companyList.isEmpty()) {
            companyDtoList = companyList
                    .stream()
                    .map(company -> getCompanyDto(company))
                    .collect(Collectors.toList());
        }
        return companyDtoList;
    }
}
