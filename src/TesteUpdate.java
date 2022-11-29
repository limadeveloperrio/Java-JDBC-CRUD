import java.util.Calendar;

import dao.ContatoDao;
import modelo.Contato;

public class TesteUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contato c = new Contato();
		c.setId(1L);
		c.setNome("Maria do Carmo");
		c.setEndereco("R lala 236");
		c.setDataNascimento(Calendar.getInstance());
		
		ContatoDao dao = new ContatoDao();
		dao.update(c);
		System.out.println("Atualizado com sucesso!");

	}

}
