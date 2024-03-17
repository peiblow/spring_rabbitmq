package dto;

import java.io.Serializable;

public record PriceDTO(String codProduct, Double price) implements Serializable {
}
