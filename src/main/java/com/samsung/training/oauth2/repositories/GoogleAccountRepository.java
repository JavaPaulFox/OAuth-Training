package com.samsung.training.oauth2.repositories;

import com.samsung.training.oauth2.entities.GoogleAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoogleAccountRepository extends CrudRepository<GoogleAccount, Long> {

	List<GoogleAccount> findByGoogleId(String GoogleId);
}
