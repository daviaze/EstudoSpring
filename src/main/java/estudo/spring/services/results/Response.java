package estudo.spring.services.results;

public class Response {

    public String message;
    public Object metadata;
    public boolean error;

    public Response(String message, Object obj, boolean error){
        this.message = message;
        if(obj != null){
            this.metadata = obj;
        }
        this.error = error;
    }
    
}
