package org.dr.inventoryservice.dto;


public record ProductRequestDTO(Long idProduct,
                                String name,
                                double price,
                                int quantity,
                                Long categoryId) {


}
