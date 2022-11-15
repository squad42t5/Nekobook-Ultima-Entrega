package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class AlunoDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Aluno Aluno) {
		String sql = "INSERT INTO cliente(cpf,telefone,email,nome)" + "VALUES(?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, Aluno.getCpf());
			pstm.setInt(2, Aluno.getFone());
			pstm.setString(3, Aluno.getEmail());
			pstm.setString(4, Aluno.getNome());

			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public void removeByCPF(String cpf) {
		String sql = "DELETE FROM cliente WHERE cpf = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cpf);

			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public List<Aluno> getClientes() {
		String sql = "SELECT * FROM cliente";

		List<Aluno> alunos = new ArrayList<Aluno>();

		Connection conn = null;
		PreparedStatement pstm = null;

		ResultSet rset = null;
		
		try {
			conn = Conexao.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				
				Aluno aluno = new Aluno();
				

				aluno.setCpf(rset.getString("cpf"));
				aluno.setFone(rset.getInt("telefone"));
				aluno.setEmail(rset.getString("email"));
				aluno.setNome(rset.getString("nome"));
				
				alunos.add(aluno);
			
			}}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if (rset!=null) {
						rset.close();
					}
					
					if (pstm!=null) {
						pstm.close();
					}
					
					if (conn!=null) {
						conn.close();
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			return alunos;
	}

	public void update(Aluno Aluno) {
		
		String sql = "UPDATE cliente SET cpf = ?,telefone = ?,email = ?,nome = ? "+
		"WHERE cpf = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar conexão com o banco
			conn = Conexao.createConnectionToMySQL();
			
			//Criar a classe para executar a query
			pstm = conn.prepareStatement(sql);
			
			//Adicionar os valores para atualizar
			pstm.setString(1, Aluno.getCpf());
			pstm.setInt(2, Aluno.getFone());
			pstm.setString(3, Aluno.getEmail());
			pstm.setString(4, Aluno.getNome());
			
			//Qual o ID do registro que deseja atualizar?
			pstm.setString(5, Aluno.getCpf());
			
			//Executar a query
			pstm.execute();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}




}


