package dao;

import models.*;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by EVZabinskaya on 18.12.2017.
 */
public class CompetitionJdbcTemplateDaoImpl implements CompetitionDao {

    //language=SQL
    private static final String SQL_SELECT_COMPETITION_BY_ID = "SELECT competition.*,formativeorgunit.*," +
            "compensationtype.title AS compensationtype_title, " +
            "competitiontype.title AS competitiontype_title, " +
            "programform.title AS programform_title, " +
            "leveltype.title AS leveltype_title, " +
            "programsubject.title AS programsubject_title " +
            "FROM competition INNER JOIN " +
                    "formativeorgunit ON competition.formativeorgunitid = formativeorgunit.id  INNER JOIN " +
                    "compensationtype ON competition.compensationtypeid = compensationtype.id  INNER JOIN " +
                    "competitiontype ON competition.competitiontypeid = competitiontype.id  INNER JOIN " +
                    "programform ON competition.programformid = programform.id INNER JOIN " +
                    "leveltype ON competition.leveltypeid = leveltype.id INNER JOIN " +
                    "programsubject ON competition.programsubjectid = programsubject.id " +
            "WHERE competition.id = ?";

    //language=SQL
    private static final String SQL_INSERT_COMPETITION_BY_ID = "INSERT INTO competition () VALUES (?,?,?,?,?,?,?,?,?,?)";

    private JdbcTemplate template;

    private Map<Integer, Competition> competitionMap;

    public CompetitionJdbcTemplateDaoImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
        competitionMap = new HashMap<>();
    }

    private RowMapper<Competition> competitionRowMapper  = new RowMapper<Competition>() {
        @Override
        public Competition mapRow(ResultSet resultSet, int i) throws SQLException {
            Competition competition = Competition.builder()
                    .id(resultSet.getInt("id"))
                    .programSetOuMinisterialPlan(resultSet.getInt("programSetOuMinisterialPlan"))
                    .programSetOuTargetAdmPlan(resultSet.getInt("programSetOuTargetAdmPlan"))
                    .programSetOuExclusivePlan(resultSet.getInt("programSetOuExclusivePlan"))
                    .programSetOuContractPlan(resultSet.getInt("programSetOuContractPlan"))
                    .build();

            FormativeOrgUnit formativeOrgUnit = FormativeOrgUnit.builder()
                    .id(resultSet.getInt("formativeOrgUnitId"))
                    .shortTitle(resultSet.getString("shortTitle"))
                    .fullTitle(resultSet.getString("fullTitle"))
                    .build();

            CompensationType compensationType = CompensationType.builder()
                    .id(resultSet.getInt("compensationTypeId"))
                    .title(resultSet.getString("compensationtype_title"))
                    .build();

            CompetitionType competitionType = CompetitionType.builder()
                    .id(resultSet.getInt("competitionTypeId"))
                    .title(resultSet.getString("competitiontype_title"))
                    .build();

            ProgramForm programForm = ProgramForm.builder()
                    .id(resultSet.getInt("programFormId"))
                    .title(resultSet.getString("programform_title"))
                    .build();

            LevelType levelType = LevelType.builder()
                    .id(resultSet.getInt("levelTypeId"))
                    .title(resultSet.getString("leveltype_title"))
                    .build();

            ProgramSubject programSubject = ProgramSubject.builder()
                    .id(resultSet.getInt("programSubjectId"))
                    .title(resultSet.getString("programsubject_title"))
                    .build();

            competition.setFormativeOrgUnitId(formativeOrgUnit);
            competition.setCompensationTypeId(compensationType);
            competition.setCompetitionTypeId(competitionType);
            competition.setProgramFormId(programForm);
            competition.setLevelTypeId(levelType);
            competition.setProgramSubjectId(programSubject);

            return  competition;
        }
    };


    @Override
    public void insert(Competition model) {

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
