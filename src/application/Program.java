package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		try {

			conn = DB.getConnection();

			st = conn.createStatement(); // montar um comando sql

			rs = st.executeQuery("select * from department"); // retornar resulto em forma de tabela

			while (rs.next()) {
				System.out.println(rs.getInt("id") + " , " + rs.getString("name"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			DB.closeStatement(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}

	}

}