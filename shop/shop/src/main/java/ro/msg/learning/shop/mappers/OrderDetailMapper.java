package ro.msg.learning.shop.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dtos.OrderDetailDTO;
import ro.msg.learning.shop.entities.OrderDetail;
import ro.msg.learning.shop.entities.OrderDetailKey;
import ro.msg.learning.shop.entities.Product;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderDetailMapper {

    public List<OrderDetail> orderDetailDtoToOrderDetail(List<OrderDetailDTO> orderDetailDTO) {
        return orderDetailDTO.stream()
                .map(dto -> OrderDetail.builder()
                        .id(new OrderDetailKey(dto.getProductId(), null))
                        .product(Product.builder().id(dto.getProductId()).build())
                        .quantity(dto.getQuantity()).build()).collect(Collectors.toList());
    }

    public List<OrderDetailDTO> orderDetailToOrderDetailDTO(List<OrderDetail> orderDetail) {
        return orderDetail.stream()
                .map(o -> OrderDetailDTO.builder()
                        .productId(o.getProduct().getId())
                        .quantity(o.getQuantity()).build()).collect(Collectors.toList());
    }
}
