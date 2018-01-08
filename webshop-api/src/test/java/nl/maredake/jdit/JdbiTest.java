//package nl.maredake.jdit;
//
//import com.github.arteam.jdit.DBIRunner;
//import com.github.arteam.jdit.annotations.DBIHandle;
//import com.github.arteam.jdit.annotations.DataSet;
//import com.github.arteam.jdit.annotations.JditProperties;
//import com.github.arteam.jdit.annotations.TestedSqlObject;
//import org.jdbi.v3.core.Handle;
//import org.joda.time.format.ISODateTimeFormat;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//
//@JditProperties("jdit.properties")
//@RunWith(DBIRunner.class)
//public class JdbiTest {
//
//    @TestedSqlObject
//    PlayerDao playerDao;
//
//    @DBIHandle
//    Handle handle;
//
//    @DataSet("schema.sql")
//    @Test
//    public void testCreatePlayer() {
////        System.out.println(date("1991-12-13"));
////        Long playerId = playerDao.createPlayer("Vladimir", "Tarasenko", date("1991-12-13"), 184, 90);
////        //List<Map<String,Object>> rows = handle.select("select * from players where id=?", playerId).mapToMap().list();
////        assertFalse(rows.isEmpty());
////
////        Map<String, Object> row = rows.get(0);
////        assertEquals(1, row.get("id"));
////        assertEquals("Vladimir", row.get("first_name"));
////        assertEquals("Tarasenko", row.get("last_name"));
////        assertEquals(date("1991-12-13"), row.get("birth_date"));
////        assertEquals(184, row.get("height"));
////        assertEquals(90, row.get("weight"));
//    }
//
//    private static Date date(String textDate) {
//        return ISODateTimeFormat.date().parseDateTime(textDate).toDate();
//    }
//}
