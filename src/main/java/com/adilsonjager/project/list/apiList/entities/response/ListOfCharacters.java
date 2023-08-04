package com.adilsonjager.project.list.apiList.entities.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ListOfCharacters {

    private List<CharacterResponse> results;

}
