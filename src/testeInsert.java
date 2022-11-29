import java.util.Calendar;

import dao.ContatoDao;
import modelo.Contato;

public class testeInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Contato c = new Contato();
		c.setNome("tânia lima");
		c.setEmail("br@hotmail.com");
		c.setEndereco("R da paz 12");
		c.setDataNascimento(Calendar.getInstance());
		ContatoDao dao = new ContatoDao();
		
		dao.save(c);

	}

}
