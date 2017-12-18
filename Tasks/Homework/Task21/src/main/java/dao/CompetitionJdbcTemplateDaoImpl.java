package dao;

import models.Competition;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import sun.rmi.transport.Connection;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by EVZabinskaya on 18.12.2017.
 */
public class CompetitionJdbcTemplateDaoImpl implements CompetitionDao{

    //language=SQL
    private static final String SQL_SELECT_COMPETITION_BY_ID = "SELECT * FROM competition  WHERE id = ?";

    //language=SQL
    private static final String SQL_INSERT_COMPETITION_BY_ID = "INSERT INTO competition () VALUES (?,?,?,?,?,?,?,?,?)";

    private JdbcTemplate template;

    private Map<Integer, Competition> competitionMap;

    public CompetitionJdbcTemplateDaoImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
        competitionMap = new HashMap<>();
    }

    private RowMapper<Competition> competitionRowMapper = (resultSet, i) -> Competition.builder()
            .id(resultSet.getInt("id"))
            .formativeOrgUnitId(resultSet.getInt("formativeOrgUnitId"))
            .competitionTypeId(resultSet.getInt("competitionTypeId"))
            .programFormId(resultSet.getInt("programFormId"))
            .programSubjectId(resultSet.getInt("programSubjectId"))
            .levelTypeId(resultSet.getInt("levelTypeId"))
            .programSetOuMinisterialPlan(resultSet.getInt("programSetOuMinisterialPlan"))
            .programSetOuTargetAdmPlan(resultSet.getInt("programSetOuTargetAdmPlan"))
            .programSetOuExclusivePlan(resultSet.getInt("programSetOuExclusivePlan"))
            .programSetOuContractPlan(resultSet.getInt("programSetOuContractPlan"))
            .compensationTypeId(resultSet.getInt("compensationTypeId"))
            .build();


    @Override
    public void save(Competition model) {
    }

    @Override
    public Competition find(final int id) {
        // перехватываем исключение, если такого id нету
        try {
            return template.queryForObject(SQL_SELECT_COMPETITION_BY_ID, competitionRowMapper, id);
        } catch (EmptyResultDataAccessException e) {
            // выбрасываем новое исключение с комментарием
            throw new IllegalArgumentException("Competition with id <" + id + "> not found");
        }
    }

    @Override
    public void update(Competition model) {

    }

    @Override
    public void delete(int id) {

    }

}
