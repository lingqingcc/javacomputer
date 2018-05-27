import com.smart.domain.DAOFactory;
import com.smart.domain.TeacheruserDao;
import com.smart.domain.teacheruser;

public class Test {
    public static void main(String...args) {
        TeacheruserDao dao= DAOFactory.getTeacherDaoInstance();
       // TeacheruserDao dao=new TeacheruserDaoImpl();
        teacheruser teacheruser=new teacheruser();
        teacheruser.setUserid("7777");
        teacheruser.setNames("5444");
        teacheruser.setUsernames("8888");
        teacheruser.setPwd("8888");
        teacheruser.setNumber("8888");
        dao.insert(teacheruser);
        dao.update(teacheruser);
        String userid="33333";
        dao.delete(userid);
        String id="201608020202";
        dao.queryById(id);
        dao.queryAll();
      System.out.println();
    }
}
