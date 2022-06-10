package ar.com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

import ar.com.bean.Persona;
import ar.com.config.DBData;

@Repository
public class PersonaDAOImpl implements PersonaDAO {
	/*
	 * PersonaDAO se encarga de manejar los Beans.
	 */

	/**
	 * Retorna una Lista con todas las Personas agregadas hasta el momento.
	 */
	public List<Persona> getPersonas() {

		List<Persona> lista = new ArrayList<>();

		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName(DBData.JDBC_DRIVER);

			conn = DriverManager.getConnection(DBData.DB_URL, DBData.USER, DBData.PASS);

			String sql = "SELECT * FROM PERSONA";

			stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(sql);

			while (result.next()) {
				String dni = result.getString(1);
				String nombre = result.getString(2);
				String apellido = result.getString(3);
				String fechaNac = result.getString(4);
				String profesion = result.getString(5);

				lista.add(new Persona(nombre, apellido, dni, fechaNac, profesion));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return lista;
	}

	/**
	 * Metodo que agrega la Persona recibida por parametro.
	 */
	public void agregarPersona(Persona per) {

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			Class.forName(DBData.JDBC_DRIVER);

			conn = DriverManager.getConnection(DBData.DB_URL, DBData.USER, DBData.PASS);

			String sql = "INSERT INTO PERSONA(nombre, apellido, dni, fechaNacimiento, profesion) "
					+ " VALUES (?, ?, ?, ?, ?)";

			stmt = conn.prepareStatement(sql);

			stmt.setString(1, per.getNombre());
			stmt.setString(2, per.getApellido());
			stmt.setString(3, per.getDni());
			stmt.setString(4, per.getNacimiento());
			stmt.setString(5, per.getProfesion());

			stmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Metodo que elimina la Persona con el DNI pasado por parametro.
	 */
	public void eliminarPersona(String dni) {

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			Class.forName(DBData.JDBC_DRIVER);

			conn = DriverManager.getConnection(DBData.DB_URL, DBData.USER, DBData.PASS);

			String sql = "DELETE FROM PERSONA WHERE dni = ?";

			stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setString(1, dni);

			stmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Metodo que encuentra y retorna la Persona con el DNI pasado por parametro.
	 * 
	 */
	public Persona encontrarPersona(String dni) {

		Connection conn = null;
		PreparedStatement stmt = null;
		Persona perEncontrada = new Persona();

		try {
			Class.forName(DBData.JDBC_DRIVER);

			conn = DriverManager.getConnection(DBData.DB_URL, DBData.USER, DBData.PASS);

			String sql = "SELECT * FROM PERSONA WHERE dni=?";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, dni);
			ResultSet result = stmt.executeQuery();

			if (result.next()) {

				String nombre = result.getString("nombre");
				String apellido = result.getString("apellido");
				String fechaNac = result.getString("fechaNacimiento");
				String profesion = result.getString("profesion");

				perEncontrada = new Persona(nombre, apellido, dni, fechaNac, profesion);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return perEncontrada;
	}

	/**
	 * Metodo que agrega a la Persona editada y la retorna.
	 */
	public void editar(Persona per) {

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			Class.forName(DBData.JDBC_DRIVER);

			conn = DriverManager.getConnection(DBData.DB_URL, DBData.USER, DBData.PASS);

			String sql = "UPDATE PERSONA SET nombre=?, apellido=?, fechaNacimiento=?, profesion=? WHERE dni=?";

			stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setString(1, per.getNombre());
			stmt.setString(2, per.getApellido());
			stmt.setString(3, per.getNacimiento());
			stmt.setString(4, per.getProfesion());
			stmt.setString(5, per.getDni());

			stmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}