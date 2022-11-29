import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import dao.ContatoDao;
import modelo.Contato;

public class testeLista {

	public static void main(String[] args) {
		ContatoDao dao = new ContatoDao();
		
		List<Contato> contatos = new ArrayList<Contato>();
		contatos = dao.getLista();
		Date data = null;
		for (Contato contato : contatos) {
			if(contato.getDataNascimento()!=null) {
				 data = contato.getDataNascimento().getTime();
				}
			System.out.print(contato.getNome() + "   " +					
								contato.getEmail() + "   " +
								contato.getEndereco() + "  " +
								data + "\n"
								
					);
			
		}	

	}
}
