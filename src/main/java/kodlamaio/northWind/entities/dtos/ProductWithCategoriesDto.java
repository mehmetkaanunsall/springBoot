
package kodlamaio.northWind.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductWithCategoriesDto {
    
    private int id;
    private String productName;
    private String categoryName;
}
