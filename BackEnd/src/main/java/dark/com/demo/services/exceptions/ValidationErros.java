package dark.com.demo.services.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationErros extends StandardError {

    private List<String> erros = new ArrayList<>();

    public void addError(String error){
      this.erros.add(error);
    }

    public List<String> getErros() {
      return erros;
    }
}
