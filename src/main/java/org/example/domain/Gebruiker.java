package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Gebruiker {
    private String voornaam;
    private String achternaam;
    private String email;
}
