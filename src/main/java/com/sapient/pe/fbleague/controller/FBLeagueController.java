package com.sapient.pe.fbleague.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sapient.pe.fbleague.client.RestClient;

@Controller
@RequestMapping("/report")
public class FBLeagueController {
	
	@Value( "${standings.endpoint}" )
	private String standingsApiURL;
	
	@Value( "${api.key}" )
	private String apiKey;
	
	@Autowired
	private RestClient restClient;
	@RequestMapping(value="/summary", method=RequestMethod.GET)
	
	public ResponseEntity<String> generateSummaryReport() throws IOException{
		
		String result = restClient.getResponse(standingsApiURL+apiKey);
		return ResponseEntity.ok(result);
	}

}
