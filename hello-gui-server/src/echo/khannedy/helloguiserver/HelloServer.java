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
package echo.khannedy.helloguiserver;

import echo.khannedy.helloguiapi.Hello;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
public class HelloServer extends UnicastRemoteObject implements Hello {

    public HelloServer() throws RemoteException {
    }

    public String sayHello(String nama) throws RemoteException {
        String namaClinet = nama ;
        return "HEELLLOO WELCOME" + nama;
        
    }
}
