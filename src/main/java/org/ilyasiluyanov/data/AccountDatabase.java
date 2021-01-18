package org.ilyasiluyanov.data;

import org.ilyasiluyanov.models.Account;
import org.ilyasiluyanov.models.ClassicAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDatabase<T extends Account> extends CrudRepository<T, Integer> {
}
