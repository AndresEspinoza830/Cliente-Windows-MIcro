/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package pe.isil.cliente_microservicios_3716;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Cliente_microservicios_3716 {
    
    private String url_ws="http://localhost:8090/api_rest/profesores/getAll";

    public static void main(String[] args) {
        try{
            URL url = new URL("http://localhost:8090/api_rest/profesores/getAll");
            HttpURLConnection conexion = (HttpURLConnection)url.openConnection();
            conexion.setRequestMethod("GET");
            conexion.connect();
            
            int httpCode = conexion.getResponseCode();
                    
            if(httpCode == 200){
                StringBuilder informacion = new StringBuilder();
                Scanner escaneo = new Scanner(url.openStream());
                
                while(escaneo.hasNext()){
                    informacion.append(escaneo.nextLine());
                }
                escaneo.close();
                System.out.println(informacion);
            }else{
                throw new RuntimeException("Error de consumo de microservicio " + httpCode);
            }
            
        }catch (Exception e){
             e.printStackTrace();
        }
        
    }
}
