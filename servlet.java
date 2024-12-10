response.setHeader("Access-Control-Allow-Origin", "*");
		
		try {
		int x=Integer.parseInt(request.getParameter("ch"));
		
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
		
			if (con != null) {
				if(x==1) {
				int roll=Integer.parseInt(request.getParameter("Rollno"));
				String name=request.getParameter("Name");
				String clas=request.getParameter("Class");
				PreparedStatement ps = con.prepareStatement("insert into stud(Rollno,Name,Class) values(?,?,?)");
				ps.setInt(1, roll);
				ps.setString(2, name);
				ps.setString(3, clas);
				ps.executeUpdate();
				}
			 

		
				if(x==2) {
					String name=request.getParameter("Name");
					int roll=Integer.parseInt(request.getParameter("Rollno"));
					PreparedStatement ps = con.prepareStatement("update stud set Name=? where Rollno = ?");
					ps.setString(1, name);
					ps.setInt(2,roll);
					ps.executeUpdate();
				}
				
				
			
			if (x==3 ) {
				int roll=Integer.parseInt(request.getParameter("Rollno"));
				PreparedStatement ps = con.prepareStatement("delete from stud Where Rollno=?");
				ps.setInt(1,roll );
				ps.executeUpdate();
			}
			if (x==4 ) {
				PreparedStatement ps = con.prepareStatement("select * from stud");
				
				ResultSet rs= ps.executeQuery();
				while(rs.next()) {
					int roll=rs.getInt("Rollno");
					System.out.print(roll+" ");
					String Name=rs.getString("Name");
					System.out.print(Name+" ");
					String clas=rs.getString("Class");
					System.out.println(clas);
				}
			}
			}
			else {
				System.out.println("Connection not established");
			}
			
		
			con.close();
		} catch (Exception e) {
			System.out.println("General Error: " + e.getMessage());
		}
