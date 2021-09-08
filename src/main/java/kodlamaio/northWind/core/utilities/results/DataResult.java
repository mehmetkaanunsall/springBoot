
package kodlamaio.northWind.core.utilities.results;


// <T> ifadesi herhangi bir obje ile çalışabileceğimizi söylüyoruz (Product,Employee,Category) gibi
// Bu class işlemin başaralı olup olmadığını ,Mesajı Ve Datayı döndürür
public class DataResult<T> extends  Result{
    private T data;
    public DataResult( T data,boolean success, String message) {
        super(success, message);
        this.data = data;
    }
    
     public DataResult( T data,boolean success) {
        super(success);
        this.data = data;
    }

    public T getData() {
        return data;
    }
    
  
}
