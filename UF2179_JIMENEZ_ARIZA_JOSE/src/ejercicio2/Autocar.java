package ejercicio2;

import java.util.Objects;

public class Autocar {
	
	private String matricula;
	private String marca;
	private String modelo;
	private int kilometros;
	private int num_plazas;
	
	public void autocar() {
		this.matricula="";
		this.marca="";
		this.modelo="";
	}
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getKilometros() {
		return kilometros;
	}
	public void setKilometros(int kilometros) {
		this.kilometros = kilometros;
	}
	public int getNum_plazas() {
		return num_plazas;
	}
	public void setNum_plazas(int num_plazas) {
		this.num_plazas = num_plazas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autocar other = (Autocar) obj;
		return Objects.equals(matricula, other.matricula);
	}

	@Override
	public String toString() {
		return "Autocar [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", kilometros="
				+ kilometros + ", num_plazas=" + num_plazas + "]";
	}
	
	

}
