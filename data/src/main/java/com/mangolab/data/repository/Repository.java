package com.mangolab.data.repo;

import com.mangolab.domain.model.User;
import java.util.List;
import io.reactivex.Observable;

/**
 * Created by rajforhad on 15/01/2018.
 */
public interface Repository {
	Observable<List<User>> usersList();
	Observable<User> user(final String userId);
}
