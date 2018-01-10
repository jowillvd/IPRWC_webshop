/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hsleiden.service;

import java.util.Optional;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.Authorizer;
import io.dropwizard.auth.basic.BasicCredentials;
import javax.inject.Inject;
import javax.inject.Singleton;

import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.model.Gebruiker;
import nl.hsleiden.persistence.GebruikerDAO;

/**
 *
 * @author Jordy van Dijk
 */
@Singleton
public class AuthenticationService implements Authenticator<BasicCredentials, Gebruiker>, Authorizer<Gebruiker>
{
    private final GebruikerDAO gebruikerDAO;

    @Inject
    public AuthenticationService(GebruikerDAO gebruikerDAO)
    {
        this.gebruikerDAO = gebruikerDAO;
    }

    @Override
    @UnitOfWork
    public Optional<Gebruiker> authenticate(BasicCredentials credentials) throws AuthenticationException
    {
        return gebruikerDAO.findByEmail(credentials.getUsername()).filter(
                gebruiker -> gebruiker.getWachtwoord().equals(credentials.getPassword())
        );
    }

    @Override
    public boolean authorize(Gebruiker gebruiker, String roleName)
    {
        return gebruiker.hasRole(roleName);
    }
}
