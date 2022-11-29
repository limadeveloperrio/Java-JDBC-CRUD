import dao.ContatoDao;
import modelo.Contato;

public class TesteDelete {

	public static void main(String[] args) {	
		Contato c = new Contato();
		c.setId(2L);
		
		ContatoDao dao = new ContatoDao();
		dao.delete(c);			

	}

}
