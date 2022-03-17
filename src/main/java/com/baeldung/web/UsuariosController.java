package com.baeldung.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nimbusds.jose.shaded.json.JSONObject;

@RestController
public class UsuariosController {

    @GetMapping("/usuario/{username}")
    public Object getUsuario(@PathVariable(value = "username") String username) {
    	JSONObject usuario = new JSONObject();
    	usuario.put("id", "1");
    	usuario.put("username", username);
    	
    	List<JSONObject> contactos = new ArrayList<JSONObject>();
    	
    	if(username.equals("admin")){
    		JSONObject contacto = new JSONObject();
    		contacto.put("id", "1");
    		contacto.put("username", "javi");
    		contacto.put("email", "javi@email.com");
    		contactos.add(contacto);
    	}else{
    		JSONObject contacto2 = new JSONObject();
    		contacto2.put("id", "2");
    		contacto2.put("username", "paul");
    		contacto2.put("email", "paul@email.com");
    		contactos.add(contacto2);    		
    	}
    	
    	usuario.put("contactos", contactos);
    	
    	return usuario;
    }
}