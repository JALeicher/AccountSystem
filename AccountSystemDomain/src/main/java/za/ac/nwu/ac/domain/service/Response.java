package za.ac.nwu.ac.domain.service;

import java.io.Serializable;
import java.util.Objects;


public class Response<T> implements Serializable {

    private final boolean successful;
    private final transient T payload;

    public Response(boolean successful, T payload){
        this.payload=payload;
        this.successful=successful;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public T getPayload() {
        return payload;
    }

    @Override
    public boolean equals(Object o){
        if(this==o){
            return true;
        }
        if(o==null||getClass() != o.getClass()){
            return false;
        }
        Response<?> that= (Response<?>) o;
        return successful == that.successful && Objects.equals(payload,that.payload);
    }

    @Override
    public int hashCode(){
        return Objects.hash(successful,payload);
    }

    @Override
    public String toString(){
        return "Response{ "+
                "Successful: "+successful+
                ", payload: "+payload+" }";
    }
}
