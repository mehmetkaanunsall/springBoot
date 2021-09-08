
package kodlamaio.northWind.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="categories")
@Entity
//donguye girmesini engellemek için @JsonIgnoreProperties anatosyanı kullanıldı
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})
public class Category {
    
    @Id
    @Column(name ="category_id")
    private int categoryId;
    
    @Column(name ="category_name")
    private String categoryName;
    
    @OneToMany(mappedBy = "category")
    List <Product> products;
    
    
    
}
