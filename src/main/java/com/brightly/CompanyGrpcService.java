package com.brightly;

import com.brightly.services.CompanyService;
import com.brightly.services.CompanyServiceImpl;
import com.google.protobuf.Empty;
import com.google.protobuf.Int64Value;
import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@GrpcService
public class CompanyGrpcService extends MutinyCompanyGrpcGrpc.CompanyGrpcImplBase {

    @Inject
    CompanyService companyService ;

    @Transactional
    @Override
    public Uni<Response> addCompany(CompanyDto request) {
        com.brightly.dto.CompanyDto companyDto = new com.brightly.dto.CompanyDto();
        companyDto.setCompanyCode(request.getCompanyCode());
        companyDto.setCompanyDescription(request.getCompanyDescription());
        companyDto.setCompanyName(request.getCompanyName());
        try {
            companyService.addCompany(companyDto);
        } catch (Exception ex) {
           return Uni.createFrom().item("Company addition failed!")
                    .map(msg -> Response.newBuilder().setMessage(msg).build());
        }
        return Uni.createFrom().item("Company addition Successful!")
                .map(msg -> Response.newBuilder().setMessage(msg).build());
    }

    @Transactional
    @Override
    public Uni<CompanyDto> listCompanyById(Int64Value request) {
        long companyId = request.getValue();
        com.brightly.dto.CompanyDto companyDto = companyService.findCompany(companyId);
        CompanyDto companyDtoResponse = CompanyDto.newBuilder()
                .setCompanyCode(companyDto.getCompanyCode())
                .setCompanyName(companyDto.getCompanyName())
                .setCompanyId(companyDto.getCompanyId())
                .setCompanyDescription(companyDto.getCompanyDescription()).build();

        return Uni.createFrom().item(companyDtoResponse);
    }

    @Transactional
    @Override
    public Uni<CompanyList> listCompanies(Empty request) {

        List<com.brightly.dto.CompanyDto> companyList = companyService.findAll();

        List<com.brightly.CompanyDto> companyDtos = companyList.stream()
                .map(companyDto -> com.brightly.CompanyDto.newBuilder()
                        .setCompanyId(companyDto.getCompanyId())
                        .setCompanyName(companyDto.getCompanyName())
                        .setCompanyDescription(companyDto.getCompanyDescription()).setCompanyCode(companyDto.getCompanyCode()).build()).collect(Collectors.toList());

        CompanyList companyList1 = CompanyList.newBuilder().addAllResultList(companyDtos).setResultCount(Int64Value.newBuilder().setValue(companyList.size()).build()).build();
        return Uni.createFrom().item(companyList1);
    }

}
