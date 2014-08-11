/*
 *  Copyright 2009 Eko Kurniawan Khannedy
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */
package echo.khannedy.databaseserver.service;

import echo.khannedy.databaseapi.entity.Person;
import echo.khannedy.databaseapi.service.PersonService;
import echo.khannedy.databaseserver.utilities.DatabaseUtilities;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
public class PersonServiceServer extends UnicastRemoteObject implements PersonService {

    public PersonServiceServer() throws RemoteException {
    }

    public Person insertPerson(Person person) throws RemoteException {

        System.out.println("Client melakukan proses insert");

        PreparedStatement statement = null;
        try {
            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "INSERT INTO person (id, first_name, last_name, birth_day) values (null, ?, ?, ?)");

            statement.setString(1, person.getFirstName());
            statement.setString(2, person.getLastName());
            statement.setDate(3, new Date(person.getBirthDay().getTime()));

            statement.executeUpdate();

            ResultSet result = statement.getGeneratedKeys();
            if (result.next()) {
                person.setId(result.getLong(1));
            }
            result.close();

            return person;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }

    }

    public void updatePerson(Person person) throws RemoteException {

        System.out.println("Client melakukan proses update");

        PreparedStatement statement = null;

        try {
            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "UPDATE person SET first_name = ?" +
                    ", last_name = ? , birth_day = ? " +
                    "WHERE id = ?");

            statement.setString(1, person.getFirstName());
            statement.setString(2, person.getLastName());
            statement.setDate(3, new Date(person.getBirthDay().getTime()));
            statement.setLong(4, person.getId());

            statement.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        }

    }

    public void deletePerson(Long id) throws RemoteException {

        System.out.println("Client melakukan proses delete");

        PreparedStatement statement = null;

        try {

            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "DELETE FROM person WHERE id = ?");

            statement.setLong(1, id);

            statement.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        }

    }

    public Person getPerson(Long id) throws RemoteException {

        System.out.println("Client melakukan proses get-by-id");

        PreparedStatement statement = null;

        try {

            statement = DatabaseUtilities.getConnection().prepareStatement(
                    "SELECT * FROM person WHERE id = ?");

            ResultSet result = statement.executeQuery();

            Person person = null;

            if (result.next()) {
                person = new Person();
                person.setId(result.getLong("id"));
                person.setFirstName(result.getString("first_name"));
                person.setLastName(result.getString("last_name"));
                person.setBirthDay(result.getDate("birth_day"));
            }

            result.close();

            return person;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        }

    }

    public List<Person> getPerson() throws RemoteException {

        System.out.println("Client melakukan proses get-all");

        Statement statement = null;

        try {
            
            statement = DatabaseUtilities.getConnection().createStatement();
            
            ResultSet result = statement.executeQuery("SELECT * FROM person");
            
            List<Person> list = new ArrayList<Person>();

            while(result.next()){
                Person person = new Person();
                person.setId(result.getLong("id"));
                person.setFirstName(result.getString("first_name"));
                person.setLastName(result.getString("last_name"));
                person.setBirthDay(result.getDate("birth_day"));
                list.add(person);
            }

            result.close();
            
            return list;
            
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        }

    }
}
