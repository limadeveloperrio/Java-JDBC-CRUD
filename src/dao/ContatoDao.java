package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import connectionFactory.ConnectionFactory;
import modelo.Contato;

public class ContatoDao {
	private Connection connection;

	public ContatoDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void save(Contato contato) {
		String sql = "insert into contatos " + "(nome, email, endereco, dataNascimento)" + " values(?,?,?,?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.execute();
			stmt.close();

			System.out.println("Salvo com sucesso!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Contato> getLista() {
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getNString("endereco"));

				// montando a data através do Calendar
				Calendar data = Calendar.getInstance();
				
				if(rs.getDate("dataNascimento")!=null) {
				data.setTime(rs.getDate("dataNascimento"));
				
				contato.setDataNascimento(data);
				}
				contatos.add(contato);
			}
			rs.close();
			stmt.close();
			return contatos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(Contato contato) {
		String sql = "update contatos set nome=?, email=?, endereco=?, dataNascimento=? where id=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento()
					.getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			
			stmt.execute();		
			
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void delete(Contato contato) {
		String sql ="delete from contatos where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
			System.out.println("Deletdo com sucesso!");
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
}
