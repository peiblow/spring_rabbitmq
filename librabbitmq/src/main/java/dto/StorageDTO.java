package dto;

import java.io.Serializable;

public record StorageDTO(String codProduct, Integer quantity) implements Serializable {
}
