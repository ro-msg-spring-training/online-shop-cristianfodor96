package ro.msg.learning.shop.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dtos.SupplierDTO;
import ro.msg.learning.shop.entities.Supplier;

@Component
@RequiredArgsConstructor
public class SupplierMapper {
    public SupplierDTO supplierToSupplierDTO(Supplier supplier) {
        return SupplierDTO.builder()
                .name(supplier.getName())
                .build();
    }

    public Supplier supplierDtoToSupplier(SupplierDTO supplierDTO) {
        return Supplier.builder()
                .name(supplierDTO.getName())
                .build();
    }
}