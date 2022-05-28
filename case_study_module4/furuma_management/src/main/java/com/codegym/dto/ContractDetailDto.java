package com.codegym.dto;

import com.codegym.model.AttachService;
import com.codegym.model.Contract;

public class ContractDetailDto {
    private Integer contractDetailId;
    private Integer quantity;
    private Contract contract;
    private AttachService attachService;

    public ContractDetailDto() {
    }

    public ContractDetailDto(Integer quantity, Contract contract, AttachService attachService) {
        this.quantity = quantity;
        this.contract = contract;
        this.attachService = attachService;
    }

    public Integer getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Integer contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }
}
