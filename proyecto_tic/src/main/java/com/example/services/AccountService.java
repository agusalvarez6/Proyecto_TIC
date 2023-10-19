package com.example.services;

import com.example.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.repository.AccountRepository;

@Service
public class AccountService {
    
    @Autowired
    AccountRepository accountRepository;

    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account autenticarUsuario(String username, String password) {
        Account account = usuarioRepository.findByUsername(username);

        if (account != null && account.getPassword().equals(password)) {
            return account; // Usuario autenticado
        }

        return null; // Usuario no encontrado o contraseña incorrecta
    }

    @GetMapping("/")
    public List<Persona> listarPersonas() {
        return personaService.listarPersonas();
    }
}

