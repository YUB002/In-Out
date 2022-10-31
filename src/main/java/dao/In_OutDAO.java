package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.In_OutDTO;

public class In_OutDAO {

	private static In_OutDAO instance;

	synchronized public static In_OutDAO getInstance() throws Exception{
		if(instance==null) {
			instance = new In_OutDAO();
		}
		return instance;
	}

	private In_OutDAO() {}

	private Connection getConnection() throws Exception{
		Context ctx = new InitialContext(); 
		DataSource ds =  (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	} 

	// 메세지 입력
	public int insert(String writer, String contents) throws Exception{

		String sql = "insert into messages values(messages_seq.nextval,?,?)";

		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, writer);
			pstat.setString(2, contents);
			int result = pstat.executeUpdate();
			con.commit();
			con.close();

			return result;
		}
	}

	// 메세지 출력
	public List<In_OutDTO> selectAll() throws Exception {

		String sql = "select * from messages order by 1";

		try(Connection con = this.getConnection();            
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();){

			List <In_OutDTO> list = new ArrayList<>();
			while(rs.next()) {
				In_OutDTO dto = new In_OutDTO();
				dto.setSeq(rs.getInt("seq"));
				dto.setWriter(rs.getString("writer"));
				dto.setContents(rs.getString("contents"));
				list.add(dto);
			}
			return list;
		}
	}
}
