package nl.maredake.jdit;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.Date;
import java.util.List;

public interface PlayerDao {

    @GetGeneratedKeys
    @SqlUpdate("insert into players(first_name, last_name, birth_date, weight, height)"
            + " values (:first_name, :last_name, :birth_date, :weight, :height)")
    Long createPlayer(@Bind("first_name") String firstName,
                      @Bind("last_name") String lastName,
                      @Bind("birth_date") Date birthDate,
                      @Bind("height") int height, @Bind("weight") int weight);

    @SqlQuery("select last_name from players order by last_name")
    List<String> getPlayerLastNames();

    @SqlQuery("select count(*) from players where year(birth_date) = :year")
    int getAmountPlayersBornInYear(@Bind("year") int year);

//    @SqlQuery("select * from players where first_name=:first_name and " +
//            "last_name=:last_name")
//    Optional<Player> findPlayer(@Bind("first_name") String firstName,
//                                @Bind("last_name") String lastName);
}
