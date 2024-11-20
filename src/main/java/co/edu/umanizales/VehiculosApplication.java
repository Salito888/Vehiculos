
package co.edu.umanizales;

import co.edu.umanizales.presenter.LoginPresenter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VehiculosApplication {
	public static void main(String[]args) {
		SpringApplication.run(VehiculosApplication.class, args); new LoginPresenter().mostrarLogin();
	}
}


