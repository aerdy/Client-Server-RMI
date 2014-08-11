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

package echo.khannedy.databaseclient;

import echo.khannedy.databaseapi.service.PersonService;
import echo.khannedy.databaseclient.form.Form;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.SwingUtilities;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, NotBoundException {
        // TODO code application logic here
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 6789);

        final PersonService service = (PersonService) registry.lookup("service");

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                Form form = new Form(service);
                form.setVisible(true);
            }
        });
    }

}
