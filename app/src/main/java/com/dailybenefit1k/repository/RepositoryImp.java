package com.dailybenefit1k.repository;

import com.dailybenefit1k.repository.pref.PrefStorage;

import javax.inject.Inject;
import javax.inject.Singleton;



public class RepositoryImp implements Repository {


    private final  PrefStorage prefStorage;

    @Inject
    public RepositoryImp(PrefStorage prefStorage) {
        this.prefStorage = prefStorage;
    }


    @Override
    public void saveEmail(String email) {
      prefStorage.saveEmail(email);
    }

    @Override
    public String getEmail() {
        return null;
    }
}
