/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Company;
import Util.DbUtil;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author anfeg
 */
public class CompanyDAO {

    private Connection connection;

    public CompanyDAO() throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection();
    }

    public void addCompany(Company company) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into company(company_id,name,primary_color,accent_color,sector_id,logo,email,password,basic_color,deleted) values (?,?,?,?,?,?,?,?,?,false)");
        preparedStatement.setString(1, company.getCompany_id());
        preparedStatement.setString(2, company.getName());
        preparedStatement.setString(3, company.getPrimary_color());
        preparedStatement.setString(4, company.getAccent_color());
        preparedStatement.setString(5, company.getSector_id());
        preparedStatement.setString(6, company.getLogo());
        preparedStatement.setString(7, company.getEmail());
        preparedStatement.setString(8, company.getPassword());
        preparedStatement.setBoolean(9, company.isBasic_color());
        preparedStatement.setBoolean(10, company.isDeleted());
        preparedStatement.executeUpdate();
    }

    public void deleteCompany(String company_id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update company set deleted=true where company_id=" + company_id);

        preparedStatement.executeUpdate();
    }

    public void updateCompany(Company company) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update company set name=?,primary_color=?,accent_color=?,sector_id=?,logo=?,email=?,password=?,basic_color=?" + " where company_id=?");
        preparedStatement.setString(1, company.getName());
        preparedStatement.setString(2, company.getPrimary_color());
        preparedStatement.setString(3, company.getAccent_color());
        preparedStatement.setString(4, company.getSector_id());
        preparedStatement.setString(5, company.getLogo());
        preparedStatement.setString(6, company.getEmail());
        preparedStatement.setString(7, company.getPassword());
        preparedStatement.setBoolean(8, company.isBasic_color());
        preparedStatement.setString(9, company.getCompany_id());
        preparedStatement.executeUpdate();
    }
}
