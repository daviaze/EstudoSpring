package estudo.spring.services.results;

public class Result {
    public static Response onFail(Exception e){
        return new Response(e.getMessage(), null, true);
    }

    public static Response onFail(String e){
        return new Response(e, null, true);
    }

    public static Response onSuccess(Object obj){
        return new Response("Ok", obj, false);
    }
}


