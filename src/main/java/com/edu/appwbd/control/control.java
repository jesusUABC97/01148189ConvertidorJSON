package com.edu.appwbd.control;

import com.google.gson.Gson;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;


public class control {


    public static int PRETTY_PRINT_INDENT_FACTOR = 4;

    public Boolean getWorksXML() {
        return worksXML;
    }

    public void setWorksXML(Boolean worksXML) {
        this.worksXML = worksXML;
    }

    public Boolean getWorksJAVA() {
        return worksJAVA;
    }

    public void setWorksJAVA(Boolean worksJAVA) {
        this.worksJAVA = worksJAVA;
    }

    Boolean worksXML = true;
    Boolean worksJAVA = true;
    public String control(String text1, String text2){
        String fin = "";

        if(text2.equals("XML")) {



            try {
                if(text1.startsWith("<")){
                    worksXML = true;

                    JSONObject xml = XML.toJSONObject(text1);
                    fin = xml.toString(PRETTY_PRINT_INDENT_FACTOR);
                    System.out.println(fin);
                }else{
                    worksXML = false;
                }

            } catch (JSONException e) {
                worksXML = false;
                System.out.println(e);
            }
        }else{
            worksJAVA = true;
            String[] cadena = text1.split(",");
            usuario u = new usuario();
            if(cadena.length >= 3) {
                try {


                    u.setPalabra1(cadena[0]);
                    u.setPalabra2(cadena[1]);
                    u.setPalabra3(cadena[2]);
                }catch(Exception e){
                    worksJAVA = false;
                }
            }else{
                worksJAVA = false;
            }

            Gson gson = new Gson();
            fin = gson.toJson(u);
        }


        return  fin;

    }


}
