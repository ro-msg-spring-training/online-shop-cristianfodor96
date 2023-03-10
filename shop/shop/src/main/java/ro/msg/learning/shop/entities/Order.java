package ro.msg.learning.shop.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@Table(name = "product_order")
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime created;
    @Embedded
    private Address address;
    @JoinColumn(name = "shipped_from_id")
    @ManyToOne
    private Location shippedFrom;
    @JoinColumn(name = "customer_id")
    @ManyToOne
    private Customer customer;

    @JoinColumn(name = "order_id")
    @OneToMany
    private List<OrderDetail> orderDetails;
}
