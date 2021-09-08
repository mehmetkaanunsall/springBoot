
package kodlamaio.northWind.core.utilities.results;

import java.util.List;
import kodlamaio.northWind.entities.dtos.ProductWithCategoriesDto;


public class SuccessDataResult<T> extends DataResult<T>{
    
    
     public SuccessDataResult(T data,  String message) {
        super(data, true,message);
    }
     
      public SuccessDataResult(T data) {
        super(data, true);
    }
      
      public SuccessDataResult(String message) {
        super(null, true,message);
    }
      
       public SuccessDataResult() {
        super(null, true);
    }

   
    
}
