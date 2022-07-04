import javax.xml.crypto.Data;

public class Agendamento {
	private Integer id;
	private Usuario usuario;
	private Data data;

	public Agendamento(Integer id, Usuario usuario, Data data) {
		this.id = id;
		this.usuario = usuario;
		this.data = data;
	}

	public Integer getId() {
		return id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public void setId(Integer id) {
		this.id = id;
	}


}
