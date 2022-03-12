package ca.sait.lab6.dataaccess;


import ca.sait.lab6.models.Role;
import ca.sait.lab6.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class UserDB {

    public List<User> getAll() throws Exception {
        List<User> users = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM user JOIN role ON role.role_id = user.role;";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String email = rs.getString("email");
                boolean active = rs.getBoolean("active");
                String fname = rs.getString("fist_name");
                String lname = rs.getString("last_name");
                String pass = rs.getString("password");
                int roleId = rs.getInt("role_id");
                String roleName = rs.getString("role_name");
                
                Role role;
                role = new Role(roleId,roleName);
                User user;
                user = new User(email,active,fname,lname,pass,role);
                
                users.add(user);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }

        return users;
    }

    public User get(String email) throws Exception {
        User user = null;
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM user JOIN role ON role.role_id = user.role WHERE email=? LIMIT 1";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            
            rs = ps.executeQuery();
            if (rs.next()) {
            
                boolean active = rs.getBoolean("active");
                String fname = rs.getString("fist_name");
                String lname = rs.getString("last_name");
                String pass = rs.getString("password");
                int roleId = rs.getInt("role_id");
                String roleName = rs.getString("role_name");
                
                Role role;
                role = new Role(roleId,roleName);
               
                user = new User(email,active,fname,lname,pass,role);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        
        return user;
    }

    public boolean insert(User user) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO `user`(`email`,`first_name`,`last_name`,`password`,`role`) VALUES (?,?,?,?,?,?);";
        
        boolean inserted = false;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getFname());
            ps.setString(3, user.getLname());
            ps.setString(4, user.getPass());
            ps.setInt(5,user.getRole().getId());
            
            inserted = ps.executeUpdate() !=0;
        }
                finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        
        return inserted;
    }

    public boolean update(User user) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "UPDATE user SET `first_name=?`,`last_name=?`,`password=?`,`role=?` WHERE `email =?`;";
        boolean updated;
        try {
            ps = con.prepareStatement(sql);
           
            ps.setString(1, user.getFname());
            ps.setString(2, user.getLname());
            ps.setString(3, user.getPass());
            ps.setInt(4,user.getRole().getId());
            ps.setString(5, user.getEmail());
            
            updated = ps.executeUpdate() !=0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return updated;
    }

    public void delete(User user) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "DELETE FROM note WHERE note_id=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, note.getNoteId());
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }

}
